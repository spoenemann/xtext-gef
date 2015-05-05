/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xtext.example.statemachine.graphiti.features

import org.eclipse.graphiti.features.IFeatureProvider
import org.eclipse.graphiti.features.context.ICreateContext
import org.eclipse.graphiti.features.impl.AbstractCreateFeature
import org.eclipse.graphiti.mm.pictograms.Diagram
import org.xtext.example.statemachine.statemachine.State
import org.xtext.example.statemachine.statemachine.Statemachine
import org.xtext.example.statemachine.statemachine.StatemachineFactory

class CreateStateFeature extends AbstractCreateFeature {
	
	new(IFeatureProvider fp) {
		super(fp, 'State', 'Create State')
	}
	
	override canCreate(ICreateContext context) {
		context.targetContainer instanceof Diagram
			&& context.targetContainer.businessObjectForPictogramElement instanceof Statemachine
	}
	
	override create(ICreateContext context) {
		val statemachine = context.targetContainer.businessObjectForPictogramElement as Statemachine
		val newState = StatemachineFactory.eINSTANCE.createState()
		newState.name = ''
		newState.id = createUniqueStateId(statemachine)
		statemachine.states += newState
		addGraphicalRepresentation(context, newState)
		featureProvider.directEditingInfo.active = true
		return #[newState]
	}
	
	protected def createUniqueStateId(Statemachine statemachine) {
		var lastNr = 0
		for (State state : statemachine.states) {
			if (state.id.startsWith('_state')) {
				try {
					val nr = Integer.parseInt(state.id.substring(6))
					if (nr > lastNr)
						lastNr = nr
				} catch (NumberFormatException nfe) {}
			}
		}
		return '_state' + (lastNr + 1)
	}
	
}