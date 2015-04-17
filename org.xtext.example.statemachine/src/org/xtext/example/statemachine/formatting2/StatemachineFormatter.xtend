/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xtext.example.statemachine.formatting2;

import org.eclipse.xtext.formatting2.AbstractFormatter2
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.xtext.example.statemachine.statemachine.State
import org.xtext.example.statemachine.statemachine.Statemachine
import org.xtext.example.statemachine.statemachine.Transition

import static org.xtext.example.statemachine.statemachine.StatemachinePackage.Literals.*

class StatemachineFormatter extends AbstractFormatter2 {
	
	def dispatch void format(Statemachine statemachine, extension IFormattableDocument document) {
		for (State states : statemachine.getStates()) {
			format(states, document)
		}
		for (Transition transitions : statemachine.getTransitions()) {
			format(transitions, document)
		}
	}

	def dispatch void format(State state, extension IFormattableDocument document) {
		state.append[setNewLines(1, 1, 2)]
		state.regionForKeyword('state').append[oneSpace]
		if (state.name.nullOrEmpty)
			state.regionForFeature(STATE__ID).append[newLines = 1; indent]
		else
			state.regionForFeature(STATE__NAME).prepend[oneSpace].append[newLines = 1; indent]
		state.regionsForKeywords('{').forEach[prepend[oneSpace].append[newLines = 1; indent]]
	}
	
	def dispatch void format(Transition transition, extension IFormattableDocument document) {
		transition.append[setNewLines(1, 1, 2)]
		transition.regionsForKeywords('=>', '(', ')').forEach[
			prepend[oneSpace].append[oneSpace]
		]
	}
}
