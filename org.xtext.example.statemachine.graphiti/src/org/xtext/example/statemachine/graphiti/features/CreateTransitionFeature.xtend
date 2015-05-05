/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xtext.example.statemachine.graphiti.features

import org.eclipse.graphiti.features.IFeatureProvider
import org.eclipse.graphiti.features.context.ICreateConnectionContext
import org.eclipse.graphiti.features.context.impl.AddConnectionContext
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature
import org.eclipse.graphiti.mm.pictograms.Connection
import org.xtext.example.statemachine.statemachine.State
import org.xtext.example.statemachine.statemachine.StatemachineFactory
import org.xtext.example.statemachine.statemachine.Statemachine

class CreateTransitionFeature extends AbstractCreateConnectionFeature {
	
	new(IFeatureProvider fp) {
		super(fp, 'Transition', 'Create Transition')
	}
	
	override canCreate(ICreateConnectionContext context) {
		context.sourceAnchor?.parent?.businessObjectForPictogramElement instanceof State
			&& context.targetAnchor?.parent?.businessObjectForPictogramElement instanceof State
	}
	
	override canStartConnection(ICreateConnectionContext context) {
		context.sourceAnchor?.parent?.businessObjectForPictogramElement instanceof State
	}
	
	override create(ICreateConnectionContext context) {
		val source = context.sourceAnchor.parent.businessObjectForPictogramElement as State
		val target = context.targetAnchor.parent.businessObjectForPictogramElement as State
		val transition = StatemachineFactory.eINSTANCE.createTransition()
		transition.sourceState = source
		transition.targetState = target
		val statemachine = source.eContainer as Statemachine
		statemachine.transitions += transition
		val addContext = new AddConnectionContext(context.sourceAnchor, context.targetAnchor)
		addContext.newObject = transition
		return featureProvider.addIfPossible(addContext) as Connection
	}
	
}