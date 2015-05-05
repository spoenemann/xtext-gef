/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xtext.example.statemachine.graphiti.features

import org.eclipse.graphiti.features.IFeatureProvider
import org.eclipse.graphiti.features.context.IDirectEditingContext
import org.eclipse.graphiti.features.impl.AbstractDirectEditingFeature
import org.eclipse.graphiti.mm.pictograms.Shape
import org.xtext.example.statemachine.statemachine.State

class DirectEditStateFeature extends AbstractDirectEditingFeature {
	
	new(IFeatureProvider fp) {
		super(fp)
	}
	
	override getEditingType() {
		TYPE_TEXT
	}
	
	override canDirectEdit(IDirectEditingContext context) {
		context.pictogramElement.businessObjectForPictogramElement instanceof State
	}
	
	override getInitialValue(IDirectEditingContext context) {
		val state = context.pictogramElement.businessObjectForPictogramElement as State
		return state.name
	}
	
	override setValue(String value, IDirectEditingContext context) {
		val state = context.pictogramElement.businessObjectForPictogramElement as State
		state.name = value
		if (context.pictogramElement instanceof Shape)
			updatePictogramElement((context.pictogramElement as Shape).container)
		else
			updatePictogramElement(context.pictogramElement)
	}
	
}