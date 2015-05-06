/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
grammar InternalStatemachine;

options {
	superClass=AbstractInternalAntlrParser;
	
}

@lexer::header {
package org.xtext.example.statemachine.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.xtext.example.statemachine.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.example.statemachine.services.StatemachineGrammarAccess;

}

@parser::members {

 	private StatemachineGrammarAccess grammarAccess;
 	
    public InternalStatemachineParser(TokenStream input, StatemachineGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "Statemachine";	
   	}
   	
   	@Override
   	protected StatemachineGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleStatemachine
entryRuleStatemachine returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getStatemachineRule()); }
	 iv_ruleStatemachine=ruleStatemachine 
	 { $current=$iv_ruleStatemachine.current; } 
	 EOF 
;

// Rule Statemachine
ruleStatemachine returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getStatemachineAccess().getStatemachineAction_0(),
            $current);
    }
)((
(
		{ 
	        newCompositeNode(grammarAccess.getStatemachineAccess().getStatesStateParserRuleCall_1_0_0()); 
	    }
		lv_states_1_0=ruleState		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getStatemachineRule());
	        }
       		add(
       			$current, 
       			"states",
        		lv_states_1_0, 
        		"State");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getStatemachineAccess().getTransitionsTransitionParserRuleCall_1_1_0()); 
	    }
		lv_transitions_2_0=ruleTransition		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getStatemachineRule());
	        }
       		add(
       			$current, 
       			"transitions",
        		lv_transitions_2_0, 
        		"Transition");
	        afterParserOrEnumRuleCall();
	    }

)
))*)
;





// Entry rule entryRuleState
entryRuleState returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getStateRule()); }
	 iv_ruleState=ruleState 
	 { $current=$iv_ruleState.current; } 
	 EOF 
;

// Rule State
ruleState returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_initial_0_0=	'initial' 
    {
        newLeafNode(lv_initial_0_0, grammarAccess.getStateAccess().getInitialInitialKeyword_0_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getStateRule());
	        }
       		setWithLastConsumed($current, "initial", true, "initial");
	    }

)
)?(
(
		lv_final_1_0=	'final' 
    {
        newLeafNode(lv_final_1_0, grammarAccess.getStateAccess().getFinalFinalKeyword_1_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getStateRule());
	        }
       		setWithLastConsumed($current, "final", true, "final");
	    }

)
)?	otherlv_2='state' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getStateAccess().getStateKeyword_2());
    }
(
(
		lv_id_3_0=RULE_ID
		{
			newLeafNode(lv_id_3_0, grammarAccess.getStateAccess().getIdIDTerminalRuleCall_3_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getStateRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"id",
        		lv_id_3_0, 
        		"ID");
	    }

)
)(
(
		lv_name_4_0=RULE_STRING
		{
			newLeafNode(lv_name_4_0, grammarAccess.getStateAccess().getNameSTRINGTerminalRuleCall_4_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getStateRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_4_0, 
        		"STRING");
	    }

)
)?(	otherlv_5='actions' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getStateAccess().getActionsKeyword_5_0());
    }
	otherlv_6='{' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getStateAccess().getLeftCurlyBracketKeyword_5_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getStateAccess().getActionsCommandParserRuleCall_5_2_0()); 
	    }
		lv_actions_7_0=ruleCommand		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getStateRule());
	        }
       		add(
       			$current, 
       			"actions",
        		lv_actions_7_0, 
        		"Command");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_8='}' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getStateAccess().getRightCurlyBracketKeyword_5_3());
    }
)?	otherlv_9='end' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getStateAccess().getEndKeyword_6());
    }
)
;





// Entry rule entryRuleTransition
entryRuleTransition returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getTransitionRule()); }
	 iv_ruleTransition=ruleTransition 
	 { $current=$iv_ruleTransition.current; } 
	 EOF 
;

// Rule Transition
ruleTransition returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getTransitionRule());
	        }
        }
	otherlv_0=RULE_ID
	{
		newLeafNode(otherlv_0, grammarAccess.getTransitionAccess().getSourceStateStateCrossReference_0_0()); 
	}

)
)	otherlv_1='=>' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getTransitionAccess().getEqualsSignGreaterThanSignKeyword_1());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getTransitionRule());
	        }
        }
	otherlv_2=RULE_ID
	{
		newLeafNode(otherlv_2, grammarAccess.getTransitionAccess().getTargetStateStateCrossReference_2_0()); 
	}

)
)(	otherlv_3='(' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getTransitionAccess().getLeftParenthesisKeyword_3_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getTransitionAccess().getEventExpressionParserRuleCall_3_1_0()); 
	    }
		lv_event_4_0=ruleExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTransitionRule());
	        }
       		set(
       			$current, 
       			"event",
        		lv_event_4_0, 
        		"Expression");
	        afterParserOrEnumRuleCall();
	    }

)
)?	otherlv_5=')' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getTransitionAccess().getRightParenthesisKeyword_3_2());
    }
)?)
;





// Entry rule entryRuleCommand
entryRuleCommand returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getCommandRule()); }
	 iv_ruleCommand=ruleCommand 
	 { $current=$iv_ruleCommand.current; } 
	 EOF 
;

// Rule Command
ruleCommand returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getCommandAccess().getSetCommandParserRuleCall_0()); 
    }
    this_SetCommand_0=ruleSetCommand
    { 
        $current = $this_SetCommand_0.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getCommandAccess().getExecuteCommandParserRuleCall_1()); 
    }
    this_ExecuteCommand_1=ruleExecuteCommand
    { 
        $current = $this_ExecuteCommand_1.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getCommandAccess().getPrintCommandParserRuleCall_2()); 
    }
    this_PrintCommand_2=rulePrintCommand
    { 
        $current = $this_PrintCommand_2.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleSetCommand
entryRuleSetCommand returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getSetCommandRule()); }
	 iv_ruleSetCommand=ruleSetCommand 
	 { $current=$iv_ruleSetCommand.current; } 
	 EOF 
;

// Rule SetCommand
ruleSetCommand returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='set' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getSetCommandAccess().getSetKeyword_0());
    }
(
(
		lv_signal_1_0=RULE_ID
		{
			newLeafNode(lv_signal_1_0, grammarAccess.getSetCommandAccess().getSignalIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getSetCommandRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"signal",
        		lv_signal_1_0, 
        		"ID");
	    }

)
)	otherlv_2='=' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getSetCommandAccess().getEqualsSignKeyword_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getSetCommandAccess().getValueExpressionParserRuleCall_3_0()); 
	    }
		lv_value_3_0=ruleExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSetCommandRule());
	        }
       		set(
       			$current, 
       			"value",
        		lv_value_3_0, 
        		"Expression");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleExecuteCommand
entryRuleExecuteCommand returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getExecuteCommandRule()); }
	 iv_ruleExecuteCommand=ruleExecuteCommand 
	 { $current=$iv_ruleExecuteCommand.current; } 
	 EOF 
;

// Rule ExecuteCommand
ruleExecuteCommand returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='execute' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getExecuteCommandAccess().getExecuteKeyword_0());
    }
(
(
		lv_operation_1_0=RULE_ID
		{
			newLeafNode(lv_operation_1_0, grammarAccess.getExecuteCommandAccess().getOperationIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getExecuteCommandRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"operation",
        		lv_operation_1_0, 
        		"ID");
	    }

)
)	otherlv_2='(' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getExecuteCommandAccess().getLeftParenthesisKeyword_2());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getExecuteCommandAccess().getArgumentsExpressionParserRuleCall_3_0_0()); 
	    }
		lv_arguments_3_0=ruleExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getExecuteCommandRule());
	        }
       		add(
       			$current, 
       			"arguments",
        		lv_arguments_3_0, 
        		"Expression");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_4=',' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getExecuteCommandAccess().getCommaKeyword_3_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getExecuteCommandAccess().getArgumentsExpressionParserRuleCall_3_1_1_0()); 
	    }
		lv_arguments_5_0=ruleExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getExecuteCommandRule());
	        }
       		add(
       			$current, 
       			"arguments",
        		lv_arguments_5_0, 
        		"Expression");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?	otherlv_6=')' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getExecuteCommandAccess().getRightParenthesisKeyword_4());
    }
)
;





// Entry rule entryRulePrintCommand
entryRulePrintCommand returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getPrintCommandRule()); }
	 iv_rulePrintCommand=rulePrintCommand 
	 { $current=$iv_rulePrintCommand.current; } 
	 EOF 
;

// Rule PrintCommand
rulePrintCommand returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='print' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getPrintCommandAccess().getPrintKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getPrintCommandAccess().getValueExpressionParserRuleCall_1_0()); 
	    }
		lv_value_1_0=ruleExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPrintCommandRule());
	        }
       		set(
       			$current, 
       			"value",
        		lv_value_1_0, 
        		"Expression");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleExpression
entryRuleExpression returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getExpressionRule()); }
	 iv_ruleExpression=ruleExpression 
	 { $current=$iv_ruleExpression.current; } 
	 EOF 
;

// Rule Expression
ruleExpression returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getExpressionAccess().getVerbatimExpressionParserRuleCall_0()); 
    }
    this_VerbatimExpression_0=ruleVerbatimExpression
    { 
        $current = $this_VerbatimExpression_0.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getExpressionAccess().getStatePropertyExpressionParserRuleCall_1()); 
    }
    this_StatePropertyExpression_1=ruleStatePropertyExpression
    { 
        $current = $this_StatePropertyExpression_1.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleVerbatimExpression
entryRuleVerbatimExpression returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getVerbatimExpressionRule()); }
	 iv_ruleVerbatimExpression=ruleVerbatimExpression 
	 { $current=$iv_ruleVerbatimExpression.current; } 
	 EOF 
;

// Rule VerbatimExpression
ruleVerbatimExpression returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
		lv_code_0_0=RULE_STRING
		{
			newLeafNode(lv_code_0_0, grammarAccess.getVerbatimExpressionAccess().getCodeSTRINGTerminalRuleCall_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getVerbatimExpressionRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"code",
        		lv_code_0_0, 
        		"STRING");
	    }

)
)
;





// Entry rule entryRuleStatePropertyExpression
entryRuleStatePropertyExpression returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getStatePropertyExpressionRule()); }
	 iv_ruleStatePropertyExpression=ruleStatePropertyExpression 
	 { $current=$iv_ruleStatePropertyExpression.current; } 
	 EOF 
;

// Rule StatePropertyExpression
ruleStatePropertyExpression returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getStatePropertyExpressionRule());
	        }
        }
	otherlv_0=RULE_ID
	{
		newLeafNode(otherlv_0, grammarAccess.getStatePropertyExpressionAccess().getStateStateCrossReference_0_0()); 
	}

)
)	otherlv_1='.' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getStatePropertyExpressionAccess().getFullStopKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getStatePropertyExpressionAccess().getPropertyPropertyEnumRuleCall_2_0()); 
	    }
		lv_property_2_0=ruleProperty		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getStatePropertyExpressionRule());
	        }
       		set(
       			$current, 
       			"property",
        		lv_property_2_0, 
        		"Property");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Rule Property
ruleProperty returns [Enumerator current=null] 
    @init { enterRule(); }
    @after { leaveRule(); }:
((	enumLiteral_0='name' 
	{
        $current = grammarAccess.getPropertyAccess().getNameEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getPropertyAccess().getNameEnumLiteralDeclaration_0()); 
    }
)
    |(	enumLiteral_1='output' 
	{
        $current = grammarAccess.getPropertyAccess().getOutputEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getPropertyAccess().getOutputEnumLiteralDeclaration_1()); 
    }
));



RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


