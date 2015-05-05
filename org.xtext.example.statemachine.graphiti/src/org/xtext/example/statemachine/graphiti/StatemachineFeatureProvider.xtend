/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xtext.example.statemachine.graphiti

import org.eclipse.graphiti.dt.IDiagramTypeProvider
import org.eclipse.graphiti.features.context.IAddContext
import org.eclipse.graphiti.features.context.IDirectEditingContext
import org.eclipse.graphiti.features.context.IUpdateContext
import org.eclipse.graphiti.mm.pictograms.ContainerShape
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider
import org.xtext.example.statemachine.graphiti.features.AddStateFeature
import org.xtext.example.statemachine.graphiti.features.AddTransitionFeature
import org.xtext.example.statemachine.graphiti.features.CreateStateFeature
import org.xtext.example.statemachine.graphiti.features.CreateTransitionFeature
import org.xtext.example.statemachine.graphiti.features.DirectEditStateFeature
import org.xtext.example.statemachine.graphiti.features.UpdateStateFeature
import org.xtext.example.statemachine.statemachine.State
import org.xtext.example.statemachine.statemachine.Transition

class StatemachineFeatureProvider extends DefaultFeatureProvider {
	
	new(IDiagramTypeProvider dtp) {
		super(dtp)
	}
	
	override getCreateFeatures() {
		#[ new CreateStateFeature(this) ]
	}
	
	override getCreateConnectionFeatures() {
		#[ new CreateTransitionFeature(this) ]
	}
	
	override getAddFeature(IAddContext context) {
		switch (context.newObject) {
			State: new AddStateFeature(this)
			Transition: new AddTransitionFeature(this)
			default: super.getAddFeature(context)
		}
	}
	
	override getUpdateFeature(IUpdateContext context) {
		val pictogramElement = context.pictogramElement
		if (pictogramElement instanceof ContainerShape) {
			val bo = pictogramElement.businessObjectForPictogramElement
			if (bo instanceof State)
				return new UpdateStateFeature(this)
		}
		super.getUpdateFeature(context)
	}
	
	override getDirectEditingFeature(IDirectEditingContext context) {
		val bo = context.pictogramElement.businessObjectForPictogramElement
		if (bo instanceof State)
			return new DirectEditStateFeature(this)
		super.getDirectEditingFeature(context)
	}
	
}