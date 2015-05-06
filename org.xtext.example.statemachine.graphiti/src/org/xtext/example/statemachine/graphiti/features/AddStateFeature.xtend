/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xtext.example.statemachine.graphiti.features

import org.eclipse.graphiti.features.IFeatureProvider
import org.eclipse.graphiti.features.context.IAddContext
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature
import org.eclipse.graphiti.mm.algorithms.styles.Orientation
import org.eclipse.graphiti.mm.pictograms.Diagram
import org.eclipse.graphiti.services.Graphiti
import org.eclipse.graphiti.services.IGaService
import org.eclipse.graphiti.services.IPeCreateService
import org.eclipse.graphiti.util.IColorConstant
import org.xtext.example.statemachine.statemachine.State

class AddStateFeature extends AbstractAddShapeFeature {
	
	val extension IPeCreateService = Graphiti.peCreateService
	val extension IGaService = Graphiti.gaService
		
	new(IFeatureProvider fp) {
		super(fp)
	}
	
	override canAdd(IAddContext context) {
		context.newObject instanceof State && context.targetContainer instanceof Diagram
	}
	
	override add(IAddContext context) {
		val addedState = context.newObject as State
		val targetDiagram = context.targetContainer as Diagram
		
		val width = if (context.width <= 0) 40 else Math.max(context.width, 20)
		val height = if (context.height <= 0) 40 else Math.max(context.height, 20)

		val containerShape = targetDiagram.createContainerShape(true)
		containerShape.createChopboxAnchor()
		val rectangle = containerShape.createRectangle()
		rectangle.foreground = manageColor(IColorConstant.BLACK)
		rectangle.background = manageColor(IColorConstant.LIGHT_LIGHT_GRAY)
		rectangle.setLocationAndSize(context.x, context.y, width, height)
		link(containerShape, addedState)
 
		val textShape = containerShape.createShape(false)
		val text = textShape.createText(addedState.name)
		text.foreground = manageColor(IColorConstant.BLACK)
		text.horizontalAlignment = Orientation.ALIGNMENT_CENTER
		text.font = diagram.manageFont('Arial', 12)
		link(textShape, addedState)
		val directEditingInfo = featureProvider.directEditingInfo
		directEditingInfo.mainPictogramElement = containerShape
		directEditingInfo.pictogramElement = textShape
		directEditingInfo.graphicsAlgorithm = text
		
		containerShape.layoutPictogramElement()
		return containerShape
	}
	
}