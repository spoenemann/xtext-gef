/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xtext.xproperties

import com.google.inject.Inject
import java.util.ArrayList
import java.util.List
import java.util.concurrent.Executors
import org.eclipse.emf.common.notify.Notification
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.transaction.RecordingCommand
import org.eclipse.emf.transaction.TransactionalEditingDomain
import org.eclipse.swt.graphics.Font
import org.eclipse.swt.graphics.Resource
import org.eclipse.swt.widgets.Composite
import org.eclipse.ui.part.ViewPart
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.resource.SaveOptions
import org.eclipse.xtext.serializer.ISerializer
import org.eclipse.xtext.ui.editor.XtextSourceViewer
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess
import org.eclipse.xtext.util.TextRegion
import org.eclipse.xtext.validation.Issue

class TextPropertiesViewPart extends ViewPart {

	@Inject EditedResourceProvider resourceProvider
	@Inject IModelMerger modelMerger
	@Inject EmbeddedEditorFactory editorFactory
	@Inject EmbeddedResourceValidator resourceValidator
	@Inject ISerializer serializer
	
	val swtResources = new ArrayList<Resource>
	val executorService = Executors.newCachedThreadPool
	
	EObjectSelectionListener selectionListener
	XtextSourceViewer viewer
	EmbeddedEditorModelAccess modelAccess
	
	EObject currentViewedObject
	TransactionalEditingDomain editingDomain
	String lastMergedContent
	boolean refreshing
	boolean mergingBack
	Thread clearStatusThread
	List<Issue> validationErrors
	
	override createPartControl(Composite parent) {
		val editor = editorFactory.newEditor(resourceProvider)
				.showErrorAndWarningAnnotations()
				.withResourceValidator(resourceValidator)
				.processIssuesBy[issues, monitor |
					validationErrors = issues.filter[severity == Severity.ERROR].toList
					executorService.submit[documentChanged()]
				]
				.withParent(parent)
		modelAccess = editor.createPartialEditor()
		viewer = editor.viewer
		viewer.textWidget.font = font
		resourceValidator.embeddedTextProvider = [modelAccess.serializedModel]
		resourceValidator.visibleRegionProvider = [
			val region = viewer.visibleRegion
			new TextRegion(region.offset, region.length)
		]

		selectionListener = new EObjectSelectionListener
		selectionListener.addStateChangeListener[object, notification, editingDomain |
			refresh(object, notification)
			this.editingDomain = editingDomain
		]
		refresh(selectionListener.selectedObject, null)
		editingDomain = selectionListener.editingDomain
	}
	
	protected def getFont() {
		val font = new Font(viewSite.shell.display, 'Courier', 14, 0)
		swtResources += font
		return font
	}
	
	override dispose() {
		selectionListener?.dispose()
		swtResources.forEach[dispose()]
		swtResources.clear()
		executorService.shutdown()
		super.dispose()
	}
	
	protected def refresh(EObject object, Notification notification) {
		if (refreshing || mergingBack) {
			return
		}
		refreshing = true
		try {
			if (object === currentViewedObject && notification !== null) {
				val mergeResult = mergeForward(object, notification)
				if (mergeResult !== null) {
					val uriFragment = mergeResult.eResource.getURIFragment(mergeResult)
					val serializedModel = serializer.serialize(mergeResult.eContainer, SaveOptions.newBuilder.format.options)
					modelAccess.updateModel(serializedModel, uriFragment)
					lastMergedContent = modelAccess.editablePart
					return
				}
			}
			
			if (currentViewedObject !== null) {
				val content = modelAccess.editablePart
				if (content != lastMergedContent) {
					var EObject mergeSource
					if (object !== currentViewedObject && validationErrors.empty) {
						mergeSource = mergeBack(currentViewedObject, editingDomain)
					}
					if (mergeSource === null)
						handleDiscardedChanges()
				}
			}
			
			resourceValidator.originalObject = object
			if (object === null) {
				lastMergedContent = ''
				modelAccess.updateModel(lastMergedContent)
			} else {
				val uriFragment = object.eResource.getURIFragment(object)
				val serializedModel = serializer.serialize(object.eContainer, SaveOptions.newBuilder.format.options)
				modelAccess.updateModel(serializedModel, uriFragment)
				viewer.setSelectedRange(0, 0)
				lastMergedContent = modelAccess.editablePart
			}
			currentViewedObject = object
		} finally {
			refreshing = false
		}
	}
	
	protected def documentChanged() {
		if (!refreshing && !mergingBack && currentViewedObject !== null && validationErrors.empty) {
			mergingBack = true
			try {
				val mergeSource = mergeBack(currentViewedObject, editingDomain)
				if (mergeSource !== null)
					lastMergedContent = modelAccess.editablePart
			} finally {
				mergingBack = false
			}
		}
	}
	
	protected def mergeForward(EObject object, Notification notification) {
		val modelCopy = resourceProvider.resource.parseResult.rootASTElement
		val copy = modelMerger.findMatchingObject(modelCopy, object)
		if (copy === null || copy.eContainer === null) {
			return null
		}
		try {
			modelMerger.apply(notification, copy)
			return copy
		} catch (UnsupportedOperationException uoe) {
			return null
		}
	}
	
	protected def mergeBack(EObject object, TransactionalEditingDomain editingDomain) {
		val modelCopy = resourceProvider.resource.parseResult.rootASTElement
		val copy = modelMerger.findMatchingObject(modelCopy, object)
		if (copy === null || copy.eContainer === null) {
			return null
		}
		editingDomain.commandStack.execute(new RecordingCommand(editingDomain, 'Text Changes') {
			override protected doExecute() {
				modelMerger.merge(copy, object)
			}
		})
		return copy
	}
	
	protected def handleDiscardedChanges() {
		if (clearStatusThread !== null)
			clearStatusThread.interrupt()
		val display = viewSite.shell.display
		val actionBars = #[viewSite.actionBars, selectionListener.currentEditor.editorSite.actionBars]
		display.asyncExec[
			actionBars.forEach[
				statusLineManager.errorMessage = 'Warning: The previous text changes have been discarded due to validation errors.'
			]
		]
		executorService.submit([
			try {
				clearStatusThread = Thread.currentThread
				Thread.sleep(5000)
				display.syncExec[
					actionBars.forEach[
						statusLineManager.errorMessage = null
					]
				]
			} catch (InterruptedException exception) {
			} finally {
				if (clearStatusThread == Thread.currentThread)
					clearStatusThread = null
			}
		] as Runnable)
	}
	
	override setFocus() {
		viewer.control.setFocus
	}
	
}
