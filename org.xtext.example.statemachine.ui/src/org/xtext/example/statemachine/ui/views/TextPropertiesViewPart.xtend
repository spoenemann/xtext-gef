/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xtext.example.statemachine.ui.views

import com.google.inject.Inject
import java.util.ArrayList
import org.eclipse.emf.common.notify.Notification
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.transaction.RecordingCommand
import org.eclipse.emf.transaction.TransactionalEditingDomain
import org.eclipse.swt.graphics.Font
import org.eclipse.swt.graphics.Resource
import org.eclipse.swt.widgets.Composite
import org.eclipse.ui.part.ViewPart
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.serializer.ISerializer
import org.eclipse.xtext.ui.editor.XtextSourceViewer
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess
import org.xtext.example.statemachine.merging.IModelMerger
import org.xtext.example.statemachine.ui.internal.StatemachineActivator

class TextPropertiesViewPart extends ViewPart {

	@Inject EditedResourceProvider resourceProvider
	
	@Inject IModelMerger modelMerger
	
	@Inject EmbeddedEditorFactory editorFactory
	
	@Inject ISerializer serializer
	
	val swtResources = new ArrayList<Resource>
	
	EObjectSelectionListener selectionListener
	XtextSourceViewer viewer
	EmbeddedEditorModelAccess modelAccess
	
	EObject currentViewedObject
	TransactionalEditingDomain editingDomain
	String lastMergedContent
	boolean refreshing
	boolean mergingBack
	Thread clearStatusThread
	
	new() {
		super()
		val injector = StatemachineActivator.instance.getInjector('org.xtext.example.statemachine.Statemachine')
		injector.injectMembers(this)
	}
	
	override createPartControl(Composite parent) {
		val editor = editorFactory.newEditor(resourceProvider)
				.showErrorAndWarningAnnotations()
				.withParent(parent)
		modelAccess = editor.createPartialEditor()
		editor.document.addModelListener[documentChanged]
		viewer = editor.viewer
		viewer.textWidget.font = font

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
					modelAccess.updateModel(serializer.serialize(mergeResult.eContainer), uriFragment)
					lastMergedContent = modelAccess.editablePart
					return
				}
			}
			
			if (currentViewedObject !== null) {
				val content = modelAccess.editablePart
				if (content != lastMergedContent) {
					var EObject mergeSource
					if (object !== currentViewedObject && resourceProvider.resource.parseResult.syntaxErrors.empty) {
						mergeSource = mergeBack(currentViewedObject, editingDomain)
					}
					if (mergeSource === null)
						handleDiscardedChanges()
				}
			}
			
			if (object === null) {
				lastMergedContent = ''
				modelAccess.updateModel(lastMergedContent)
			} else {
				val uriFragment = object.eResource.getURIFragment(object)
				modelAccess.updateModel(serializer.serialize(object.eContainer), uriFragment)
				viewer.setSelectedRange(0, 0)
				lastMergedContent = modelAccess.editablePart
			}
			currentViewedObject = object
		} finally {
			refreshing = false
		}
	}
	
	protected def documentChanged(XtextResource resource) {
		if (!refreshing && !mergingBack && currentViewedObject !== null && resource.parseResult.syntaxErrors.empty) {
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
	
	protected def <T extends EObject> mergeForward(T object, Notification notification) {
		val modelCopy = resourceProvider.resource.parseResult.rootASTElement
		val copy = modelMerger.findMatchingObject(modelCopy, object)
		if (copy === null || copy.eContainer === null) {
			return null
		}
		try {
			modelMerger.apply(notification, copy)
			return copy as T
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
		if (clearStatusThread !== null && clearStatusThread.alive)
			clearStatusThread.interrupt()
		val display = viewSite.shell.display
		val actionBars = #[viewSite.actionBars, selectionListener.currentEditor.editorSite.actionBars]
		display.asyncExec[
			actionBars.forEach[
				statusLineManager.errorMessage = 'Warning: The previous text changes have been discarded due to syntax errors.'
			]
		]
		clearStatusThread = new Thread[
			try {
				Thread.sleep(5000)
				display.syncExec[
					actionBars.forEach[
						statusLineManager.errorMessage = null
					]
				]
			} catch (InterruptedException exception) {}
		]
		clearStatusThread.start
	}
	
	override setFocus() {
		viewer.control.setFocus
	}
	
}
