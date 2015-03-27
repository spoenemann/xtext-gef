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
					put(grammarAccess.getStatemachineAccess().getGroup(), "rule__Statemachine__Group__0");
					put(grammarAccess.getStateAccess().getGroup(), "rule__State__Group__0");
					put(grammarAccess.getStateAccess().getGroup_2(), "rule__State__Group_2__0");
					put(grammarAccess.getTransitionAccess().getGroup(), "rule__Transition__Group__0");
					put(grammarAccess.getTransitionAccess().getGroup_3(), "rule__Transition__Group_3__0");
					put(grammarAccess.getStatemachineAccess().getStatesAssignment_1_0(), "rule__Statemachine__StatesAssignment_1_0");
					put(grammarAccess.getStatemachineAccess().getTransitionsAssignment_1_1(), "rule__Statemachine__TransitionsAssignment_1_1");
					put(grammarAccess.getStateAccess().getNameAssignment_1(), "rule__State__NameAssignment_1");
					put(grammarAccess.getStateAccess().getActionsAssignment_2_2(), "rule__State__ActionsAssignment_2_2");
					put(grammarAccess.getTransitionAccess().getSourceStateAssignment_0(), "rule__Transition__SourceStateAssignment_0");
					put(grammarAccess.getTransitionAccess().getTargetStateAssignment_2(), "rule__Transition__TargetStateAssignment_2");
					put(grammarAccess.getTransitionAccess().getEventAssignment_3_1(), "rule__Transition__EventAssignment_3_1");
					put(grammarAccess.getEventAccess().getCodeAssignment(), "rule__Event__CodeAssignment");
					put(grammarAccess.getCommandAccess().getCodeAssignment(), "rule__Command__CodeAssignment");
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
