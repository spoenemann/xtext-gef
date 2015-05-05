/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xtext.example.statemachine.graphiti

import org.eclipse.graphiti.ui.editor.DiagramEditor
import org.xtext.example.statemachine.statemachine.StatemachineFactory

class NewStatemachineWizard extends GraphitiNewWizard {
	
	new() {
		super('State Machine', 'statemachine_graphiti', 'statemachine', 'statemachine', DiagramEditor.DIAGRAM_EDITOR_ID)
	}
	
	override protected createModel(String name) {
		return StatemachineFactory.eINSTANCE.createStatemachine()
	}
	
}