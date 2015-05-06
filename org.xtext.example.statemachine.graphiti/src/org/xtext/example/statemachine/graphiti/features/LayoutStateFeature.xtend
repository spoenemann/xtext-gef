/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xtext.example.statemachine.graphiti.features

import org.eclipse.graphiti.features.IFeatureProvider
import org.eclipse.graphiti.features.context.ILayoutContext
import org.eclipse.graphiti.features.impl.AbstractLayoutFeature
import org.eclipse.graphiti.mm.algorithms.Text
import org.eclipse.graphiti.mm.pictograms.ContainerShape
import org.eclipse.graphiti.services.Graphiti
import org.eclipse.graphiti.services.IGaService
import org.xtext.example.statemachine.statemachine.State

class LayoutStateFeature extends AbstractLayoutFeature {
	
	val extension IGaService = Graphiti.gaService
	
	new(IFeatureProvider fp) {
		super(fp)
	}
	
	override canLayout(ILayoutContext context) {
		context.pictogramElement instanceof ContainerShape
			&& context.pictogramElement.businessObjectForPictogramElement instanceof State
	}
	
	override layout(ILayoutContext context) {
		val containerShape = context.pictogramElement as ContainerShape
		val primaryGa = containerShape.graphicsAlgorithm
		val text = containerShape.children.map[graphicsAlgorithm].findFirst[it instanceof Text]
		text.setLocationAndSize(0, 0, primaryGa.width, 20)
		return true
	}
	
}