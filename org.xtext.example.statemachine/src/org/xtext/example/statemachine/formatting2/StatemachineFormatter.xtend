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
import org.xtext.example.statemachine.statemachine.ExecuteCommand
import org.xtext.example.statemachine.statemachine.PrintCommand
import org.xtext.example.statemachine.statemachine.SetCommand
import org.xtext.example.statemachine.statemachine.State
import org.xtext.example.statemachine.statemachine.Statemachine
import org.xtext.example.statemachine.statemachine.Transition

import static org.xtext.example.statemachine.statemachine.StatemachinePackage.Literals.*
import org.xtext.example.statemachine.statemachine.StatePropertyExpression

class StatemachineFormatter extends AbstractFormatter2 {
	
	def dispatch void format(Statemachine statemachine, extension IFormattableDocument document) {
		for (State state : statemachine.getStates()) {
			state.format
		}
		for (Transition transition : statemachine.getTransitions()) {
			transition.format
		}
	}

	def dispatch void format(State state, extension IFormattableDocument document) {
		if (state.initial)
			state.regionFor.keyword('initial').append[oneSpace]
		if (state.final)
			state.regionFor.keyword('final').append[oneSpace]
		interior(
			state.regionFor.keyword('state').append[oneSpace],
			state.regionFor.keyword('end'),
			[indent]
		)
		if (state.name !== null) {
			state.regionFor.feature(STATE__NAME).prepend[oneSpace]
		}
		state.regionFor.keyword('actions').prepend[newLine].append[oneSpace]
		interior(
			state.regionFor.keyword('{').append[newLine],
			state.regionFor.keyword('}').append[newLine],
			[indent]
		)
		state.append[setNewLines(1, 1, 2)]
		for (command : state.actions) {
			command.format
		}
	}
	
	def dispatch void format(Transition transition, extension IFormattableDocument document) {
		transition.regionFor.keywords('=>', '(', ')').forEach[
			surround[oneSpace]
		]
		transition.append[setNewLines(1, 1, 2)]
		transition.event.format
	}
	
	def dispatch void format(SetCommand command, extension IFormattableDocument document) {
		command.regionFor.keyword('set').append[oneSpace]
		command.regionFor.feature(SET_COMMAND__SIGNAL).append[oneSpace]
		command.regionFor.keyword('=').append[oneSpace]
		command.append[newLine]
		command.value.format
	}
	
	def dispatch void format(ExecuteCommand command, extension IFormattableDocument document) {
		command.regionFor.keyword('execute').append[oneSpace]
		command.regionFor.keyword('(').surround[noSpace]
		command.regionFor.keywords(',').forEach[prepend[noSpace] append[oneSpace]]
		command.regionFor.keyword(')').prepend[noSpace]
		command.append[newLine]
		for (expression : command.arguments) {
			expression.format
		}
	}
	
	def dispatch void format(PrintCommand command, extension IFormattableDocument document) {
		command.regionFor.keyword('print').append[oneSpace]
		command.append[newLine]
		command.value.format
	}
	
	def dispatch void format(StatePropertyExpression expression, extension IFormattableDocument document) {
		expression.regionFor.keyword('.').surround[noSpace]
	}
	
}
