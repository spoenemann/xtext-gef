/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xtext.example.statemachine.gmf.ui

import com.google.inject.Inject
import org.eclipse.core.runtime.Status
import org.eclipse.emf.common.notify.Notification
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil.Copier
import org.eclipse.emf.transaction.TransactionalEditingDomain
import org.eclipse.swt.widgets.Composite
import org.eclipse.ui.part.ViewPart
import org.eclipse.ui.statushandlers.StatusManager
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.serializer.ISerializer
import org.eclipse.xtext.ui.editor.XtextSourceViewer
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess
import org.eclipse.xtext.ui.editor.model.XtextDocument
import org.xtext.example.statemachine.StatemachineUtil
import org.xtext.example.statemachine.statemachine.State
import org.xtext.example.statemachine.ui.internal.StatemachineActivator

class TextPropertiesViewPart extends ViewPart {

	val resourceProvider =  new EditedResourceProvider(#[State])
	
	@Inject EmbeddedEditorFactory editorFactory
	
	@Inject ISerializer serializer
	
	XtextSourceViewer viewer
	EmbeddedEditorModelAccess modelAccess
	
	State currentViewedState
	TransactionalEditingDomain editingDomain
	String initialContent
	boolean refreshing
	boolean mergingBack
	
	new() {
		super()
		val injector = StatemachineActivator.instance.getInjector('org.xtext.example.statemachine.Statemachine')
		injector.injectMembers(this)
		resourceProvider.addStateChangeListener[object, notification, editingDomain |
			refresh(object as State, notification)
			this.editingDomain = editingDomain
		]
	}
	
	override createPartControl(Composite parent) {
		val editor = editorFactory.newEditor(resourceProvider)
				.showErrorAndWarningAnnotations()
				.withParent(parent)
		modelAccess = editor.createPartialEditor()
		editor.document.addModelListener[documentChanged]
		viewer = editor.viewer
		refresh(resourceProvider.selectedObject as State, null)
		editingDomain = resourceProvider.editingDomain
	}
	
	override dispose() {
		resourceProvider.dispose
		super.dispose()
	}
	
	protected def refresh(State state, Notification notification) {
		if (mergingBack) {
			return
		}
		refreshing = true
		try {
			if (state === currentViewedState && notification !== null) {
				val mergeResult = resourceProvider.mergeForward(state, notification)
				if (mergeResult !== null) {
					val uriFragment = mergeResult.eResource.getURIFragment(mergeResult)
					modelAccess.updateModel(serializer.serialize(mergeResult.eContainer), uriFragment)
					initialContent = modelAccess.editablePart
					return
				}
			}
			
			if (currentViewedState !== null) {
				val content = modelAccess.editablePart
				if (content != initialContent) {
					if (state === currentViewedState) {
						handleDiscardedChanges()
					} else {
						val mergeSource = resourceProvider.mergeBack(currentViewedState, editingDomain)
						if (mergeSource === null)
							handleDiscardedChanges()
					}
				}
			}
			
			if (state === null) {
				modelAccess.updateModel('')
			} else {
				val stateCopy = createSerializableCopy(state)
				val uriFragment = stateCopy.eResource.getURIFragment(stateCopy)
				modelAccess.updateModel(serializer.serialize(stateCopy.eContainer), uriFragment)
				viewer.setSelectedRange(0, 0)
				initialContent = modelAccess.editablePart
			}
			currentViewedState = state
		} finally {
			refreshing = false
		}
	}
	
	protected def createSerializableCopy(EObject object) {
		if (object.eContainer === null)
			throw new IllegalStateException
		val copier = new Copier
		val modelCopy = copier.copy(object.eContainer)
		copier.copyReferences()
		val dummyResource = new XtextResource
		dummyResource.contents += modelCopy
		StatemachineUtil.ensureUniqueIds(dummyResource)
		return copier.get(object)
	}
	
	protected def documentChanged(XtextResource resource) {
		if (!refreshing && currentViewedState !== null) {
			mergingBack = true
			try {
				resourceProvider.mergeBack(currentViewedState, editingDomain)
			} finally {
				mergingBack = false
			}
		}
	}
	
	protected def handleDiscardedChanges() {
		val status = new Status(Status.WARNING, 'org.xtext.example.statemachine.gmf', 'The previous text changes have been discarded.')
		StatusManager.manager.handle(status)
	}
	
	override setFocus() {
		viewer.control.setFocus
	}
	
}