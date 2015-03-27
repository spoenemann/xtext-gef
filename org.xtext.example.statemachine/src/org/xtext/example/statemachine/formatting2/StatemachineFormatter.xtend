/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xtext.example.statemachine.formatting2;

import com.google.inject.Inject;
import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.xtext.example.statemachine.services.StatemachineGrammarAccess;
import org.xtext.example.statemachine.statemachine.Command;
import org.xtext.example.statemachine.statemachine.State;
import org.xtext.example.statemachine.statemachine.Statemachine;
import org.xtext.example.statemachine.statemachine.Transition;

class StatemachineFormatter extends AbstractFormatter2 {
	
	@Inject extension StatemachineGrammarAccess

	def dispatch void format(Statemachine statemachine, extension IFormattableDocument document) {
		for (State states : statemachine.getStates()) {
			format(states, document)
		}
		for (Transition transitions : statemachine.getTransitions()) {
			format(transitions, document)
		}
	}

	def dispatch void format(State state, extension IFormattableDocument document) {
		state.append[newLines = 1]
		for (Command actions : state.getActions()) {
			format(actions, document)
		}
	}

	def dispatch void format(Transition transition, extension IFormattableDocument document) {
		transition.append[newLines = 1]
		format(transition.getEvent(), document)
	}
}
