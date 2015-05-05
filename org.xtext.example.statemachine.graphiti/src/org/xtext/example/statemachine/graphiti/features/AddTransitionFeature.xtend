/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xtext.example.statemachine.graphiti.features

import org.eclipse.graphiti.features.IFeatureProvider
import org.eclipse.graphiti.features.context.IAddConnectionContext
import org.eclipse.graphiti.features.context.IAddContext
import org.eclipse.graphiti.features.impl.AbstractAddFeature
import org.eclipse.graphiti.services.Graphiti
import org.eclipse.graphiti.services.IGaService
import org.eclipse.graphiti.services.IPeCreateService
import org.eclipse.graphiti.util.IColorConstant
import org.xtext.example.statemachine.statemachine.Transition

class AddTransitionFeature extends AbstractAddFeature {
	
	val extension IPeCreateService = Graphiti.peCreateService
	val extension IGaService = Graphiti.gaService
	
	new(IFeatureProvider fp) {
		super(fp)
	}
	
	override canAdd(IAddContext context) {
		context instanceof IAddConnectionContext && context.newObject instanceof Transition
	}
	
	override add(IAddContext context) {
		val addConContext = context as IAddConnectionContext
		val addedTransition = context.newObject as Transition
		val connection = diagram.createFreeFormConnection()
		connection.start = addConContext.sourceAnchor
		connection.end = addConContext.targetAnchor
		val polyline = connection.createPolyline()
		polyline.foreground = manageColor(IColorConstant.DARK_GRAY)
		link(connection, addedTransition)
		return connection
	}
	
}