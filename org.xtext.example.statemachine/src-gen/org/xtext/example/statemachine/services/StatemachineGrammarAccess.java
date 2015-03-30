/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xtext.example.statemachine.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.eclipse.xtext.common.services.TerminalsGrammarAccess;

@Singleton
public class StatemachineGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class StatemachineElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Statemachine");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cStatemachineAction_0 = (Action)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Assignment cStatesAssignment_1_0 = (Assignment)cAlternatives_1.eContents().get(0);
		private final RuleCall cStatesStateParserRuleCall_1_0_0 = (RuleCall)cStatesAssignment_1_0.eContents().get(0);
		private final Assignment cTransitionsAssignment_1_1 = (Assignment)cAlternatives_1.eContents().get(1);
		private final RuleCall cTransitionsTransitionParserRuleCall_1_1_0 = (RuleCall)cTransitionsAssignment_1_1.eContents().get(0);
		
		//Statemachine:
		//	{Statemachine} (states+=State | transitions+=Transition)*;
		@Override public ParserRule getRule() { return rule; }

		//{Statemachine} (states+=State | transitions+=Transition)*
		public Group getGroup() { return cGroup; }

		//{Statemachine}
		public Action getStatemachineAction_0() { return cStatemachineAction_0; }

		//(states+=State | transitions+=Transition)*
		public Alternatives getAlternatives_1() { return cAlternatives_1; }

		//states+=State
		public Assignment getStatesAssignment_1_0() { return cStatesAssignment_1_0; }

		//State
		public RuleCall getStatesStateParserRuleCall_1_0_0() { return cStatesStateParserRuleCall_1_0_0; }

		//transitions+=Transition
		public Assignment getTransitionsAssignment_1_1() { return cTransitionsAssignment_1_1; }

		//Transition
		public RuleCall getTransitionsTransitionParserRuleCall_1_1_0() { return cTransitionsTransitionParserRuleCall_1_1_0; }
	}

	public class StateElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "State");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cStateKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cIdAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cIdIDTerminalRuleCall_1_0 = (RuleCall)cIdAssignment_1.eContents().get(0);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameSTRINGTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cActionsKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_3_1 = (Keyword)cGroup_3.eContents().get(1);
		private final Assignment cActionsAssignment_3_2 = (Assignment)cGroup_3.eContents().get(2);
		private final RuleCall cActionsCommandParserRuleCall_3_2_0 = (RuleCall)cActionsAssignment_3_2.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_3_3 = (Keyword)cGroup_3.eContents().get(3);
		private final Keyword cEndKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//State:
		//	"state" id=ID name=STRING? ("actions" "{" actions+=Command* "}")? "end";
		@Override public ParserRule getRule() { return rule; }

		//"state" id=ID name=STRING? ("actions" "{" actions+=Command* "}")? "end"
		public Group getGroup() { return cGroup; }

		//"state"
		public Keyword getStateKeyword_0() { return cStateKeyword_0; }

		//id=ID
		public Assignment getIdAssignment_1() { return cIdAssignment_1; }

		//ID
		public RuleCall getIdIDTerminalRuleCall_1_0() { return cIdIDTerminalRuleCall_1_0; }

		//name=STRING?
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//STRING
		public RuleCall getNameSTRINGTerminalRuleCall_2_0() { return cNameSTRINGTerminalRuleCall_2_0; }

		//("actions" "{" actions+=Command* "}")?
		public Group getGroup_3() { return cGroup_3; }

		//"actions"
		public Keyword getActionsKeyword_3_0() { return cActionsKeyword_3_0; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_3_1() { return cLeftCurlyBracketKeyword_3_1; }

		//actions+=Command*
		public Assignment getActionsAssignment_3_2() { return cActionsAssignment_3_2; }

		//Command
		public RuleCall getActionsCommandParserRuleCall_3_2_0() { return cActionsCommandParserRuleCall_3_2_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_3_3() { return cRightCurlyBracketKeyword_3_3; }

		//"end"
		public Keyword getEndKeyword_4() { return cEndKeyword_4; }
	}

	public class TransitionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Transition");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cSourceStateAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cSourceStateStateCrossReference_0_0 = (CrossReference)cSourceStateAssignment_0.eContents().get(0);
		private final RuleCall cSourceStateStateIDTerminalRuleCall_0_0_1 = (RuleCall)cSourceStateStateCrossReference_0_0.eContents().get(1);
		private final Keyword cEqualsSignGreaterThanSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cTargetStateAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cTargetStateStateCrossReference_2_0 = (CrossReference)cTargetStateAssignment_2.eContents().get(0);
		private final RuleCall cTargetStateStateIDTerminalRuleCall_2_0_1 = (RuleCall)cTargetStateStateCrossReference_2_0.eContents().get(1);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cLeftParenthesisKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cEventAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cEventEventParserRuleCall_3_1_0 = (RuleCall)cEventAssignment_3_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_3_2 = (Keyword)cGroup_3.eContents().get(2);
		
		//Transition:
		//	sourceState=[State] "=>" targetState=[State] ("(" event=Event? ")")?;
		@Override public ParserRule getRule() { return rule; }

		//sourceState=[State] "=>" targetState=[State] ("(" event=Event? ")")?
		public Group getGroup() { return cGroup; }

		//sourceState=[State]
		public Assignment getSourceStateAssignment_0() { return cSourceStateAssignment_0; }

		//[State]
		public CrossReference getSourceStateStateCrossReference_0_0() { return cSourceStateStateCrossReference_0_0; }

		//ID
		public RuleCall getSourceStateStateIDTerminalRuleCall_0_0_1() { return cSourceStateStateIDTerminalRuleCall_0_0_1; }

		//"=>"
		public Keyword getEqualsSignGreaterThanSignKeyword_1() { return cEqualsSignGreaterThanSignKeyword_1; }

		//targetState=[State]
		public Assignment getTargetStateAssignment_2() { return cTargetStateAssignment_2; }

		//[State]
		public CrossReference getTargetStateStateCrossReference_2_0() { return cTargetStateStateCrossReference_2_0; }

		//ID
		public RuleCall getTargetStateStateIDTerminalRuleCall_2_0_1() { return cTargetStateStateIDTerminalRuleCall_2_0_1; }

		//("(" event=Event? ")")?
		public Group getGroup_3() { return cGroup_3; }

		//"("
		public Keyword getLeftParenthesisKeyword_3_0() { return cLeftParenthesisKeyword_3_0; }

		//event=Event?
		public Assignment getEventAssignment_3_1() { return cEventAssignment_3_1; }

		//Event
		public RuleCall getEventEventParserRuleCall_3_1_0() { return cEventEventParserRuleCall_3_1_0; }

		//")"
		public Keyword getRightParenthesisKeyword_3_2() { return cRightParenthesisKeyword_3_2; }
	}

	public class EventElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Event");
		private final Assignment cCodeAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cCodeSTRINGTerminalRuleCall_0 = (RuleCall)cCodeAssignment.eContents().get(0);
		
		//Event:
		//	code=STRING;
		@Override public ParserRule getRule() { return rule; }

		//code=STRING
		public Assignment getCodeAssignment() { return cCodeAssignment; }

		//STRING
		public RuleCall getCodeSTRINGTerminalRuleCall_0() { return cCodeSTRINGTerminalRuleCall_0; }
	}

	public class CommandElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Command");
		private final Assignment cCodeAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cCodeSTRINGTerminalRuleCall_0 = (RuleCall)cCodeAssignment.eContents().get(0);
		
		//Command:
		//	code=STRING;
		@Override public ParserRule getRule() { return rule; }

		//code=STRING
		public Assignment getCodeAssignment() { return cCodeAssignment; }

		//STRING
		public RuleCall getCodeSTRINGTerminalRuleCall_0() { return cCodeSTRINGTerminalRuleCall_0; }
	}
	
	
	private final StatemachineElements pStatemachine;
	private final StateElements pState;
	private final TransitionElements pTransition;
	private final EventElements pEvent;
	private final CommandElements pCommand;
	
	private final Grammar grammar;

	private final TerminalsGrammarAccess gaTerminals;

	@Inject
	public StatemachineGrammarAccess(GrammarProvider grammarProvider,
		TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaTerminals = gaTerminals;
		this.pStatemachine = new StatemachineElements();
		this.pState = new StateElements();
		this.pTransition = new TransitionElements();
		this.pEvent = new EventElements();
		this.pCommand = new CommandElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.xtext.example.statemachine.Statemachine".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	@Override
	public Grammar getGrammar() {
		return grammar;
	}
	

	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	//Statemachine:
	//	{Statemachine} (states+=State | transitions+=Transition)*;
	public StatemachineElements getStatemachineAccess() {
		return pStatemachine;
	}
	
	public ParserRule getStatemachineRule() {
		return getStatemachineAccess().getRule();
	}

	//State:
	//	"state" id=ID name=STRING? ("actions" "{" actions+=Command* "}")? "end";
	public StateElements getStateAccess() {
		return pState;
	}
	
	public ParserRule getStateRule() {
		return getStateAccess().getRule();
	}

	//Transition:
	//	sourceState=[State] "=>" targetState=[State] ("(" event=Event? ")")?;
	public TransitionElements getTransitionAccess() {
		return pTransition;
	}
	
	public ParserRule getTransitionRule() {
		return getTransitionAccess().getRule();
	}

	//Event:
	//	code=STRING;
	public EventElements getEventAccess() {
		return pEvent;
	}
	
	public ParserRule getEventRule() {
		return getEventAccess().getRule();
	}

	//Command:
	//	code=STRING;
	public CommandElements getCommandAccess() {
		return pCommand;
	}
	
	public ParserRule getCommandRule() {
		return getCommandAccess().getRule();
	}

	//terminal ID:
	//	"^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	} 

	//terminal INT returns ecore::EInt:
	//	"0".."9"+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	} 

	//terminal STRING:
	//	"\"" ("\\" . / * 'b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\' * / | !("\\" | "\""))* "\"" | "\'" ("\\" .
	//	/ * 'b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\' * / | !("\\" | "\'"))* "\'";
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	} 

	//terminal ML_COMMENT:
	//	"/ *"->"* /";
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	} 

	//terminal SL_COMMENT:
	//	"//" !("\n" | "\r")* ("\r"? "\n")?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	} 

	//terminal WS:
	//	(" " | "\t" | "\r" | "\n")+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	} 

	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	} 
}
