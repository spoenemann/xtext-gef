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
import org.xtext.example.statemachine.StatemachineUtil
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
		statemachine.states += newState
		StatemachineUtil.ensureUniqueIds(statemachine.eResource)
		addGraphicalRepresentation(context, newState)
		featureProvider.directEditingInfo.active = true
		return #[newState]
	}
	
}