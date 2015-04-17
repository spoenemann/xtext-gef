/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xtext.example.statemachine.gmf.ui

import com.google.inject.Inject
import org.eclipse.emf.common.notify.Notification
import org.eclipse.emf.transaction.TransactionalEditingDomain
import org.eclipse.swt.widgets.Composite
import org.eclipse.ui.part.ViewPart
import org.eclipse.xtext.ui.editor.XtextSourceViewer
import org.xtext.example.statemachine.statemachine.State
import org.xtext.example.statemachine.ui.internal.StatemachineActivator

class TextPropertiesViewPart extends ViewPart {

	val resourceProvider =  new EditedResourceProvider(#[State])
	
	@Inject EmbeddedEditorFactory editorFactory
	
	XtextSourceViewer viewer
	EmbeddedEditorModelAccess modelAccess
	
	State currentViewedState
	TransactionalEditingDomain editingDomain
	String initialContent
	
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
		viewer = editor.viewer
		refresh(resourceProvider.selectedObject as State, null)
		editingDomain = resourceProvider.editingDomain
	}
	
	override dispose() {
		resourceProvider.dispose
		super.dispose()
	}
	
	def refresh(State state, Notification notification) {
		if (state === currentViewedState && notification !== null) {
			val mergeResult = resourceProvider.mergeForward(state, notification)
			if (mergeResult !== null) {
				val stateCopy = resourceProvider.createSerializableCopy(mergeResult)
				modelAccess.updateModel(stateCopy.eContainer, stateCopy)
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
			val stateCopy = resourceProvider.createSerializableCopy(state)
			modelAccess.updateModel(stateCopy.eContainer, stateCopy)
			viewer.setSelectedRange(0, 0)
			initialContent = modelAccess.editablePart
		}
		currentViewedState = state
	}
	
	def handleDiscardedChanges() {
		println('Warning: The previous text changes have been discarded.')
	}
	
	override setFocus() {
		viewer.control.setFocus
	}
	
}