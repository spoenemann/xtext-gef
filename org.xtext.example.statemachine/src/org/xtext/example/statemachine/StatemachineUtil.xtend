/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xtext.example.statemachine

import java.util.HashSet
import java.util.Set
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.xtext.example.statemachine.statemachine.State
import org.xtext.example.statemachine.statemachine.Statemachine
import org.xtext.example.statemachine.statemachine.StatemachineFactory
import org.eclipse.emf.common.notify.Notification
import org.xtext.example.statemachine.statemachine.StatemachinePackage

final class StatemachineUtil {
	
	private static class Context {
		int lastNr
	}
	
	static def void ensureUniqueIds(Resource resource) {
		val assignedIds = new HashSet<String>
		resource.contents.filter(Statemachine).forEach[transitions.forEach[
			if (sourceState.eResource != resource)
				assignedIds.add(sourceState.id)
			if (targetState.eResource != resource)
				assignedIds.add(targetState.id)
		]]
		val context = new Context
		resource.contents.filter(Statemachine).forEach[ensureUniqueIds(context, assignedIds)]
	}
	
	private static def void ensureUniqueIds(Statemachine model, Context context, Set<String> assignedIds) {
		for (State state : model.states) {
			if (state.id.nullOrEmpty || state.id.startsWith('_state')) {
				do {
					context.lastNr++
				} while (assignedIds.contains('_state' + context.lastNr))
				state.id = '_state' + context.lastNr
			} else if (assignedIds.contains(state.id)) {
				do {
					context.lastNr++
				} while (assignedIds.contains(state.id + '_' + context.lastNr))
				state.id = state.id + '_' + context.lastNr
			}
			assignedIds.add(state.id)
		}
	}
	
	static def copyFeatures(EObject source, EObject destination) {
		if (source.eClass != destination.eClass)
			throw new IllegalArgumentException
		else if (source instanceof State && destination instanceof State)
			copyFeatures(source as State, destination as State)
		else
			throw new UnsupportedOperationException(destination.eClass.name + ' not supported')
	}
	
	private static def copyFeatures(State source, State destination) {
		destination.name = source.name
		destination.actions.clear
		for (sourceCommand : source.actions) {
			val newCommand = StatemachineFactory.eINSTANCE.createCommand
			newCommand.code = sourceCommand.code
			destination.actions += newCommand
		}
	}
	
	static def apply(Notification notification, EObject destination) {
		if (destination instanceof State)
			apply(notification, destination as State)
		else
			throw new UnsupportedOperationException('Type ' + destination.eClass.name + ' not supported')
	}
	
	private static def apply(Notification notification, State destination) {
		switch notification.feature {
			case StatemachinePackage.Literals.STATE__NAME:
				destination.name = notification.newStringValue
			default:
				throw new UnsupportedOperationException('Feature ' + notification.feature?.toString + ' not supported')
		}
	}
	
}