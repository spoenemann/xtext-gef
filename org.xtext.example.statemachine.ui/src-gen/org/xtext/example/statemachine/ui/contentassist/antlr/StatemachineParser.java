/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xtext.example.statemachine.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractPartialContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import org.xtext.example.statemachine.services.StatemachineGrammarAccess;

public class StatemachineParser extends AbstractPartialContentAssistParser {
	
	@Inject
	private StatemachineGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected org.xtext.example.statemachine.ui.contentassist.antlr.internal.InternalStatemachineParser createParser() {
		org.xtext.example.statemachine.ui.contentassist.antlr.internal.InternalStatemachineParser result = new org.xtext.example.statemachine.ui.contentassist.antlr.internal.InternalStatemachineParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getStatemachineAccess().getAlternatives_1(), "rule__Statemachine__Alternatives_1");
					put(grammarAccess.getCommandAccess().getAlternatives(), "rule__Command__Alternatives");
					put(grammarAccess.getExpressionAccess().getAlternatives(), "rule__Expression__Alternatives");
					put(grammarAccess.getPropertyAccess().getAlternatives(), "rule__Property__Alternatives");
					put(grammarAccess.getStatemachineAccess().getGroup(), "rule__Statemachine__Group__0");
					put(grammarAccess.getStateAccess().getGroup(), "rule__State__Group__0");
					put(grammarAccess.getStateAccess().getGroup_5(), "rule__State__Group_5__0");
					put(grammarAccess.getTransitionAccess().getGroup(), "rule__Transition__Group__0");
					put(grammarAccess.getTransitionAccess().getGroup_3(), "rule__Transition__Group_3__0");
					put(grammarAccess.getSetCommandAccess().getGroup(), "rule__SetCommand__Group__0");
					put(grammarAccess.getExecuteCommandAccess().getGroup(), "rule__ExecuteCommand__Group__0");
					put(grammarAccess.getExecuteCommandAccess().getGroup_3(), "rule__ExecuteCommand__Group_3__0");
					put(grammarAccess.getExecuteCommandAccess().getGroup_3_1(), "rule__ExecuteCommand__Group_3_1__0");
					put(grammarAccess.getPrintCommandAccess().getGroup(), "rule__PrintCommand__Group__0");
					put(grammarAccess.getStatePropertyExpressionAccess().getGroup(), "rule__StatePropertyExpression__Group__0");
					put(grammarAccess.getStatemachineAccess().getStatesAssignment_1_0(), "rule__Statemachine__StatesAssignment_1_0");
					put(grammarAccess.getStatemachineAccess().getTransitionsAssignment_1_1(), "rule__Statemachine__TransitionsAssignment_1_1");
					put(grammarAccess.getStateAccess().getInitialAssignment_0(), "rule__State__InitialAssignment_0");
					put(grammarAccess.getStateAccess().getFinalAssignment_1(), "rule__State__FinalAssignment_1");
					put(grammarAccess.getStateAccess().getIdAssignment_3(), "rule__State__IdAssignment_3");
					put(grammarAccess.getStateAccess().getNameAssignment_4(), "rule__State__NameAssignment_4");
					put(grammarAccess.getStateAccess().getActionsAssignment_5_2(), "rule__State__ActionsAssignment_5_2");
					put(grammarAccess.getTransitionAccess().getSourceStateAssignment_0(), "rule__Transition__SourceStateAssignment_0");
					put(grammarAccess.getTransitionAccess().getTargetStateAssignment_2(), "rule__Transition__TargetStateAssignment_2");
					put(grammarAccess.getTransitionAccess().getEventAssignment_3_1(), "rule__Transition__EventAssignment_3_1");
					put(grammarAccess.getSetCommandAccess().getSignalAssignment_1(), "rule__SetCommand__SignalAssignment_1");
					put(grammarAccess.getSetCommandAccess().getValueAssignment_3(), "rule__SetCommand__ValueAssignment_3");
					put(grammarAccess.getExecuteCommandAccess().getOperationAssignment_1(), "rule__ExecuteCommand__OperationAssignment_1");
					put(grammarAccess.getExecuteCommandAccess().getArgumentsAssignment_3_0(), "rule__ExecuteCommand__ArgumentsAssignment_3_0");
					put(grammarAccess.getExecuteCommandAccess().getArgumentsAssignment_3_1_1(), "rule__ExecuteCommand__ArgumentsAssignment_3_1_1");
					put(grammarAccess.getPrintCommandAccess().getValueAssignment_1(), "rule__PrintCommand__ValueAssignment_1");
					put(grammarAccess.getVerbatimExpressionAccess().getCodeAssignment(), "rule__VerbatimExpression__CodeAssignment");
					put(grammarAccess.getStatePropertyExpressionAccess().getStateAssignment_0(), "rule__StatePropertyExpression__StateAssignment_0");
					put(grammarAccess.getStatePropertyExpressionAccess().getPropertyAssignment_2(), "rule__StatePropertyExpression__PropertyAssignment_2");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			org.xtext.example.statemachine.ui.contentassist.antlr.internal.InternalStatemachineParser typedParser = (org.xtext.example.statemachine.ui.contentassist.antlr.internal.InternalStatemachineParser) parser;
			typedParser.entryRuleStatemachine();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public StatemachineGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(StatemachineGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
