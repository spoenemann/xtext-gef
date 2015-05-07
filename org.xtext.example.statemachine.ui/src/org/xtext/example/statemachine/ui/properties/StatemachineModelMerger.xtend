/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xtext.example.statemachine.ui.properties

import java.util.Map
import org.eclipse.emf.common.notify.Notification
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil.Copier
import org.xtext.example.statemachine.statemachine.Command
import org.xtext.example.statemachine.statemachine.State
import org.xtext.example.statemachine.statemachine.StatePropertyExpression
import org.xtext.example.statemachine.statemachine.Statemachine
import org.xtext.xproperties.IModelMerger

import static org.xtext.example.statemachine.statemachine.StatemachinePackage.Literals.*

class StatemachineModelMerger implements IModelMerger {
	
	override findMatchingObject(EObject model, EObject object) {
		if (!(model instanceof Statemachine))
			throw new UnsupportedOperationException('Model ' + model.eClass.name + ' not supported')
		else if (object instanceof State)
			findMatchingState(model as Statemachine, object)
		else
			throw new UnsupportedOperationException('Type ' + object.eClass.name + ' not supported')
	}
	
	protected def findMatchingState(Statemachine statemachine, State state) {
		statemachine.states.findFirst[id == state.id]
	}
	
	override merge(EObject source, EObject destination) {
		if (source.eClass != destination.eClass)
			throw new IllegalArgumentException
		else if (destination instanceof State)
			merge(source as State, destination)
		else
			throw new UnsupportedOperationException('Type ' + destination.eClass.name + ' not supported')
	}
	
	protected def merge(State source, State destination) {
		destination.name = source.name
		destination.initial = source.initial
		destination.final = source.final
		destination.actions.clear
		for (sourceCommand : source.actions) {
			val copier = new Copier
			val newCommand = copier.copy(sourceCommand) as Command
			link(sourceCommand, copier, destination.eContainer as Statemachine)
			destination.actions += newCommand
		}
	}
	
	protected def link(EObject object, Map<EObject, EObject> copyMap, Statemachine destinationModel) {
		object.eAllContents.filter(StatePropertyExpression).filter[state !== null].forEach[ expression |
			val stateId = expression.state.id
			val newExpression = copyMap.get(expression) as StatePropertyExpression
			newExpression.state = destinationModel.states.findFirst[id == stateId]
		]
	}
	
	override apply(Notification notification, EObject destination) {
		if (destination instanceof State)
			apply(notification, destination)
		else
			throw new UnsupportedOperationException('Type ' + destination.eClass.name + ' not supported')
	}
	
	protected def apply(Notification notification, State destination) {
		switch notification.feature {
			case STATE__ID:
				destination.id = notification.newStringValue
			case STATE__NAME:
				destination.name = notification.newStringValue
			default:
				throw new UnsupportedOperationException('Feature ' + notification.feature?.toString + ' not supported')
		}
	}
	
}
