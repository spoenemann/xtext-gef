/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
grammar InternalStatemachine;

options {
	superClass=AbstractInternalContentAssistParser;
	
}

@lexer::header {
package org.xtext.example.statemachine.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package org.xtext.example.statemachine.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.xtext.example.statemachine.services.StatemachineGrammarAccess;

}

@parser::members {
 
 	private StatemachineGrammarAccess grammarAccess;
 	
    public void setGrammarAccess(StatemachineGrammarAccess grammarAccess) {
    	this.grammarAccess = grammarAccess;
    }
    
    @Override
    protected Grammar getGrammar() {
    	return grammarAccess.getGrammar();
    }
    
    @Override
    protected String getValueForTokenName(String tokenName) {
    	return tokenName;
    }

}




// Entry rule entryRuleStatemachine
entryRuleStatemachine 
:
{ before(grammarAccess.getStatemachineRule()); }
	 ruleStatemachine
{ after(grammarAccess.getStatemachineRule()); } 
	 EOF 
;

// Rule Statemachine
ruleStatemachine
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getStatemachineAccess().getGroup()); }
(rule__Statemachine__Group__0)
{ after(grammarAccess.getStatemachineAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleState
entryRuleState 
:
{ before(grammarAccess.getStateRule()); }
	 ruleState
{ after(grammarAccess.getStateRule()); } 
	 EOF 
;

// Rule State
ruleState
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getStateAccess().getGroup()); }
(rule__State__Group__0)
{ after(grammarAccess.getStateAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTransition
entryRuleTransition 
:
{ before(grammarAccess.getTransitionRule()); }
	 ruleTransition
{ after(grammarAccess.getTransitionRule()); } 
	 EOF 
;

// Rule Transition
ruleTransition
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTransitionAccess().getGroup()); }
(rule__Transition__Group__0)
{ after(grammarAccess.getTransitionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleCommand
entryRuleCommand 
:
{ before(grammarAccess.getCommandRule()); }
	 ruleCommand
{ after(grammarAccess.getCommandRule()); } 
	 EOF 
;

// Rule Command
ruleCommand
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getCommandAccess().getAlternatives()); }
(rule__Command__Alternatives)
{ after(grammarAccess.getCommandAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleSetCommand
entryRuleSetCommand 
:
{ before(grammarAccess.getSetCommandRule()); }
	 ruleSetCommand
{ after(grammarAccess.getSetCommandRule()); } 
	 EOF 
;

// Rule SetCommand
ruleSetCommand
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getSetCommandAccess().getGroup()); }
(rule__SetCommand__Group__0)
{ after(grammarAccess.getSetCommandAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleExecuteCommand
entryRuleExecuteCommand 
:
{ before(grammarAccess.getExecuteCommandRule()); }
	 ruleExecuteCommand
{ after(grammarAccess.getExecuteCommandRule()); } 
	 EOF 
;

// Rule ExecuteCommand
ruleExecuteCommand
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getExecuteCommandAccess().getGroup()); }
(rule__ExecuteCommand__Group__0)
{ after(grammarAccess.getExecuteCommandAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRulePrintCommand
entryRulePrintCommand 
:
{ before(grammarAccess.getPrintCommandRule()); }
	 rulePrintCommand
{ after(grammarAccess.getPrintCommandRule()); } 
	 EOF 
;

// Rule PrintCommand
rulePrintCommand
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getPrintCommandAccess().getGroup()); }
(rule__PrintCommand__Group__0)
{ after(grammarAccess.getPrintCommandAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleExpression
entryRuleExpression 
:
{ before(grammarAccess.getExpressionRule()); }
	 ruleExpression
{ after(grammarAccess.getExpressionRule()); } 
	 EOF 
;

// Rule Expression
ruleExpression
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getExpressionAccess().getAlternatives()); }
(rule__Expression__Alternatives)
{ after(grammarAccess.getExpressionAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleVerbatimExpression
entryRuleVerbatimExpression 
:
{ before(grammarAccess.getVerbatimExpressionRule()); }
	 ruleVerbatimExpression
{ after(grammarAccess.getVerbatimExpressionRule()); } 
	 EOF 
;

// Rule VerbatimExpression
ruleVerbatimExpression
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getVerbatimExpressionAccess().getCodeAssignment()); }
(rule__VerbatimExpression__CodeAssignment)
{ after(grammarAccess.getVerbatimExpressionAccess().getCodeAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleStatePropertyExpression
entryRuleStatePropertyExpression 
:
{ before(grammarAccess.getStatePropertyExpressionRule()); }
	 ruleStatePropertyExpression
{ after(grammarAccess.getStatePropertyExpressionRule()); } 
	 EOF 
;

// Rule StatePropertyExpression
ruleStatePropertyExpression
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getStatePropertyExpressionAccess().getGroup()); }
(rule__StatePropertyExpression__Group__0)
{ after(grammarAccess.getStatePropertyExpressionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}




// Rule Property
ruleProperty
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropertyAccess().getAlternatives()); }
(rule__Property__Alternatives)
{ after(grammarAccess.getPropertyAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



rule__Statemachine__Alternatives_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStatemachineAccess().getStatesAssignment_1_0()); }
(rule__Statemachine__StatesAssignment_1_0)
{ after(grammarAccess.getStatemachineAccess().getStatesAssignment_1_0()); }
)

    |(
{ before(grammarAccess.getStatemachineAccess().getTransitionsAssignment_1_1()); }
(rule__Statemachine__TransitionsAssignment_1_1)
{ after(grammarAccess.getStatemachineAccess().getTransitionsAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Command__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCommandAccess().getSetCommandParserRuleCall_0()); }
	ruleSetCommand
{ after(grammarAccess.getCommandAccess().getSetCommandParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getCommandAccess().getExecuteCommandParserRuleCall_1()); }
	ruleExecuteCommand
{ after(grammarAccess.getCommandAccess().getExecuteCommandParserRuleCall_1()); }
)

    |(
{ before(grammarAccess.getCommandAccess().getPrintCommandParserRuleCall_2()); }
	rulePrintCommand
{ after(grammarAccess.getCommandAccess().getPrintCommandParserRuleCall_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Expression__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExpressionAccess().getVerbatimExpressionParserRuleCall_0()); }
	ruleVerbatimExpression
{ after(grammarAccess.getExpressionAccess().getVerbatimExpressionParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getExpressionAccess().getStatePropertyExpressionParserRuleCall_1()); }
	ruleStatePropertyExpression
{ after(grammarAccess.getExpressionAccess().getStatePropertyExpressionParserRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Property__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPropertyAccess().getNameEnumLiteralDeclaration_0()); }
(	'name' 
)
{ after(grammarAccess.getPropertyAccess().getNameEnumLiteralDeclaration_0()); }
)

    |(
{ before(grammarAccess.getPropertyAccess().getOutputEnumLiteralDeclaration_1()); }
(	'output' 
)
{ after(grammarAccess.getPropertyAccess().getOutputEnumLiteralDeclaration_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}



rule__Statemachine__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Statemachine__Group__0__Impl
	rule__Statemachine__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Statemachine__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStatemachineAccess().getStatemachineAction_0()); }
(

)
{ after(grammarAccess.getStatemachineAccess().getStatemachineAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Statemachine__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Statemachine__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Statemachine__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStatemachineAccess().getAlternatives_1()); }
(rule__Statemachine__Alternatives_1)*
{ after(grammarAccess.getStatemachineAccess().getAlternatives_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__State__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__State__Group__0__Impl
	rule__State__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__State__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getInitialAssignment_0()); }
(rule__State__InitialAssignment_0)?
{ after(grammarAccess.getStateAccess().getInitialAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__State__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__State__Group__1__Impl
	rule__State__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__State__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getFinalAssignment_1()); }
(rule__State__FinalAssignment_1)?
{ after(grammarAccess.getStateAccess().getFinalAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__State__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__State__Group__2__Impl
	rule__State__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__State__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getStateKeyword_2()); }

	'state' 

{ after(grammarAccess.getStateAccess().getStateKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__State__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__State__Group__3__Impl
	rule__State__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__State__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIdAssignment_3()); }
(rule__State__IdAssignment_3)
{ after(grammarAccess.getStateAccess().getIdAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__State__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__State__Group__4__Impl
	rule__State__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__State__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getNameAssignment_4()); }
(rule__State__NameAssignment_4)?
{ after(grammarAccess.getStateAccess().getNameAssignment_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__State__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__State__Group__5__Impl
	rule__State__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__State__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getGroup_5()); }
(rule__State__Group_5__0)?
{ after(grammarAccess.getStateAccess().getGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__State__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__State__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__State__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getEndKeyword_6()); }

	'end' 

{ after(grammarAccess.getStateAccess().getEndKeyword_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}
















rule__State__Group_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__State__Group_5__0__Impl
	rule__State__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__State__Group_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getActionsKeyword_5_0()); }

	'actions' 

{ after(grammarAccess.getStateAccess().getActionsKeyword_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__State__Group_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__State__Group_5__1__Impl
	rule__State__Group_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__State__Group_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getLeftCurlyBracketKeyword_5_1()); }

	'{' 

{ after(grammarAccess.getStateAccess().getLeftCurlyBracketKeyword_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__State__Group_5__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__State__Group_5__2__Impl
	rule__State__Group_5__3
;
finally {
	restoreStackSize(stackSize);
}

rule__State__Group_5__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getActionsAssignment_5_2()); }
(rule__State__ActionsAssignment_5_2)*
{ after(grammarAccess.getStateAccess().getActionsAssignment_5_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__State__Group_5__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__State__Group_5__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__State__Group_5__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getRightCurlyBracketKeyword_5_3()); }

	'}' 

{ after(grammarAccess.getStateAccess().getRightCurlyBracketKeyword_5_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__Transition__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Transition__Group__0__Impl
	rule__Transition__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Transition__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTransitionAccess().getSourceStateAssignment_0()); }
(rule__Transition__SourceStateAssignment_0)
{ after(grammarAccess.getTransitionAccess().getSourceStateAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Transition__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Transition__Group__1__Impl
	rule__Transition__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Transition__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTransitionAccess().getEqualsSignGreaterThanSignKeyword_1()); }

	'=>' 

{ after(grammarAccess.getTransitionAccess().getEqualsSignGreaterThanSignKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Transition__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Transition__Group__2__Impl
	rule__Transition__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Transition__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTransitionAccess().getTargetStateAssignment_2()); }
(rule__Transition__TargetStateAssignment_2)
{ after(grammarAccess.getTransitionAccess().getTargetStateAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Transition__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Transition__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Transition__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTransitionAccess().getGroup_3()); }
(rule__Transition__Group_3__0)?
{ after(grammarAccess.getTransitionAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__Transition__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Transition__Group_3__0__Impl
	rule__Transition__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Transition__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTransitionAccess().getLeftParenthesisKeyword_3_0()); }

	'(' 

{ after(grammarAccess.getTransitionAccess().getLeftParenthesisKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Transition__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Transition__Group_3__1__Impl
	rule__Transition__Group_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Transition__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTransitionAccess().getEventAssignment_3_1()); }
(rule__Transition__EventAssignment_3_1)?
{ after(grammarAccess.getTransitionAccess().getEventAssignment_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Transition__Group_3__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Transition__Group_3__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Transition__Group_3__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTransitionAccess().getRightParenthesisKeyword_3_2()); }

	')' 

{ after(grammarAccess.getTransitionAccess().getRightParenthesisKeyword_3_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__SetCommand__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SetCommand__Group__0__Impl
	rule__SetCommand__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SetCommand__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSetCommandAccess().getSetKeyword_0()); }

	'set' 

{ after(grammarAccess.getSetCommandAccess().getSetKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SetCommand__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SetCommand__Group__1__Impl
	rule__SetCommand__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__SetCommand__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSetCommandAccess().getSignalAssignment_1()); }
(rule__SetCommand__SignalAssignment_1)
{ after(grammarAccess.getSetCommandAccess().getSignalAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SetCommand__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SetCommand__Group__2__Impl
	rule__SetCommand__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__SetCommand__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSetCommandAccess().getEqualsSignKeyword_2()); }

	'=' 

{ after(grammarAccess.getSetCommandAccess().getEqualsSignKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SetCommand__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SetCommand__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SetCommand__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSetCommandAccess().getValueAssignment_3()); }
(rule__SetCommand__ValueAssignment_3)
{ after(grammarAccess.getSetCommandAccess().getValueAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__ExecuteCommand__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ExecuteCommand__Group__0__Impl
	rule__ExecuteCommand__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ExecuteCommand__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExecuteCommandAccess().getExecuteKeyword_0()); }

	'execute' 

{ after(grammarAccess.getExecuteCommandAccess().getExecuteKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ExecuteCommand__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ExecuteCommand__Group__1__Impl
	rule__ExecuteCommand__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ExecuteCommand__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExecuteCommandAccess().getOperationAssignment_1()); }
(rule__ExecuteCommand__OperationAssignment_1)
{ after(grammarAccess.getExecuteCommandAccess().getOperationAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ExecuteCommand__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ExecuteCommand__Group__2__Impl
	rule__ExecuteCommand__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ExecuteCommand__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExecuteCommandAccess().getLeftParenthesisKeyword_2()); }

	'(' 

{ after(grammarAccess.getExecuteCommandAccess().getLeftParenthesisKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ExecuteCommand__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ExecuteCommand__Group__3__Impl
	rule__ExecuteCommand__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ExecuteCommand__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExecuteCommandAccess().getGroup_3()); }
(rule__ExecuteCommand__Group_3__0)?
{ after(grammarAccess.getExecuteCommandAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ExecuteCommand__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ExecuteCommand__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ExecuteCommand__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExecuteCommandAccess().getRightParenthesisKeyword_4()); }

	')' 

{ after(grammarAccess.getExecuteCommandAccess().getRightParenthesisKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__ExecuteCommand__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ExecuteCommand__Group_3__0__Impl
	rule__ExecuteCommand__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ExecuteCommand__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExecuteCommandAccess().getArgumentsAssignment_3_0()); }
(rule__ExecuteCommand__ArgumentsAssignment_3_0)
{ after(grammarAccess.getExecuteCommandAccess().getArgumentsAssignment_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ExecuteCommand__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ExecuteCommand__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ExecuteCommand__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExecuteCommandAccess().getGroup_3_1()); }
(rule__ExecuteCommand__Group_3_1__0)*
{ after(grammarAccess.getExecuteCommandAccess().getGroup_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ExecuteCommand__Group_3_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ExecuteCommand__Group_3_1__0__Impl
	rule__ExecuteCommand__Group_3_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ExecuteCommand__Group_3_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExecuteCommandAccess().getCommaKeyword_3_1_0()); }

	',' 

{ after(grammarAccess.getExecuteCommandAccess().getCommaKeyword_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ExecuteCommand__Group_3_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ExecuteCommand__Group_3_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ExecuteCommand__Group_3_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExecuteCommandAccess().getArgumentsAssignment_3_1_1()); }
(rule__ExecuteCommand__ArgumentsAssignment_3_1_1)
{ after(grammarAccess.getExecuteCommandAccess().getArgumentsAssignment_3_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__PrintCommand__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PrintCommand__Group__0__Impl
	rule__PrintCommand__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PrintCommand__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrintCommandAccess().getPrintKeyword_0()); }

	'print' 

{ after(grammarAccess.getPrintCommandAccess().getPrintKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PrintCommand__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PrintCommand__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PrintCommand__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrintCommandAccess().getValueAssignment_1()); }
(rule__PrintCommand__ValueAssignment_1)
{ after(grammarAccess.getPrintCommandAccess().getValueAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__StatePropertyExpression__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StatePropertyExpression__Group__0__Impl
	rule__StatePropertyExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StatePropertyExpression__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStatePropertyExpressionAccess().getStateAssignment_0()); }
(rule__StatePropertyExpression__StateAssignment_0)
{ after(grammarAccess.getStatePropertyExpressionAccess().getStateAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StatePropertyExpression__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StatePropertyExpression__Group__1__Impl
	rule__StatePropertyExpression__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__StatePropertyExpression__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStatePropertyExpressionAccess().getFullStopKeyword_1()); }

	'.' 

{ after(grammarAccess.getStatePropertyExpressionAccess().getFullStopKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StatePropertyExpression__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StatePropertyExpression__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StatePropertyExpression__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStatePropertyExpressionAccess().getPropertyAssignment_2()); }
(rule__StatePropertyExpression__PropertyAssignment_2)
{ after(grammarAccess.getStatePropertyExpressionAccess().getPropertyAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}









rule__Statemachine__StatesAssignment_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStatemachineAccess().getStatesStateParserRuleCall_1_0_0()); }
	ruleState{ after(grammarAccess.getStatemachineAccess().getStatesStateParserRuleCall_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Statemachine__TransitionsAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStatemachineAccess().getTransitionsTransitionParserRuleCall_1_1_0()); }
	ruleTransition{ after(grammarAccess.getStatemachineAccess().getTransitionsTransitionParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__InitialAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getInitialInitialKeyword_0_0()); }
(
{ before(grammarAccess.getStateAccess().getInitialInitialKeyword_0_0()); }

	'initial' 

{ after(grammarAccess.getStateAccess().getInitialInitialKeyword_0_0()); }
)

{ after(grammarAccess.getStateAccess().getInitialInitialKeyword_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__FinalAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getFinalFinalKeyword_1_0()); }
(
{ before(grammarAccess.getStateAccess().getFinalFinalKeyword_1_0()); }

	'final' 

{ after(grammarAccess.getStateAccess().getFinalFinalKeyword_1_0()); }
)

{ after(grammarAccess.getStateAccess().getFinalFinalKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__IdAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getIdIDTerminalRuleCall_3_0()); }
	RULE_ID{ after(grammarAccess.getStateAccess().getIdIDTerminalRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__NameAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getNameSTRINGTerminalRuleCall_4_0()); }
	RULE_STRING{ after(grammarAccess.getStateAccess().getNameSTRINGTerminalRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__ActionsAssignment_5_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getActionsCommandParserRuleCall_5_2_0()); }
	ruleCommand{ after(grammarAccess.getStateAccess().getActionsCommandParserRuleCall_5_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Transition__SourceStateAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTransitionAccess().getSourceStateStateCrossReference_0_0()); }
(
{ before(grammarAccess.getTransitionAccess().getSourceStateStateIDTerminalRuleCall_0_0_1()); }
	RULE_ID{ after(grammarAccess.getTransitionAccess().getSourceStateStateIDTerminalRuleCall_0_0_1()); }
)
{ after(grammarAccess.getTransitionAccess().getSourceStateStateCrossReference_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Transition__TargetStateAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTransitionAccess().getTargetStateStateCrossReference_2_0()); }
(
{ before(grammarAccess.getTransitionAccess().getTargetStateStateIDTerminalRuleCall_2_0_1()); }
	RULE_ID{ after(grammarAccess.getTransitionAccess().getTargetStateStateIDTerminalRuleCall_2_0_1()); }
)
{ after(grammarAccess.getTransitionAccess().getTargetStateStateCrossReference_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Transition__EventAssignment_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTransitionAccess().getEventExpressionParserRuleCall_3_1_0()); }
	ruleExpression{ after(grammarAccess.getTransitionAccess().getEventExpressionParserRuleCall_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SetCommand__SignalAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSetCommandAccess().getSignalIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getSetCommandAccess().getSignalIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SetCommand__ValueAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSetCommandAccess().getValueExpressionParserRuleCall_3_0()); }
	ruleExpression{ after(grammarAccess.getSetCommandAccess().getValueExpressionParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ExecuteCommand__OperationAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExecuteCommandAccess().getOperationIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getExecuteCommandAccess().getOperationIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ExecuteCommand__ArgumentsAssignment_3_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExecuteCommandAccess().getArgumentsExpressionParserRuleCall_3_0_0()); }
	ruleExpression{ after(grammarAccess.getExecuteCommandAccess().getArgumentsExpressionParserRuleCall_3_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ExecuteCommand__ArgumentsAssignment_3_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExecuteCommandAccess().getArgumentsExpressionParserRuleCall_3_1_1_0()); }
	ruleExpression{ after(grammarAccess.getExecuteCommandAccess().getArgumentsExpressionParserRuleCall_3_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PrintCommand__ValueAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrintCommandAccess().getValueExpressionParserRuleCall_1_0()); }
	ruleExpression{ after(grammarAccess.getPrintCommandAccess().getValueExpressionParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__VerbatimExpression__CodeAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getVerbatimExpressionAccess().getCodeSTRINGTerminalRuleCall_0()); }
	RULE_STRING{ after(grammarAccess.getVerbatimExpressionAccess().getCodeSTRINGTerminalRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StatePropertyExpression__StateAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStatePropertyExpressionAccess().getStateStateCrossReference_0_0()); }
(
{ before(grammarAccess.getStatePropertyExpressionAccess().getStateStateIDTerminalRuleCall_0_0_1()); }
	RULE_ID{ after(grammarAccess.getStatePropertyExpressionAccess().getStateStateIDTerminalRuleCall_0_0_1()); }
)
{ after(grammarAccess.getStatePropertyExpressionAccess().getStateStateCrossReference_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StatePropertyExpression__PropertyAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStatePropertyExpressionAccess().getPropertyPropertyEnumRuleCall_2_0()); }
	ruleProperty{ after(grammarAccess.getStatePropertyExpressionAccess().getPropertyPropertyEnumRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


