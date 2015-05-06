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
import org.eclipse.emf.ecore.resource.Resource
import org.xtext.example.statemachine.statemachine.State
import org.xtext.example.statemachine.statemachine.Statemachine

final class StatemachineUtil {
	
	private static class Context {
		int lastNr
	}
	
	static def void ensureUniqueIds(Resource resource) {
		val assignedIds = new HashSet<String>
		resource.contents.filter(Statemachine).forEach[transitions.forEach[
			if (sourceState !== null && sourceState.eResource != resource)
				assignedIds.add(sourceState.id)
			if (targetState !== null && targetState.eResource != resource)
				assignedIds.add(targetState.id)
		]]
		val context = new Context
		resource.contents.filter(Statemachine).forEach[ensureUniqueIds(context, assignedIds)]
	}
	
	private static def void ensureUniqueIds(Statemachine model, Context context, Set<String> assignedIds) {
		for (State state : model.states) {
			if (state.id.nullOrEmpty || state.id.startsWith('_state') && assignedIds.contains(state.id)) {
				do {
					context.lastNr++
				} while (assignedIds.contains('_state' + context.lastNr))
				state.id = '_state' + context.lastNr
			} else if (state.id.startsWith('_state')) {
				try {
					context.lastNr = Integer.parseInt(state.id.substring(6))
				} catch (NumberFormatException nfe) {}
			} else if (assignedIds.contains(state.id)) {
				do {
					context.lastNr++
				} while (assignedIds.contains(state.id + '_' + context.lastNr))
				state.id = state.id + '_' + context.lastNr
			}
			assignedIds.add(state.id)
		}
	}
	
}