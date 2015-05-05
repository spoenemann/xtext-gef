/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xtext.example.statemachine.graphiti.features

import org.eclipse.graphiti.features.IFeatureProvider
import org.eclipse.graphiti.features.context.IUpdateContext
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature
import org.eclipse.graphiti.features.impl.Reason
import org.eclipse.graphiti.mm.algorithms.Text
import org.eclipse.graphiti.mm.pictograms.ContainerShape
import org.xtext.example.statemachine.statemachine.State

class UpdateStateFeature extends AbstractUpdateFeature {
	
	new(IFeatureProvider fp) {
		super(fp)
	}
	
	override canUpdate(IUpdateContext context) {
		context.pictogramElement instanceof ContainerShape
			&& context.pictogramElement.businessObjectForPictogramElement instanceof State
	}
	
	override updateNeeded(IUpdateContext context) {
		val containerShape = context.pictogramElement as ContainerShape 
		var String pictogramName = containerShape.children.map[graphicsAlgorithm].filter(Text).head?.value
 
		var String businessName
		val bo = containerShape.businessObjectForPictogramElement
		if (bo instanceof State)
			businessName = bo.name
 
		if (pictogramName != businessName) {
			return Reason.createTrueReason("Name is out of date")
		} else {
			return Reason.createFalseReason()
		}
	}
	
	override update(IUpdateContext context) {
		val containerShape = context.pictogramElement as ContainerShape 
		var String businessName
		val bo = containerShape.businessObjectForPictogramElement
		if (bo instanceof State)
			businessName = bo.name

		containerShape.children.map[graphicsAlgorithm].filter(Text).head?.setValue(businessName)
 
		return false;
	}
	
}