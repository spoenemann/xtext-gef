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



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
@SuppressWarnings("all")
public class InternalStatemachineParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'state'", "'end'", "'actions'", "'{'", "'}'", "'=>'", "'('", "')'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=5;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalStatemachineParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalStatemachineParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalStatemachineParser.tokenNames; }
    public String getGrammarFileName() { return "../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g"; }


     
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




    // $ANTLR start "entryRuleStatemachine"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:64:1: entryRuleStatemachine : ruleStatemachine EOF ;
    public final void entryRuleStatemachine() throws RecognitionException {
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:65:1: ( ruleStatemachine EOF )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:66:1: ruleStatemachine EOF
            {
             before(grammarAccess.getStatemachineRule()); 
            pushFollow(FOLLOW_ruleStatemachine_in_entryRuleStatemachine61);
            ruleStatemachine();

            state._fsp--;

             after(grammarAccess.getStatemachineRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatemachine68); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleStatemachine"


    // $ANTLR start "ruleStatemachine"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:73:1: ruleStatemachine : ( ( rule__Statemachine__Group__0 ) ) ;
    public final void ruleStatemachine() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:77:2: ( ( ( rule__Statemachine__Group__0 ) ) )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:78:1: ( ( rule__Statemachine__Group__0 ) )
            {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:78:1: ( ( rule__Statemachine__Group__0 ) )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:79:1: ( rule__Statemachine__Group__0 )
            {
             before(grammarAccess.getStatemachineAccess().getGroup()); 
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:80:1: ( rule__Statemachine__Group__0 )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:80:2: rule__Statemachine__Group__0
            {
            pushFollow(FOLLOW_rule__Statemachine__Group__0_in_ruleStatemachine94);
            rule__Statemachine__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getStatemachineAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStatemachine"


    // $ANTLR start "entryRuleState"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:92:1: entryRuleState : ruleState EOF ;
    public final void entryRuleState() throws RecognitionException {
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:93:1: ( ruleState EOF )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:94:1: ruleState EOF
            {
             before(grammarAccess.getStateRule()); 
            pushFollow(FOLLOW_ruleState_in_entryRuleState121);
            ruleState();

            state._fsp--;

             after(grammarAccess.getStateRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleState128); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleState"


    // $ANTLR start "ruleState"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:101:1: ruleState : ( ( rule__State__Group__0 ) ) ;
    public final void ruleState() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:105:2: ( ( ( rule__State__Group__0 ) ) )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:106:1: ( ( rule__State__Group__0 ) )
            {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:106:1: ( ( rule__State__Group__0 ) )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:107:1: ( rule__State__Group__0 )
            {
             before(grammarAccess.getStateAccess().getGroup()); 
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:108:1: ( rule__State__Group__0 )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:108:2: rule__State__Group__0
            {
            pushFollow(FOLLOW_rule__State__Group__0_in_ruleState154);
            rule__State__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getStateAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleState"


    // $ANTLR start "entryRuleTransition"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:120:1: entryRuleTransition : ruleTransition EOF ;
    public final void entryRuleTransition() throws RecognitionException {
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:121:1: ( ruleTransition EOF )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:122:1: ruleTransition EOF
            {
             before(grammarAccess.getTransitionRule()); 
            pushFollow(FOLLOW_ruleTransition_in_entryRuleTransition181);
            ruleTransition();

            state._fsp--;

             after(grammarAccess.getTransitionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransition188); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTransition"


    // $ANTLR start "ruleTransition"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:129:1: ruleTransition : ( ( rule__Transition__Group__0 ) ) ;
    public final void ruleTransition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:133:2: ( ( ( rule__Transition__Group__0 ) ) )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:134:1: ( ( rule__Transition__Group__0 ) )
            {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:134:1: ( ( rule__Transition__Group__0 ) )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:135:1: ( rule__Transition__Group__0 )
            {
             before(grammarAccess.getTransitionAccess().getGroup()); 
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:136:1: ( rule__Transition__Group__0 )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:136:2: rule__Transition__Group__0
            {
            pushFollow(FOLLOW_rule__Transition__Group__0_in_ruleTransition214);
            rule__Transition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTransitionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTransition"


    // $ANTLR start "entryRuleEvent"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:148:1: entryRuleEvent : ruleEvent EOF ;
    public final void entryRuleEvent() throws RecognitionException {
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:149:1: ( ruleEvent EOF )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:150:1: ruleEvent EOF
            {
             before(grammarAccess.getEventRule()); 
            pushFollow(FOLLOW_ruleEvent_in_entryRuleEvent241);
            ruleEvent();

            state._fsp--;

             after(grammarAccess.getEventRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEvent248); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEvent"


    // $ANTLR start "ruleEvent"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:157:1: ruleEvent : ( ( rule__Event__CodeAssignment ) ) ;
    public final void ruleEvent() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:161:2: ( ( ( rule__Event__CodeAssignment ) ) )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:162:1: ( ( rule__Event__CodeAssignment ) )
            {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:162:1: ( ( rule__Event__CodeAssignment ) )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:163:1: ( rule__Event__CodeAssignment )
            {
             before(grammarAccess.getEventAccess().getCodeAssignment()); 
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:164:1: ( rule__Event__CodeAssignment )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:164:2: rule__Event__CodeAssignment
            {
            pushFollow(FOLLOW_rule__Event__CodeAssignment_in_ruleEvent274);
            rule__Event__CodeAssignment();

            state._fsp--;


            }

             after(grammarAccess.getEventAccess().getCodeAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEvent"


    // $ANTLR start "entryRuleCommand"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:176:1: entryRuleCommand : ruleCommand EOF ;
    public final void entryRuleCommand() throws RecognitionException {
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:177:1: ( ruleCommand EOF )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:178:1: ruleCommand EOF
            {
             before(grammarAccess.getCommandRule()); 
            pushFollow(FOLLOW_ruleCommand_in_entryRuleCommand301);
            ruleCommand();

            state._fsp--;

             after(grammarAccess.getCommandRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCommand308); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCommand"


    // $ANTLR start "ruleCommand"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:185:1: ruleCommand : ( ( rule__Command__CodeAssignment ) ) ;
    public final void ruleCommand() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:189:2: ( ( ( rule__Command__CodeAssignment ) ) )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:190:1: ( ( rule__Command__CodeAssignment ) )
            {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:190:1: ( ( rule__Command__CodeAssignment ) )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:191:1: ( rule__Command__CodeAssignment )
            {
             before(grammarAccess.getCommandAccess().getCodeAssignment()); 
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:192:1: ( rule__Command__CodeAssignment )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:192:2: rule__Command__CodeAssignment
            {
            pushFollow(FOLLOW_rule__Command__CodeAssignment_in_ruleCommand334);
            rule__Command__CodeAssignment();

            state._fsp--;


            }

             after(grammarAccess.getCommandAccess().getCodeAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCommand"


    // $ANTLR start "rule__Statemachine__Alternatives_1"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:204:1: rule__Statemachine__Alternatives_1 : ( ( ( rule__Statemachine__StatesAssignment_1_0 ) ) | ( ( rule__Statemachine__TransitionsAssignment_1_1 ) ) );
    public final void rule__Statemachine__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:208:1: ( ( ( rule__Statemachine__StatesAssignment_1_0 ) ) | ( ( rule__Statemachine__TransitionsAssignment_1_1 ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==11) ) {
                alt1=1;
            }
            else if ( (LA1_0==RULE_ID) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:209:1: ( ( rule__Statemachine__StatesAssignment_1_0 ) )
                    {
                    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:209:1: ( ( rule__Statemachine__StatesAssignment_1_0 ) )
                    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:210:1: ( rule__Statemachine__StatesAssignment_1_0 )
                    {
                     before(grammarAccess.getStatemachineAccess().getStatesAssignment_1_0()); 
                    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:211:1: ( rule__Statemachine__StatesAssignment_1_0 )
                    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:211:2: rule__Statemachine__StatesAssignment_1_0
                    {
                    pushFollow(FOLLOW_rule__Statemachine__StatesAssignment_1_0_in_rule__Statemachine__Alternatives_1370);
                    rule__Statemachine__StatesAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getStatemachineAccess().getStatesAssignment_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:215:6: ( ( rule__Statemachine__TransitionsAssignment_1_1 ) )
                    {
                    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:215:6: ( ( rule__Statemachine__TransitionsAssignment_1_1 ) )
                    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:216:1: ( rule__Statemachine__TransitionsAssignment_1_1 )
                    {
                     before(grammarAccess.getStatemachineAccess().getTransitionsAssignment_1_1()); 
                    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:217:1: ( rule__Statemachine__TransitionsAssignment_1_1 )
                    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:217:2: rule__Statemachine__TransitionsAssignment_1_1
                    {
                    pushFollow(FOLLOW_rule__Statemachine__TransitionsAssignment_1_1_in_rule__Statemachine__Alternatives_1388);
                    rule__Statemachine__TransitionsAssignment_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getStatemachineAccess().getTransitionsAssignment_1_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__Alternatives_1"


    // $ANTLR start "rule__Statemachine__Group__0"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:228:1: rule__Statemachine__Group__0 : rule__Statemachine__Group__0__Impl rule__Statemachine__Group__1 ;
    public final void rule__Statemachine__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:232:1: ( rule__Statemachine__Group__0__Impl rule__Statemachine__Group__1 )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:233:2: rule__Statemachine__Group__0__Impl rule__Statemachine__Group__1
            {
            pushFollow(FOLLOW_rule__Statemachine__Group__0__Impl_in_rule__Statemachine__Group__0419);
            rule__Statemachine__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Statemachine__Group__1_in_rule__Statemachine__Group__0422);
            rule__Statemachine__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__Group__0"


    // $ANTLR start "rule__Statemachine__Group__0__Impl"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:240:1: rule__Statemachine__Group__0__Impl : ( () ) ;
    public final void rule__Statemachine__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:244:1: ( ( () ) )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:245:1: ( () )
            {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:245:1: ( () )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:246:1: ()
            {
             before(grammarAccess.getStatemachineAccess().getStatemachineAction_0()); 
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:247:1: ()
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:249:1: 
            {
            }

             after(grammarAccess.getStatemachineAccess().getStatemachineAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__Group__0__Impl"


    // $ANTLR start "rule__Statemachine__Group__1"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:259:1: rule__Statemachine__Group__1 : rule__Statemachine__Group__1__Impl ;
    public final void rule__Statemachine__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:263:1: ( rule__Statemachine__Group__1__Impl )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:264:2: rule__Statemachine__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Statemachine__Group__1__Impl_in_rule__Statemachine__Group__1480);
            rule__Statemachine__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__Group__1"


    // $ANTLR start "rule__Statemachine__Group__1__Impl"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:270:1: rule__Statemachine__Group__1__Impl : ( ( rule__Statemachine__Alternatives_1 )* ) ;
    public final void rule__Statemachine__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:274:1: ( ( ( rule__Statemachine__Alternatives_1 )* ) )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:275:1: ( ( rule__Statemachine__Alternatives_1 )* )
            {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:275:1: ( ( rule__Statemachine__Alternatives_1 )* )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:276:1: ( rule__Statemachine__Alternatives_1 )*
            {
             before(grammarAccess.getStatemachineAccess().getAlternatives_1()); 
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:277:1: ( rule__Statemachine__Alternatives_1 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID||LA2_0==11) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:277:2: rule__Statemachine__Alternatives_1
            	    {
            	    pushFollow(FOLLOW_rule__Statemachine__Alternatives_1_in_rule__Statemachine__Group__1__Impl507);
            	    rule__Statemachine__Alternatives_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getStatemachineAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__Group__1__Impl"


    // $ANTLR start "rule__State__Group__0"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:291:1: rule__State__Group__0 : rule__State__Group__0__Impl rule__State__Group__1 ;
    public final void rule__State__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:295:1: ( rule__State__Group__0__Impl rule__State__Group__1 )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:296:2: rule__State__Group__0__Impl rule__State__Group__1
            {
            pushFollow(FOLLOW_rule__State__Group__0__Impl_in_rule__State__Group__0542);
            rule__State__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__State__Group__1_in_rule__State__Group__0545);
            rule__State__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__0"


    // $ANTLR start "rule__State__Group__0__Impl"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:303:1: rule__State__Group__0__Impl : ( 'state' ) ;
    public final void rule__State__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:307:1: ( ( 'state' ) )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:308:1: ( 'state' )
            {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:308:1: ( 'state' )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:309:1: 'state'
            {
             before(grammarAccess.getStateAccess().getStateKeyword_0()); 
            match(input,11,FOLLOW_11_in_rule__State__Group__0__Impl573); 
             after(grammarAccess.getStateAccess().getStateKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__0__Impl"


    // $ANTLR start "rule__State__Group__1"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:322:1: rule__State__Group__1 : rule__State__Group__1__Impl rule__State__Group__2 ;
    public final void rule__State__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:326:1: ( rule__State__Group__1__Impl rule__State__Group__2 )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:327:2: rule__State__Group__1__Impl rule__State__Group__2
            {
            pushFollow(FOLLOW_rule__State__Group__1__Impl_in_rule__State__Group__1604);
            rule__State__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__State__Group__2_in_rule__State__Group__1607);
            rule__State__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__1"


    // $ANTLR start "rule__State__Group__1__Impl"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:334:1: rule__State__Group__1__Impl : ( ( rule__State__NameAssignment_1 ) ) ;
    public final void rule__State__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:338:1: ( ( ( rule__State__NameAssignment_1 ) ) )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:339:1: ( ( rule__State__NameAssignment_1 ) )
            {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:339:1: ( ( rule__State__NameAssignment_1 ) )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:340:1: ( rule__State__NameAssignment_1 )
            {
             before(grammarAccess.getStateAccess().getNameAssignment_1()); 
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:341:1: ( rule__State__NameAssignment_1 )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:341:2: rule__State__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__State__NameAssignment_1_in_rule__State__Group__1__Impl634);
            rule__State__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getStateAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__1__Impl"


    // $ANTLR start "rule__State__Group__2"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:351:1: rule__State__Group__2 : rule__State__Group__2__Impl rule__State__Group__3 ;
    public final void rule__State__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:355:1: ( rule__State__Group__2__Impl rule__State__Group__3 )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:356:2: rule__State__Group__2__Impl rule__State__Group__3
            {
            pushFollow(FOLLOW_rule__State__Group__2__Impl_in_rule__State__Group__2664);
            rule__State__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__State__Group__3_in_rule__State__Group__2667);
            rule__State__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__2"


    // $ANTLR start "rule__State__Group__2__Impl"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:363:1: rule__State__Group__2__Impl : ( ( rule__State__Group_2__0 )? ) ;
    public final void rule__State__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:367:1: ( ( ( rule__State__Group_2__0 )? ) )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:368:1: ( ( rule__State__Group_2__0 )? )
            {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:368:1: ( ( rule__State__Group_2__0 )? )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:369:1: ( rule__State__Group_2__0 )?
            {
             before(grammarAccess.getStateAccess().getGroup_2()); 
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:370:1: ( rule__State__Group_2__0 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:370:2: rule__State__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__State__Group_2__0_in_rule__State__Group__2__Impl694);
                    rule__State__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getStateAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__2__Impl"


    // $ANTLR start "rule__State__Group__3"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:380:1: rule__State__Group__3 : rule__State__Group__3__Impl ;
    public final void rule__State__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:384:1: ( rule__State__Group__3__Impl )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:385:2: rule__State__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__State__Group__3__Impl_in_rule__State__Group__3725);
            rule__State__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__3"


    // $ANTLR start "rule__State__Group__3__Impl"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:391:1: rule__State__Group__3__Impl : ( 'end' ) ;
    public final void rule__State__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:395:1: ( ( 'end' ) )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:396:1: ( 'end' )
            {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:396:1: ( 'end' )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:397:1: 'end'
            {
             before(grammarAccess.getStateAccess().getEndKeyword_3()); 
            match(input,12,FOLLOW_12_in_rule__State__Group__3__Impl753); 
             after(grammarAccess.getStateAccess().getEndKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__3__Impl"


    // $ANTLR start "rule__State__Group_2__0"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:418:1: rule__State__Group_2__0 : rule__State__Group_2__0__Impl rule__State__Group_2__1 ;
    public final void rule__State__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:422:1: ( rule__State__Group_2__0__Impl rule__State__Group_2__1 )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:423:2: rule__State__Group_2__0__Impl rule__State__Group_2__1
            {
            pushFollow(FOLLOW_rule__State__Group_2__0__Impl_in_rule__State__Group_2__0792);
            rule__State__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__State__Group_2__1_in_rule__State__Group_2__0795);
            rule__State__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_2__0"


    // $ANTLR start "rule__State__Group_2__0__Impl"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:430:1: rule__State__Group_2__0__Impl : ( 'actions' ) ;
    public final void rule__State__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:434:1: ( ( 'actions' ) )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:435:1: ( 'actions' )
            {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:435:1: ( 'actions' )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:436:1: 'actions'
            {
             before(grammarAccess.getStateAccess().getActionsKeyword_2_0()); 
            match(input,13,FOLLOW_13_in_rule__State__Group_2__0__Impl823); 
             after(grammarAccess.getStateAccess().getActionsKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_2__0__Impl"


    // $ANTLR start "rule__State__Group_2__1"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:449:1: rule__State__Group_2__1 : rule__State__Group_2__1__Impl rule__State__Group_2__2 ;
    public final void rule__State__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:453:1: ( rule__State__Group_2__1__Impl rule__State__Group_2__2 )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:454:2: rule__State__Group_2__1__Impl rule__State__Group_2__2
            {
            pushFollow(FOLLOW_rule__State__Group_2__1__Impl_in_rule__State__Group_2__1854);
            rule__State__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__State__Group_2__2_in_rule__State__Group_2__1857);
            rule__State__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_2__1"


    // $ANTLR start "rule__State__Group_2__1__Impl"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:461:1: rule__State__Group_2__1__Impl : ( '{' ) ;
    public final void rule__State__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:465:1: ( ( '{' ) )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:466:1: ( '{' )
            {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:466:1: ( '{' )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:467:1: '{'
            {
             before(grammarAccess.getStateAccess().getLeftCurlyBracketKeyword_2_1()); 
            match(input,14,FOLLOW_14_in_rule__State__Group_2__1__Impl885); 
             after(grammarAccess.getStateAccess().getLeftCurlyBracketKeyword_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_2__1__Impl"


    // $ANTLR start "rule__State__Group_2__2"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:480:1: rule__State__Group_2__2 : rule__State__Group_2__2__Impl rule__State__Group_2__3 ;
    public final void rule__State__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:484:1: ( rule__State__Group_2__2__Impl rule__State__Group_2__3 )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:485:2: rule__State__Group_2__2__Impl rule__State__Group_2__3
            {
            pushFollow(FOLLOW_rule__State__Group_2__2__Impl_in_rule__State__Group_2__2916);
            rule__State__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__State__Group_2__3_in_rule__State__Group_2__2919);
            rule__State__Group_2__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_2__2"


    // $ANTLR start "rule__State__Group_2__2__Impl"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:492:1: rule__State__Group_2__2__Impl : ( ( rule__State__ActionsAssignment_2_2 )* ) ;
    public final void rule__State__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:496:1: ( ( ( rule__State__ActionsAssignment_2_2 )* ) )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:497:1: ( ( rule__State__ActionsAssignment_2_2 )* )
            {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:497:1: ( ( rule__State__ActionsAssignment_2_2 )* )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:498:1: ( rule__State__ActionsAssignment_2_2 )*
            {
             before(grammarAccess.getStateAccess().getActionsAssignment_2_2()); 
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:499:1: ( rule__State__ActionsAssignment_2_2 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_STRING) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:499:2: rule__State__ActionsAssignment_2_2
            	    {
            	    pushFollow(FOLLOW_rule__State__ActionsAssignment_2_2_in_rule__State__Group_2__2__Impl946);
            	    rule__State__ActionsAssignment_2_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getStateAccess().getActionsAssignment_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_2__2__Impl"


    // $ANTLR start "rule__State__Group_2__3"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:509:1: rule__State__Group_2__3 : rule__State__Group_2__3__Impl ;
    public final void rule__State__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:513:1: ( rule__State__Group_2__3__Impl )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:514:2: rule__State__Group_2__3__Impl
            {
            pushFollow(FOLLOW_rule__State__Group_2__3__Impl_in_rule__State__Group_2__3977);
            rule__State__Group_2__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_2__3"


    // $ANTLR start "rule__State__Group_2__3__Impl"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:520:1: rule__State__Group_2__3__Impl : ( '}' ) ;
    public final void rule__State__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:524:1: ( ( '}' ) )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:525:1: ( '}' )
            {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:525:1: ( '}' )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:526:1: '}'
            {
             before(grammarAccess.getStateAccess().getRightCurlyBracketKeyword_2_3()); 
            match(input,15,FOLLOW_15_in_rule__State__Group_2__3__Impl1005); 
             after(grammarAccess.getStateAccess().getRightCurlyBracketKeyword_2_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_2__3__Impl"


    // $ANTLR start "rule__Transition__Group__0"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:547:1: rule__Transition__Group__0 : rule__Transition__Group__0__Impl rule__Transition__Group__1 ;
    public final void rule__Transition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:551:1: ( rule__Transition__Group__0__Impl rule__Transition__Group__1 )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:552:2: rule__Transition__Group__0__Impl rule__Transition__Group__1
            {
            pushFollow(FOLLOW_rule__Transition__Group__0__Impl_in_rule__Transition__Group__01044);
            rule__Transition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Transition__Group__1_in_rule__Transition__Group__01047);
            rule__Transition__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__0"


    // $ANTLR start "rule__Transition__Group__0__Impl"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:559:1: rule__Transition__Group__0__Impl : ( ( rule__Transition__SourceStateAssignment_0 ) ) ;
    public final void rule__Transition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:563:1: ( ( ( rule__Transition__SourceStateAssignment_0 ) ) )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:564:1: ( ( rule__Transition__SourceStateAssignment_0 ) )
            {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:564:1: ( ( rule__Transition__SourceStateAssignment_0 ) )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:565:1: ( rule__Transition__SourceStateAssignment_0 )
            {
             before(grammarAccess.getTransitionAccess().getSourceStateAssignment_0()); 
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:566:1: ( rule__Transition__SourceStateAssignment_0 )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:566:2: rule__Transition__SourceStateAssignment_0
            {
            pushFollow(FOLLOW_rule__Transition__SourceStateAssignment_0_in_rule__Transition__Group__0__Impl1074);
            rule__Transition__SourceStateAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getTransitionAccess().getSourceStateAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__0__Impl"


    // $ANTLR start "rule__Transition__Group__1"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:576:1: rule__Transition__Group__1 : rule__Transition__Group__1__Impl rule__Transition__Group__2 ;
    public final void rule__Transition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:580:1: ( rule__Transition__Group__1__Impl rule__Transition__Group__2 )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:581:2: rule__Transition__Group__1__Impl rule__Transition__Group__2
            {
            pushFollow(FOLLOW_rule__Transition__Group__1__Impl_in_rule__Transition__Group__11104);
            rule__Transition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Transition__Group__2_in_rule__Transition__Group__11107);
            rule__Transition__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__1"


    // $ANTLR start "rule__Transition__Group__1__Impl"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:588:1: rule__Transition__Group__1__Impl : ( '=>' ) ;
    public final void rule__Transition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:592:1: ( ( '=>' ) )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:593:1: ( '=>' )
            {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:593:1: ( '=>' )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:594:1: '=>'
            {
             before(grammarAccess.getTransitionAccess().getEqualsSignGreaterThanSignKeyword_1()); 
            match(input,16,FOLLOW_16_in_rule__Transition__Group__1__Impl1135); 
             after(grammarAccess.getTransitionAccess().getEqualsSignGreaterThanSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__1__Impl"


    // $ANTLR start "rule__Transition__Group__2"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:607:1: rule__Transition__Group__2 : rule__Transition__Group__2__Impl rule__Transition__Group__3 ;
    public final void rule__Transition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:611:1: ( rule__Transition__Group__2__Impl rule__Transition__Group__3 )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:612:2: rule__Transition__Group__2__Impl rule__Transition__Group__3
            {
            pushFollow(FOLLOW_rule__Transition__Group__2__Impl_in_rule__Transition__Group__21166);
            rule__Transition__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Transition__Group__3_in_rule__Transition__Group__21169);
            rule__Transition__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__2"


    // $ANTLR start "rule__Transition__Group__2__Impl"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:619:1: rule__Transition__Group__2__Impl : ( ( rule__Transition__TargetStateAssignment_2 ) ) ;
    public final void rule__Transition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:623:1: ( ( ( rule__Transition__TargetStateAssignment_2 ) ) )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:624:1: ( ( rule__Transition__TargetStateAssignment_2 ) )
            {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:624:1: ( ( rule__Transition__TargetStateAssignment_2 ) )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:625:1: ( rule__Transition__TargetStateAssignment_2 )
            {
             before(grammarAccess.getTransitionAccess().getTargetStateAssignment_2()); 
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:626:1: ( rule__Transition__TargetStateAssignment_2 )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:626:2: rule__Transition__TargetStateAssignment_2
            {
            pushFollow(FOLLOW_rule__Transition__TargetStateAssignment_2_in_rule__Transition__Group__2__Impl1196);
            rule__Transition__TargetStateAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getTransitionAccess().getTargetStateAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__2__Impl"


    // $ANTLR start "rule__Transition__Group__3"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:636:1: rule__Transition__Group__3 : rule__Transition__Group__3__Impl ;
    public final void rule__Transition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:640:1: ( rule__Transition__Group__3__Impl )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:641:2: rule__Transition__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Transition__Group__3__Impl_in_rule__Transition__Group__31226);
            rule__Transition__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__3"


    // $ANTLR start "rule__Transition__Group__3__Impl"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:647:1: rule__Transition__Group__3__Impl : ( ( rule__Transition__Group_3__0 )? ) ;
    public final void rule__Transition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:651:1: ( ( ( rule__Transition__Group_3__0 )? ) )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:652:1: ( ( rule__Transition__Group_3__0 )? )
            {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:652:1: ( ( rule__Transition__Group_3__0 )? )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:653:1: ( rule__Transition__Group_3__0 )?
            {
             before(grammarAccess.getTransitionAccess().getGroup_3()); 
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:654:1: ( rule__Transition__Group_3__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==17) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:654:2: rule__Transition__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Transition__Group_3__0_in_rule__Transition__Group__3__Impl1253);
                    rule__Transition__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTransitionAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__3__Impl"


    // $ANTLR start "rule__Transition__Group_3__0"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:672:1: rule__Transition__Group_3__0 : rule__Transition__Group_3__0__Impl rule__Transition__Group_3__1 ;
    public final void rule__Transition__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:676:1: ( rule__Transition__Group_3__0__Impl rule__Transition__Group_3__1 )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:677:2: rule__Transition__Group_3__0__Impl rule__Transition__Group_3__1
            {
            pushFollow(FOLLOW_rule__Transition__Group_3__0__Impl_in_rule__Transition__Group_3__01292);
            rule__Transition__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Transition__Group_3__1_in_rule__Transition__Group_3__01295);
            rule__Transition__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_3__0"


    // $ANTLR start "rule__Transition__Group_3__0__Impl"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:684:1: rule__Transition__Group_3__0__Impl : ( '(' ) ;
    public final void rule__Transition__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:688:1: ( ( '(' ) )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:689:1: ( '(' )
            {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:689:1: ( '(' )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:690:1: '('
            {
             before(grammarAccess.getTransitionAccess().getLeftParenthesisKeyword_3_0()); 
            match(input,17,FOLLOW_17_in_rule__Transition__Group_3__0__Impl1323); 
             after(grammarAccess.getTransitionAccess().getLeftParenthesisKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_3__0__Impl"


    // $ANTLR start "rule__Transition__Group_3__1"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:703:1: rule__Transition__Group_3__1 : rule__Transition__Group_3__1__Impl rule__Transition__Group_3__2 ;
    public final void rule__Transition__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:707:1: ( rule__Transition__Group_3__1__Impl rule__Transition__Group_3__2 )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:708:2: rule__Transition__Group_3__1__Impl rule__Transition__Group_3__2
            {
            pushFollow(FOLLOW_rule__Transition__Group_3__1__Impl_in_rule__Transition__Group_3__11354);
            rule__Transition__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Transition__Group_3__2_in_rule__Transition__Group_3__11357);
            rule__Transition__Group_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_3__1"


    // $ANTLR start "rule__Transition__Group_3__1__Impl"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:715:1: rule__Transition__Group_3__1__Impl : ( ( rule__Transition__EventAssignment_3_1 )? ) ;
    public final void rule__Transition__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:719:1: ( ( ( rule__Transition__EventAssignment_3_1 )? ) )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:720:1: ( ( rule__Transition__EventAssignment_3_1 )? )
            {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:720:1: ( ( rule__Transition__EventAssignment_3_1 )? )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:721:1: ( rule__Transition__EventAssignment_3_1 )?
            {
             before(grammarAccess.getTransitionAccess().getEventAssignment_3_1()); 
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:722:1: ( rule__Transition__EventAssignment_3_1 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_STRING) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:722:2: rule__Transition__EventAssignment_3_1
                    {
                    pushFollow(FOLLOW_rule__Transition__EventAssignment_3_1_in_rule__Transition__Group_3__1__Impl1384);
                    rule__Transition__EventAssignment_3_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTransitionAccess().getEventAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_3__1__Impl"


    // $ANTLR start "rule__Transition__Group_3__2"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:732:1: rule__Transition__Group_3__2 : rule__Transition__Group_3__2__Impl ;
    public final void rule__Transition__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:736:1: ( rule__Transition__Group_3__2__Impl )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:737:2: rule__Transition__Group_3__2__Impl
            {
            pushFollow(FOLLOW_rule__Transition__Group_3__2__Impl_in_rule__Transition__Group_3__21415);
            rule__Transition__Group_3__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_3__2"


    // $ANTLR start "rule__Transition__Group_3__2__Impl"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:743:1: rule__Transition__Group_3__2__Impl : ( ')' ) ;
    public final void rule__Transition__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:747:1: ( ( ')' ) )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:748:1: ( ')' )
            {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:748:1: ( ')' )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:749:1: ')'
            {
             before(grammarAccess.getTransitionAccess().getRightParenthesisKeyword_3_2()); 
            match(input,18,FOLLOW_18_in_rule__Transition__Group_3__2__Impl1443); 
             after(grammarAccess.getTransitionAccess().getRightParenthesisKeyword_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_3__2__Impl"


    // $ANTLR start "rule__Statemachine__StatesAssignment_1_0"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:769:1: rule__Statemachine__StatesAssignment_1_0 : ( ruleState ) ;
    public final void rule__Statemachine__StatesAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:773:1: ( ( ruleState ) )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:774:1: ( ruleState )
            {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:774:1: ( ruleState )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:775:1: ruleState
            {
             before(grammarAccess.getStatemachineAccess().getStatesStateParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_ruleState_in_rule__Statemachine__StatesAssignment_1_01485);
            ruleState();

            state._fsp--;

             after(grammarAccess.getStatemachineAccess().getStatesStateParserRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__StatesAssignment_1_0"


    // $ANTLR start "rule__Statemachine__TransitionsAssignment_1_1"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:784:1: rule__Statemachine__TransitionsAssignment_1_1 : ( ruleTransition ) ;
    public final void rule__Statemachine__TransitionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:788:1: ( ( ruleTransition ) )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:789:1: ( ruleTransition )
            {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:789:1: ( ruleTransition )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:790:1: ruleTransition
            {
             before(grammarAccess.getStatemachineAccess().getTransitionsTransitionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleTransition_in_rule__Statemachine__TransitionsAssignment_1_11516);
            ruleTransition();

            state._fsp--;

             after(grammarAccess.getStatemachineAccess().getTransitionsTransitionParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statemachine__TransitionsAssignment_1_1"


    // $ANTLR start "rule__State__NameAssignment_1"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:799:1: rule__State__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__State__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:803:1: ( ( RULE_ID ) )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:804:1: ( RULE_ID )
            {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:804:1: ( RULE_ID )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:805:1: RULE_ID
            {
             before(grammarAccess.getStateAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__State__NameAssignment_11547); 
             after(grammarAccess.getStateAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__NameAssignment_1"


    // $ANTLR start "rule__State__ActionsAssignment_2_2"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:814:1: rule__State__ActionsAssignment_2_2 : ( ruleCommand ) ;
    public final void rule__State__ActionsAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:818:1: ( ( ruleCommand ) )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:819:1: ( ruleCommand )
            {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:819:1: ( ruleCommand )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:820:1: ruleCommand
            {
             before(grammarAccess.getStateAccess().getActionsCommandParserRuleCall_2_2_0()); 
            pushFollow(FOLLOW_ruleCommand_in_rule__State__ActionsAssignment_2_21578);
            ruleCommand();

            state._fsp--;

             after(grammarAccess.getStateAccess().getActionsCommandParserRuleCall_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__ActionsAssignment_2_2"


    // $ANTLR start "rule__Transition__SourceStateAssignment_0"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:829:1: rule__Transition__SourceStateAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__Transition__SourceStateAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:833:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:834:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:834:1: ( ( RULE_ID ) )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:835:1: ( RULE_ID )
            {
             before(grammarAccess.getTransitionAccess().getSourceStateStateCrossReference_0_0()); 
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:836:1: ( RULE_ID )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:837:1: RULE_ID
            {
             before(grammarAccess.getTransitionAccess().getSourceStateStateIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Transition__SourceStateAssignment_01613); 
             after(grammarAccess.getTransitionAccess().getSourceStateStateIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getTransitionAccess().getSourceStateStateCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__SourceStateAssignment_0"


    // $ANTLR start "rule__Transition__TargetStateAssignment_2"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:848:1: rule__Transition__TargetStateAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__Transition__TargetStateAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:852:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:853:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:853:1: ( ( RULE_ID ) )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:854:1: ( RULE_ID )
            {
             before(grammarAccess.getTransitionAccess().getTargetStateStateCrossReference_2_0()); 
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:855:1: ( RULE_ID )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:856:1: RULE_ID
            {
             before(grammarAccess.getTransitionAccess().getTargetStateStateIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Transition__TargetStateAssignment_21652); 
             after(grammarAccess.getTransitionAccess().getTargetStateStateIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getTransitionAccess().getTargetStateStateCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__TargetStateAssignment_2"


    // $ANTLR start "rule__Transition__EventAssignment_3_1"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:867:1: rule__Transition__EventAssignment_3_1 : ( ruleEvent ) ;
    public final void rule__Transition__EventAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:871:1: ( ( ruleEvent ) )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:872:1: ( ruleEvent )
            {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:872:1: ( ruleEvent )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:873:1: ruleEvent
            {
             before(grammarAccess.getTransitionAccess().getEventEventParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleEvent_in_rule__Transition__EventAssignment_3_11687);
            ruleEvent();

            state._fsp--;

             after(grammarAccess.getTransitionAccess().getEventEventParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__EventAssignment_3_1"


    // $ANTLR start "rule__Event__CodeAssignment"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:882:1: rule__Event__CodeAssignment : ( RULE_STRING ) ;
    public final void rule__Event__CodeAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:886:1: ( ( RULE_STRING ) )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:887:1: ( RULE_STRING )
            {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:887:1: ( RULE_STRING )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:888:1: RULE_STRING
            {
             before(grammarAccess.getEventAccess().getCodeSTRINGTerminalRuleCall_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Event__CodeAssignment1718); 
             after(grammarAccess.getEventAccess().getCodeSTRINGTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Event__CodeAssignment"


    // $ANTLR start "rule__Command__CodeAssignment"
    // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:897:1: rule__Command__CodeAssignment : ( RULE_STRING ) ;
    public final void rule__Command__CodeAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:901:1: ( ( RULE_STRING ) )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:902:1: ( RULE_STRING )
            {
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:902:1: ( RULE_STRING )
            // ../org.xtext.example.statemachine.ui/src-gen/org/xtext/example/statemachine/ui/contentassist/antlr/internal/InternalStatemachine.g:903:1: RULE_STRING
            {
             before(grammarAccess.getCommandAccess().getCodeSTRINGTerminalRuleCall_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Command__CodeAssignment1749); 
             after(grammarAccess.getCommandAccess().getCodeSTRINGTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Command__CodeAssignment"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleStatemachine_in_entryRuleStatemachine61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatemachine68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__0_in_ruleStatemachine94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleState_in_entryRuleState121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleState128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__Group__0_in_ruleState154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransition_in_entryRuleTransition181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransition188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transition__Group__0_in_ruleTransition214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvent_in_entryRuleEvent241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEvent248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Event__CodeAssignment_in_ruleEvent274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommand_in_entryRuleCommand301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCommand308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Command__CodeAssignment_in_ruleCommand334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__StatesAssignment_1_0_in_rule__Statemachine__Alternatives_1370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__TransitionsAssignment_1_1_in_rule__Statemachine__Alternatives_1388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__0__Impl_in_rule__Statemachine__Group__0419 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__1_in_rule__Statemachine__Group__0422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__1__Impl_in_rule__Statemachine__Group__1480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__Alternatives_1_in_rule__Statemachine__Group__1__Impl507 = new BitSet(new long[]{0x0000000000000812L});
    public static final BitSet FOLLOW_rule__State__Group__0__Impl_in_rule__State__Group__0542 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__State__Group__1_in_rule__State__Group__0545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__State__Group__0__Impl573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__Group__1__Impl_in_rule__State__Group__1604 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_rule__State__Group__2_in_rule__State__Group__1607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__NameAssignment_1_in_rule__State__Group__1__Impl634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__Group__2__Impl_in_rule__State__Group__2664 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_rule__State__Group__3_in_rule__State__Group__2667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__Group_2__0_in_rule__State__Group__2__Impl694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__Group__3__Impl_in_rule__State__Group__3725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__State__Group__3__Impl753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__Group_2__0__Impl_in_rule__State__Group_2__0792 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__State__Group_2__1_in_rule__State__Group_2__0795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__State__Group_2__0__Impl823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__Group_2__1__Impl_in_rule__State__Group_2__1854 = new BitSet(new long[]{0x0000000000008020L});
    public static final BitSet FOLLOW_rule__State__Group_2__2_in_rule__State__Group_2__1857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__State__Group_2__1__Impl885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__Group_2__2__Impl_in_rule__State__Group_2__2916 = new BitSet(new long[]{0x0000000000008020L});
    public static final BitSet FOLLOW_rule__State__Group_2__3_in_rule__State__Group_2__2919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__ActionsAssignment_2_2_in_rule__State__Group_2__2__Impl946 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__State__Group_2__3__Impl_in_rule__State__Group_2__3977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__State__Group_2__3__Impl1005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transition__Group__0__Impl_in_rule__Transition__Group__01044 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Transition__Group__1_in_rule__Transition__Group__01047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transition__SourceStateAssignment_0_in_rule__Transition__Group__0__Impl1074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transition__Group__1__Impl_in_rule__Transition__Group__11104 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Transition__Group__2_in_rule__Transition__Group__11107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Transition__Group__1__Impl1135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transition__Group__2__Impl_in_rule__Transition__Group__21166 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__Transition__Group__3_in_rule__Transition__Group__21169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transition__TargetStateAssignment_2_in_rule__Transition__Group__2__Impl1196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transition__Group__3__Impl_in_rule__Transition__Group__31226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transition__Group_3__0_in_rule__Transition__Group__3__Impl1253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transition__Group_3__0__Impl_in_rule__Transition__Group_3__01292 = new BitSet(new long[]{0x0000000000040020L});
    public static final BitSet FOLLOW_rule__Transition__Group_3__1_in_rule__Transition__Group_3__01295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Transition__Group_3__0__Impl1323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transition__Group_3__1__Impl_in_rule__Transition__Group_3__11354 = new BitSet(new long[]{0x0000000000040020L});
    public static final BitSet FOLLOW_rule__Transition__Group_3__2_in_rule__Transition__Group_3__11357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transition__EventAssignment_3_1_in_rule__Transition__Group_3__1__Impl1384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transition__Group_3__2__Impl_in_rule__Transition__Group_3__21415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Transition__Group_3__2__Impl1443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleState_in_rule__Statemachine__StatesAssignment_1_01485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransition_in_rule__Statemachine__TransitionsAssignment_1_11516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__State__NameAssignment_11547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommand_in_rule__State__ActionsAssignment_2_21578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Transition__SourceStateAssignment_01613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Transition__TargetStateAssignment_21652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvent_in_rule__Transition__EventAssignment_3_11687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Event__CodeAssignment1718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Command__CodeAssignment1749 = new BitSet(new long[]{0x0000000000000002L});

}