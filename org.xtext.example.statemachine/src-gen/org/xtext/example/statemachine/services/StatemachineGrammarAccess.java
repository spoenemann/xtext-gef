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
		private final Assignment cInitialAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cInitialInitialKeyword_0_0 = (Keyword)cInitialAssignment_0.eContents().get(0);
		private final Assignment cFinalAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Keyword cFinalFinalKeyword_1_0 = (Keyword)cFinalAssignment_1.eContents().get(0);
		private final Keyword cStateKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cIdAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cIdIDTerminalRuleCall_3_0 = (RuleCall)cIdAssignment_3.eContents().get(0);
		private final Assignment cNameAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cNameSTRINGTerminalRuleCall_4_0 = (RuleCall)cNameAssignment_4.eContents().get(0);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cActionsKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_5_1 = (Keyword)cGroup_5.eContents().get(1);
		private final Assignment cActionsAssignment_5_2 = (Assignment)cGroup_5.eContents().get(2);
		private final RuleCall cActionsCommandParserRuleCall_5_2_0 = (RuleCall)cActionsAssignment_5_2.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_5_3 = (Keyword)cGroup_5.eContents().get(3);
		private final Keyword cEndKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//State:
		//	initial?="initial"? final?="final"? "state" id=ID name=STRING? ("actions" "{" actions+=Command* "}")? "end";
		@Override public ParserRule getRule() { return rule; }

		//initial?="initial"? final?="final"? "state" id=ID name=STRING? ("actions" "{" actions+=Command* "}")? "end"
		public Group getGroup() { return cGroup; }

		//initial?="initial"?
		public Assignment getInitialAssignment_0() { return cInitialAssignment_0; }

		//"initial"
		public Keyword getInitialInitialKeyword_0_0() { return cInitialInitialKeyword_0_0; }

		//final?="final"?
		public Assignment getFinalAssignment_1() { return cFinalAssignment_1; }

		//"final"
		public Keyword getFinalFinalKeyword_1_0() { return cFinalFinalKeyword_1_0; }

		//"state"
		public Keyword getStateKeyword_2() { return cStateKeyword_2; }

		//id=ID
		public Assignment getIdAssignment_3() { return cIdAssignment_3; }

		//ID
		public RuleCall getIdIDTerminalRuleCall_3_0() { return cIdIDTerminalRuleCall_3_0; }

		//name=STRING?
		public Assignment getNameAssignment_4() { return cNameAssignment_4; }

		//STRING
		public RuleCall getNameSTRINGTerminalRuleCall_4_0() { return cNameSTRINGTerminalRuleCall_4_0; }

		//("actions" "{" actions+=Command* "}")?
		public Group getGroup_5() { return cGroup_5; }

		//"actions"
		public Keyword getActionsKeyword_5_0() { return cActionsKeyword_5_0; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_5_1() { return cLeftCurlyBracketKeyword_5_1; }

		//actions+=Command*
		public Assignment getActionsAssignment_5_2() { return cActionsAssignment_5_2; }

		//Command
		public RuleCall getActionsCommandParserRuleCall_5_2_0() { return cActionsCommandParserRuleCall_5_2_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_5_3() { return cRightCurlyBracketKeyword_5_3; }

		//"end"
		public Keyword getEndKeyword_6() { return cEndKeyword_6; }
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
		private final RuleCall cEventExpressionParserRuleCall_3_1_0 = (RuleCall)cEventAssignment_3_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_3_2 = (Keyword)cGroup_3.eContents().get(2);
		
		//Transition:
		//	sourceState=[State] "=>" targetState=[State] ("(" event=Expression? ")")?;
		@Override public ParserRule getRule() { return rule; }

		//sourceState=[State] "=>" targetState=[State] ("(" event=Expression? ")")?
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

		//("(" event=Expression? ")")?
		public Group getGroup_3() { return cGroup_3; }

		//"("
		public Keyword getLeftParenthesisKeyword_3_0() { return cLeftParenthesisKeyword_3_0; }

		//event=Expression?
		public Assignment getEventAssignment_3_1() { return cEventAssignment_3_1; }

		//Expression
		public RuleCall getEventExpressionParserRuleCall_3_1_0() { return cEventExpressionParserRuleCall_3_1_0; }

		//")"
		public Keyword getRightParenthesisKeyword_3_2() { return cRightParenthesisKeyword_3_2; }
	}

	public class CommandElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Command");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cSetCommandParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cExecuteCommandParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cPrintCommandParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		
		//Command:
		//	SetCommand | ExecuteCommand | PrintCommand;
		@Override public ParserRule getRule() { return rule; }

		//SetCommand | ExecuteCommand | PrintCommand
		public Alternatives getAlternatives() { return cAlternatives; }

		//SetCommand
		public RuleCall getSetCommandParserRuleCall_0() { return cSetCommandParserRuleCall_0; }

		//ExecuteCommand
		public RuleCall getExecuteCommandParserRuleCall_1() { return cExecuteCommandParserRuleCall_1; }

		//PrintCommand
		public RuleCall getPrintCommandParserRuleCall_2() { return cPrintCommandParserRuleCall_2; }
	}

	public class SetCommandElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SetCommand");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cSetKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cSignalAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cSignalIDTerminalRuleCall_1_0 = (RuleCall)cSignalAssignment_1.eContents().get(0);
		private final Keyword cEqualsSignKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cValueAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cValueExpressionParserRuleCall_3_0 = (RuleCall)cValueAssignment_3.eContents().get(0);
		
		//SetCommand:
		//	"set" signal=ID "=" value=Expression;
		@Override public ParserRule getRule() { return rule; }

		//"set" signal=ID "=" value=Expression
		public Group getGroup() { return cGroup; }

		//"set"
		public Keyword getSetKeyword_0() { return cSetKeyword_0; }

		//signal=ID
		public Assignment getSignalAssignment_1() { return cSignalAssignment_1; }

		//ID
		public RuleCall getSignalIDTerminalRuleCall_1_0() { return cSignalIDTerminalRuleCall_1_0; }

		//"="
		public Keyword getEqualsSignKeyword_2() { return cEqualsSignKeyword_2; }

		//value=Expression
		public Assignment getValueAssignment_3() { return cValueAssignment_3; }

		//Expression
		public RuleCall getValueExpressionParserRuleCall_3_0() { return cValueExpressionParserRuleCall_3_0; }
	}

	public class ExecuteCommandElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ExecuteCommand");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cExecuteKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cOperationAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOperationIDTerminalRuleCall_1_0 = (RuleCall)cOperationAssignment_1.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Assignment cArgumentsAssignment_3_0 = (Assignment)cGroup_3.eContents().get(0);
		private final RuleCall cArgumentsExpressionParserRuleCall_3_0_0 = (RuleCall)cArgumentsAssignment_3_0.eContents().get(0);
		private final Group cGroup_3_1 = (Group)cGroup_3.eContents().get(1);
		private final Keyword cCommaKeyword_3_1_0 = (Keyword)cGroup_3_1.eContents().get(0);
		private final Assignment cArgumentsAssignment_3_1_1 = (Assignment)cGroup_3_1.eContents().get(1);
		private final RuleCall cArgumentsExpressionParserRuleCall_3_1_1_0 = (RuleCall)cArgumentsAssignment_3_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//ExecuteCommand:
		//	"execute" operation=ID "(" (arguments+=Expression ("," arguments+=Expression)*)? ")";
		@Override public ParserRule getRule() { return rule; }

		//"execute" operation=ID "(" (arguments+=Expression ("," arguments+=Expression)*)? ")"
		public Group getGroup() { return cGroup; }

		//"execute"
		public Keyword getExecuteKeyword_0() { return cExecuteKeyword_0; }

		//operation=ID
		public Assignment getOperationAssignment_1() { return cOperationAssignment_1; }

		//ID
		public RuleCall getOperationIDTerminalRuleCall_1_0() { return cOperationIDTerminalRuleCall_1_0; }

		//"("
		public Keyword getLeftParenthesisKeyword_2() { return cLeftParenthesisKeyword_2; }

		//(arguments+=Expression ("," arguments+=Expression)*)?
		public Group getGroup_3() { return cGroup_3; }

		//arguments+=Expression
		public Assignment getArgumentsAssignment_3_0() { return cArgumentsAssignment_3_0; }

		//Expression
		public RuleCall getArgumentsExpressionParserRuleCall_3_0_0() { return cArgumentsExpressionParserRuleCall_3_0_0; }

		//("," arguments+=Expression)*
		public Group getGroup_3_1() { return cGroup_3_1; }

		//","
		public Keyword getCommaKeyword_3_1_0() { return cCommaKeyword_3_1_0; }

		//arguments+=Expression
		public Assignment getArgumentsAssignment_3_1_1() { return cArgumentsAssignment_3_1_1; }

		//Expression
		public RuleCall getArgumentsExpressionParserRuleCall_3_1_1_0() { return cArgumentsExpressionParserRuleCall_3_1_1_0; }

		//")"
		public Keyword getRightParenthesisKeyword_4() { return cRightParenthesisKeyword_4; }
	}

	public class PrintCommandElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "PrintCommand");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cPrintKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValueExpressionParserRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		
		//PrintCommand:
		//	"print" value=Expression;
		@Override public ParserRule getRule() { return rule; }

		//"print" value=Expression
		public Group getGroup() { return cGroup; }

		//"print"
		public Keyword getPrintKeyword_0() { return cPrintKeyword_0; }

		//value=Expression
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }

		//Expression
		public RuleCall getValueExpressionParserRuleCall_1_0() { return cValueExpressionParserRuleCall_1_0; }
	}

	public class ExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Expression");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cVerbatimExpressionParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cStatePropertyExpressionParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//Expression:
		//	VerbatimExpression | StatePropertyExpression;
		@Override public ParserRule getRule() { return rule; }

		//VerbatimExpression | StatePropertyExpression
		public Alternatives getAlternatives() { return cAlternatives; }

		//VerbatimExpression
		public RuleCall getVerbatimExpressionParserRuleCall_0() { return cVerbatimExpressionParserRuleCall_0; }

		//StatePropertyExpression
		public RuleCall getStatePropertyExpressionParserRuleCall_1() { return cStatePropertyExpressionParserRuleCall_1; }
	}

	public class VerbatimExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "VerbatimExpression");
		private final Assignment cCodeAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cCodeSTRINGTerminalRuleCall_0 = (RuleCall)cCodeAssignment.eContents().get(0);
		
		//VerbatimExpression:
		//	code=STRING;
		@Override public ParserRule getRule() { return rule; }

		//code=STRING
		public Assignment getCodeAssignment() { return cCodeAssignment; }

		//STRING
		public RuleCall getCodeSTRINGTerminalRuleCall_0() { return cCodeSTRINGTerminalRuleCall_0; }
	}

	public class StatePropertyExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "StatePropertyExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cStateAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cStateStateCrossReference_0_0 = (CrossReference)cStateAssignment_0.eContents().get(0);
		private final RuleCall cStateStateIDTerminalRuleCall_0_0_1 = (RuleCall)cStateStateCrossReference_0_0.eContents().get(1);
		private final Keyword cFullStopKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cPropertyAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cPropertyPropertyEnumRuleCall_2_0 = (RuleCall)cPropertyAssignment_2.eContents().get(0);
		
		//StatePropertyExpression:
		//	state=[State] "." property=Property;
		@Override public ParserRule getRule() { return rule; }

		//state=[State] "." property=Property
		public Group getGroup() { return cGroup; }

		//state=[State]
		public Assignment getStateAssignment_0() { return cStateAssignment_0; }

		//[State]
		public CrossReference getStateStateCrossReference_0_0() { return cStateStateCrossReference_0_0; }

		//ID
		public RuleCall getStateStateIDTerminalRuleCall_0_0_1() { return cStateStateIDTerminalRuleCall_0_0_1; }

		//"."
		public Keyword getFullStopKeyword_1() { return cFullStopKeyword_1; }

		//property=Property
		public Assignment getPropertyAssignment_2() { return cPropertyAssignment_2; }

		//Property
		public RuleCall getPropertyPropertyEnumRuleCall_2_0() { return cPropertyPropertyEnumRuleCall_2_0; }
	}
	
	
	public class PropertyElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "Property");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cNameEnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cNameNameKeyword_0_0 = (Keyword)cNameEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cOutputEnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cOutputOutputKeyword_1_0 = (Keyword)cOutputEnumLiteralDeclaration_1.eContents().get(0);
		
		//enum Property:
		//	name | output;
		public EnumRule getRule() { return rule; }

		//name | output
		public Alternatives getAlternatives() { return cAlternatives; }

		//name
		public EnumLiteralDeclaration getNameEnumLiteralDeclaration_0() { return cNameEnumLiteralDeclaration_0; }

		//"name"
		public Keyword getNameNameKeyword_0_0() { return cNameNameKeyword_0_0; }

		//output
		public EnumLiteralDeclaration getOutputEnumLiteralDeclaration_1() { return cOutputEnumLiteralDeclaration_1; }

		//"output"
		public Keyword getOutputOutputKeyword_1_0() { return cOutputOutputKeyword_1_0; }
	}
	
	private final StatemachineElements pStatemachine;
	private final StateElements pState;
	private final TransitionElements pTransition;
	private final CommandElements pCommand;
	private final SetCommandElements pSetCommand;
	private final ExecuteCommandElements pExecuteCommand;
	private final PrintCommandElements pPrintCommand;
	private final ExpressionElements pExpression;
	private final VerbatimExpressionElements pVerbatimExpression;
	private final StatePropertyExpressionElements pStatePropertyExpression;
	private final PropertyElements unknownRuleProperty;
	
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
		this.pCommand = new CommandElements();
		this.pSetCommand = new SetCommandElements();
		this.pExecuteCommand = new ExecuteCommandElements();
		this.pPrintCommand = new PrintCommandElements();
		this.pExpression = new ExpressionElements();
		this.pVerbatimExpression = new VerbatimExpressionElements();
		this.pStatePropertyExpression = new StatePropertyExpressionElements();
		this.unknownRuleProperty = new PropertyElements();
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
	//	initial?="initial"? final?="final"? "state" id=ID name=STRING? ("actions" "{" actions+=Command* "}")? "end";
	public StateElements getStateAccess() {
		return pState;
	}
	
	public ParserRule getStateRule() {
		return getStateAccess().getRule();
	}

	//Transition:
	//	sourceState=[State] "=>" targetState=[State] ("(" event=Expression? ")")?;
	public TransitionElements getTransitionAccess() {
		return pTransition;
	}
	
	public ParserRule getTransitionRule() {
		return getTransitionAccess().getRule();
	}

	//Command:
	//	SetCommand | ExecuteCommand | PrintCommand;
	public CommandElements getCommandAccess() {
		return pCommand;
	}
	
	public ParserRule getCommandRule() {
		return getCommandAccess().getRule();
	}

	//SetCommand:
	//	"set" signal=ID "=" value=Expression;
	public SetCommandElements getSetCommandAccess() {
		return pSetCommand;
	}
	
	public ParserRule getSetCommandRule() {
		return getSetCommandAccess().getRule();
	}

	//ExecuteCommand:
	//	"execute" operation=ID "(" (arguments+=Expression ("," arguments+=Expression)*)? ")";
	public ExecuteCommandElements getExecuteCommandAccess() {
		return pExecuteCommand;
	}
	
	public ParserRule getExecuteCommandRule() {
		return getExecuteCommandAccess().getRule();
	}

	//PrintCommand:
	//	"print" value=Expression;
	public PrintCommandElements getPrintCommandAccess() {
		return pPrintCommand;
	}
	
	public ParserRule getPrintCommandRule() {
		return getPrintCommandAccess().getRule();
	}

	//Expression:
	//	VerbatimExpression | StatePropertyExpression;
	public ExpressionElements getExpressionAccess() {
		return pExpression;
	}
	
	public ParserRule getExpressionRule() {
		return getExpressionAccess().getRule();
	}

	//VerbatimExpression:
	//	code=STRING;
	public VerbatimExpressionElements getVerbatimExpressionAccess() {
		return pVerbatimExpression;
	}
	
	public ParserRule getVerbatimExpressionRule() {
		return getVerbatimExpressionAccess().getRule();
	}

	//StatePropertyExpression:
	//	state=[State] "." property=Property;
	public StatePropertyExpressionElements getStatePropertyExpressionAccess() {
		return pStatePropertyExpression;
	}
	
	public ParserRule getStatePropertyExpressionRule() {
		return getStatePropertyExpressionAccess().getRule();
	}

	//enum Property:
	//	name | output;
	public PropertyElements getPropertyAccess() {
		return unknownRuleProperty;
	}
	
	public EnumRule getPropertyRule() {
		return getPropertyAccess().getRule();
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
