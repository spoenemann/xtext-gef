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



// Entry rule entryRuleEvent
entryRuleEvent 
:
{ before(grammarAccess.getEventRule()); }
	 ruleEvent
{ after(grammarAccess.getEventRule()); } 
	 EOF 
;

// Rule Event
ruleEvent
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getEventAccess().getCodeAssignment()); }
(rule__Event__CodeAssignment)
{ after(grammarAccess.getEventAccess().getCodeAssignment()); }
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
{ before(grammarAccess.getCommandAccess().getCodeAssignment()); }
(rule__Command__CodeAssignment)
{ after(grammarAccess.getCommandAccess().getCodeAssignment()); }
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
{ before(grammarAccess.getStateAccess().getStateKeyword_0()); }

	'state' 

{ after(grammarAccess.getStateAccess().getStateKeyword_0()); }
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
{ before(grammarAccess.getStateAccess().getNameAssignment_1()); }
(rule__State__NameAssignment_1)
{ after(grammarAccess.getStateAccess().getNameAssignment_1()); }
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
{ before(grammarAccess.getStateAccess().getGroup_2()); }
(rule__State__Group_2__0)?
{ after(grammarAccess.getStateAccess().getGroup_2()); }
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
{ before(grammarAccess.getStateAccess().getEndKeyword_3()); }

	'end' 

{ after(grammarAccess.getStateAccess().getEndKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__State__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__State__Group_2__0__Impl
	rule__State__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__State__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getActionsKeyword_2_0()); }

	'actions' 

{ after(grammarAccess.getStateAccess().getActionsKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__State__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__State__Group_2__1__Impl
	rule__State__Group_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__State__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getLeftCurlyBracketKeyword_2_1()); }

	'{' 

{ after(grammarAccess.getStateAccess().getLeftCurlyBracketKeyword_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__State__Group_2__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__State__Group_2__2__Impl
	rule__State__Group_2__3
;
finally {
	restoreStackSize(stackSize);
}

rule__State__Group_2__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getActionsAssignment_2_2()); }
(rule__State__ActionsAssignment_2_2)*
{ after(grammarAccess.getStateAccess().getActionsAssignment_2_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__State__Group_2__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__State__Group_2__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__State__Group_2__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getRightCurlyBracketKeyword_2_3()); }

	'}' 

{ after(grammarAccess.getStateAccess().getRightCurlyBracketKeyword_2_3()); }
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

rule__State__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getStateAccess().getNameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__State__ActionsAssignment_2_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStateAccess().getActionsCommandParserRuleCall_2_2_0()); }
	ruleCommand{ after(grammarAccess.getStateAccess().getActionsCommandParserRuleCall_2_2_0()); }
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
{ before(grammarAccess.getTransitionAccess().getEventEventParserRuleCall_3_1_0()); }
	ruleEvent{ after(grammarAccess.getTransitionAccess().getEventEventParserRuleCall_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Event__CodeAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEventAccess().getCodeSTRINGTerminalRuleCall_0()); }
	RULE_STRING{ after(grammarAccess.getEventAccess().getCodeSTRINGTerminalRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Command__CodeAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCommandAccess().getCodeSTRINGTerminalRuleCall_0()); }
	RULE_STRING{ after(grammarAccess.getCommandAccess().getCodeSTRINGTerminalRuleCall_0()); }
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


