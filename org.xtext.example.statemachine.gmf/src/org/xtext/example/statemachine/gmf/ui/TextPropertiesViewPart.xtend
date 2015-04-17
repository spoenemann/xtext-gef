/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xtext.example.statemachine.gmf.ui

import com.google.inject.Inject
import org.eclipse.swt.widgets.Composite
import org.eclipse.ui.part.ViewPart
import org.eclipse.xtext.ui.editor.XtextSourceViewer
import org.xtext.example.statemachine.statemachine.State
import org.xtext.example.statemachine.ui.internal.StatemachineActivator

class TextPropertiesViewPart extends ViewPart {

	@Inject EditedResourceProvider resourceProvider
	
	@Inject EmbeddedEditorFactory editorFactory
	
	XtextSourceViewer viewer
	
	EmbeddedEditorModelAccess modelAccess
	
	new() {
		super()
		val injector = StatemachineActivator.instance.getInjector('org.xtext.example.statemachine.Statemachine')
		injector.injectMembers(this)
		resourceProvider.addStateChangeListener[refresh(it)]
	}
	
	override createPartControl(Composite parent) {
		val editor = editorFactory.newEditor(resourceProvider)
				.showErrorAndWarningAnnotations()
				.withParent(parent)
		modelAccess = editor.createPartialEditor()
		viewer = editor.viewer
		refresh(resourceProvider.selectedState)
	}
	
	override dispose() {
		resourceProvider.dispose
		super.dispose()
	}
	
	def refresh(State state) {
		if (state === null) {
			modelAccess.updateModel('')
		} else {
			val stateCopy = resourceProvider.copy(state)
			modelAccess.updateModel(stateCopy.eContainer, stateCopy)
			viewer.setSelectedRange(0, 0)
		}
	}
	
	override setFocus() {
		viewer.control.setFocus
	}
	
}