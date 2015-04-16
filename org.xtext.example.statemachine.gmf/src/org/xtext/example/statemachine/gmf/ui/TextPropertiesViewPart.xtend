/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xtext.example.statemachine.gmf.ui

import com.google.inject.Provider
import org.eclipse.swt.SWT
import org.eclipse.swt.widgets.Composite
import org.eclipse.ui.part.ViewPart
import org.eclipse.xtext.ui.editor.XtextSourceViewer
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory
import org.xtext.example.statemachine.statemachine.State
import org.xtext.example.statemachine.ui.internal.StatemachineActivator
import org.eclipse.swt.custom.StackLayout

class TextPropertiesViewPart extends ViewPart {

	val EditedResourceProvider resourceProvider = new EditedResourceProvider[refresh(it)]
	
	val Provider<EmbeddedEditorFactory.Builder> builderProvider = [
		val injector = StatemachineActivator.instance.getInjector('org.xtext.example.statemachine.Statemachine')
		injector.getInstance(EmbeddedEditorFactory.Builder)
	]
	
	Composite parent
	
	XtextSourceViewer viewer
	
	override createPartControl(Composite parent) {
		val container = new Composite(parent, SWT.NONE)
		container.layout = new StackLayout
		this.parent = container
		refresh(resourceProvider.selectedState)
	}
	
	override dispose() {
		resourceProvider.dispose
		super.dispose()
	}
	
	def refresh(State state) {
		if (viewer != null) {
			viewer.control.dispose
			viewer = null
		}
		if (state !== null) {
			val textParts = resourceProvider.createTextParts
			val editorFactory = new EmbeddedEditorFactory
			editorFactory.builderProvider = builderProvider
			val editor = editorFactory.newEditor(resourceProvider)
					.showErrorAndWarningAnnotations()
					.withParent(parent)
			editor.createPartialEditor(textParts.get(0), textParts.get(1), textParts.get(2), true)
			viewer = editor.viewer;
			(parent.getLayout as StackLayout).topControl = editor.viewer.control
			parent.layout()
		}
	}
	
	override setFocus() {
		if (viewer != null)
			viewer.control.setFocus
	}
	
}