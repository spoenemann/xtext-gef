package org.xtext.example.statemachine.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
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
public class InternalStatemachineParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'state'", "'actions'", "'{'", "'}'", "'end'", "'=>'", "'('", "')'"
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
    public String getGrammarFileName() { return "../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g"; }



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



    // $ANTLR start "entryRuleStatemachine"
    // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:71:1: entryRuleStatemachine returns [EObject current=null] : iv_ruleStatemachine= ruleStatemachine EOF ;
    public final EObject entryRuleStatemachine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatemachine = null;


        try {
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:72:2: (iv_ruleStatemachine= ruleStatemachine EOF )
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:73:2: iv_ruleStatemachine= ruleStatemachine EOF
            {
             newCompositeNode(grammarAccess.getStatemachineRule()); 
            pushFollow(FOLLOW_ruleStatemachine_in_entryRuleStatemachine75);
            iv_ruleStatemachine=ruleStatemachine();

            state._fsp--;

             current =iv_ruleStatemachine; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatemachine85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatemachine"


    // $ANTLR start "ruleStatemachine"
    // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:80:1: ruleStatemachine returns [EObject current=null] : ( () ( ( (lv_states_1_0= ruleState ) ) | ( (lv_transitions_2_0= ruleTransition ) ) )* ) ;
    public final EObject ruleStatemachine() throws RecognitionException {
        EObject current = null;

        EObject lv_states_1_0 = null;

        EObject lv_transitions_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:83:28: ( ( () ( ( (lv_states_1_0= ruleState ) ) | ( (lv_transitions_2_0= ruleTransition ) ) )* ) )
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:84:1: ( () ( ( (lv_states_1_0= ruleState ) ) | ( (lv_transitions_2_0= ruleTransition ) ) )* )
            {
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:84:1: ( () ( ( (lv_states_1_0= ruleState ) ) | ( (lv_transitions_2_0= ruleTransition ) ) )* )
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:84:2: () ( ( (lv_states_1_0= ruleState ) ) | ( (lv_transitions_2_0= ruleTransition ) ) )*
            {
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:84:2: ()
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:85:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStatemachineAccess().getStatemachineAction_0(),
                        current);
                

            }

            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:90:2: ( ( (lv_states_1_0= ruleState ) ) | ( (lv_transitions_2_0= ruleTransition ) ) )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }
                else if ( (LA1_0==RULE_ID) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:90:3: ( (lv_states_1_0= ruleState ) )
            	    {
            	    // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:90:3: ( (lv_states_1_0= ruleState ) )
            	    // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:91:1: (lv_states_1_0= ruleState )
            	    {
            	    // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:91:1: (lv_states_1_0= ruleState )
            	    // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:92:3: lv_states_1_0= ruleState
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStatemachineAccess().getStatesStateParserRuleCall_1_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleState_in_ruleStatemachine141);
            	    lv_states_1_0=ruleState();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStatemachineRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"states",
            	            		lv_states_1_0, 
            	            		"State");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:109:6: ( (lv_transitions_2_0= ruleTransition ) )
            	    {
            	    // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:109:6: ( (lv_transitions_2_0= ruleTransition ) )
            	    // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:110:1: (lv_transitions_2_0= ruleTransition )
            	    {
            	    // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:110:1: (lv_transitions_2_0= ruleTransition )
            	    // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:111:3: lv_transitions_2_0= ruleTransition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStatemachineAccess().getTransitionsTransitionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTransition_in_ruleStatemachine168);
            	    lv_transitions_2_0=ruleTransition();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStatemachineRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"transitions",
            	            		lv_transitions_2_0, 
            	            		"Transition");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatemachine"


    // $ANTLR start "entryRuleState"
    // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:135:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:136:2: (iv_ruleState= ruleState EOF )
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:137:2: iv_ruleState= ruleState EOF
            {
             newCompositeNode(grammarAccess.getStateRule()); 
            pushFollow(FOLLOW_ruleState_in_entryRuleState206);
            iv_ruleState=ruleState();

            state._fsp--;

             current =iv_ruleState; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleState216); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleState"


    // $ANTLR start "ruleState"
    // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:144:1: ruleState returns [EObject current=null] : (otherlv_0= 'state' ( (lv_id_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_STRING ) )? (otherlv_3= 'actions' otherlv_4= '{' ( (lv_actions_5_0= ruleCommand ) )* otherlv_6= '}' )? otherlv_7= 'end' ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_id_1_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_actions_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:147:28: ( (otherlv_0= 'state' ( (lv_id_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_STRING ) )? (otherlv_3= 'actions' otherlv_4= '{' ( (lv_actions_5_0= ruleCommand ) )* otherlv_6= '}' )? otherlv_7= 'end' ) )
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:148:1: (otherlv_0= 'state' ( (lv_id_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_STRING ) )? (otherlv_3= 'actions' otherlv_4= '{' ( (lv_actions_5_0= ruleCommand ) )* otherlv_6= '}' )? otherlv_7= 'end' )
            {
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:148:1: (otherlv_0= 'state' ( (lv_id_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_STRING ) )? (otherlv_3= 'actions' otherlv_4= '{' ( (lv_actions_5_0= ruleCommand ) )* otherlv_6= '}' )? otherlv_7= 'end' )
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:148:3: otherlv_0= 'state' ( (lv_id_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_STRING ) )? (otherlv_3= 'actions' otherlv_4= '{' ( (lv_actions_5_0= ruleCommand ) )* otherlv_6= '}' )? otherlv_7= 'end'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleState253); 

                	newLeafNode(otherlv_0, grammarAccess.getStateAccess().getStateKeyword_0());
                
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:152:1: ( (lv_id_1_0= RULE_ID ) )
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:153:1: (lv_id_1_0= RULE_ID )
            {
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:153:1: (lv_id_1_0= RULE_ID )
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:154:3: lv_id_1_0= RULE_ID
            {
            lv_id_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleState270); 

            			newLeafNode(lv_id_1_0, grammarAccess.getStateAccess().getIdIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getStateRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"id",
                    		lv_id_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:170:2: ( (lv_name_2_0= RULE_STRING ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_STRING) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:171:1: (lv_name_2_0= RULE_STRING )
                    {
                    // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:171:1: (lv_name_2_0= RULE_STRING )
                    // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:172:3: lv_name_2_0= RULE_STRING
                    {
                    lv_name_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleState292); 

                    			newLeafNode(lv_name_2_0, grammarAccess.getStateAccess().getNameSTRINGTerminalRuleCall_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getStateRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_2_0, 
                            		"STRING");
                    	    

                    }


                    }
                    break;

            }

            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:188:3: (otherlv_3= 'actions' otherlv_4= '{' ( (lv_actions_5_0= ruleCommand ) )* otherlv_6= '}' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==12) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:188:5: otherlv_3= 'actions' otherlv_4= '{' ( (lv_actions_5_0= ruleCommand ) )* otherlv_6= '}'
                    {
                    otherlv_3=(Token)match(input,12,FOLLOW_12_in_ruleState311); 

                        	newLeafNode(otherlv_3, grammarAccess.getStateAccess().getActionsKeyword_3_0());
                        
                    otherlv_4=(Token)match(input,13,FOLLOW_13_in_ruleState323); 

                        	newLeafNode(otherlv_4, grammarAccess.getStateAccess().getLeftCurlyBracketKeyword_3_1());
                        
                    // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:196:1: ( (lv_actions_5_0= ruleCommand ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==RULE_STRING) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:197:1: (lv_actions_5_0= ruleCommand )
                    	    {
                    	    // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:197:1: (lv_actions_5_0= ruleCommand )
                    	    // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:198:3: lv_actions_5_0= ruleCommand
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getStateAccess().getActionsCommandParserRuleCall_3_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleCommand_in_ruleState344);
                    	    lv_actions_5_0=ruleCommand();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getStateRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"actions",
                    	            		lv_actions_5_0, 
                    	            		"Command");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,14,FOLLOW_14_in_ruleState357); 

                        	newLeafNode(otherlv_6, grammarAccess.getStateAccess().getRightCurlyBracketKeyword_3_3());
                        

                    }
                    break;

            }

            otherlv_7=(Token)match(input,15,FOLLOW_15_in_ruleState371); 

                	newLeafNode(otherlv_7, grammarAccess.getStateAccess().getEndKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleState"


    // $ANTLR start "entryRuleTransition"
    // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:230:1: entryRuleTransition returns [EObject current=null] : iv_ruleTransition= ruleTransition EOF ;
    public final EObject entryRuleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransition = null;


        try {
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:231:2: (iv_ruleTransition= ruleTransition EOF )
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:232:2: iv_ruleTransition= ruleTransition EOF
            {
             newCompositeNode(grammarAccess.getTransitionRule()); 
            pushFollow(FOLLOW_ruleTransition_in_entryRuleTransition407);
            iv_ruleTransition=ruleTransition();

            state._fsp--;

             current =iv_ruleTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransition417); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTransition"


    // $ANTLR start "ruleTransition"
    // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:239:1: ruleTransition returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '(' ( (lv_event_4_0= ruleEvent ) )? otherlv_5= ')' )? ) ;
    public final EObject ruleTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_event_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:242:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '(' ( (lv_event_4_0= ruleEvent ) )? otherlv_5= ')' )? ) )
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:243:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '(' ( (lv_event_4_0= ruleEvent ) )? otherlv_5= ')' )? )
            {
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:243:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '(' ( (lv_event_4_0= ruleEvent ) )? otherlv_5= ')' )? )
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:243:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '(' ( (lv_event_4_0= ruleEvent ) )? otherlv_5= ')' )?
            {
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:243:2: ( (otherlv_0= RULE_ID ) )
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:244:1: (otherlv_0= RULE_ID )
            {
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:244:1: (otherlv_0= RULE_ID )
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:245:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTransitionRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTransition462); 

            		newLeafNode(otherlv_0, grammarAccess.getTransitionAccess().getSourceStateStateCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleTransition474); 

                	newLeafNode(otherlv_1, grammarAccess.getTransitionAccess().getEqualsSignGreaterThanSignKeyword_1());
                
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:260:1: ( (otherlv_2= RULE_ID ) )
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:261:1: (otherlv_2= RULE_ID )
            {
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:261:1: (otherlv_2= RULE_ID )
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:262:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTransitionRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTransition494); 

            		newLeafNode(otherlv_2, grammarAccess.getTransitionAccess().getTargetStateStateCrossReference_2_0()); 
            	

            }


            }

            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:273:2: (otherlv_3= '(' ( (lv_event_4_0= ruleEvent ) )? otherlv_5= ')' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:273:4: otherlv_3= '(' ( (lv_event_4_0= ruleEvent ) )? otherlv_5= ')'
                    {
                    otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleTransition507); 

                        	newLeafNode(otherlv_3, grammarAccess.getTransitionAccess().getLeftParenthesisKeyword_3_0());
                        
                    // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:277:1: ( (lv_event_4_0= ruleEvent ) )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==RULE_STRING) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:278:1: (lv_event_4_0= ruleEvent )
                            {
                            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:278:1: (lv_event_4_0= ruleEvent )
                            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:279:3: lv_event_4_0= ruleEvent
                            {
                             
                            	        newCompositeNode(grammarAccess.getTransitionAccess().getEventEventParserRuleCall_3_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleEvent_in_ruleTransition528);
                            lv_event_4_0=ruleEvent();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getTransitionRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"event",
                                    		lv_event_4_0, 
                                    		"Event");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,18,FOLLOW_18_in_ruleTransition541); 

                        	newLeafNode(otherlv_5, grammarAccess.getTransitionAccess().getRightParenthesisKeyword_3_2());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTransition"


    // $ANTLR start "entryRuleEvent"
    // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:307:1: entryRuleEvent returns [EObject current=null] : iv_ruleEvent= ruleEvent EOF ;
    public final EObject entryRuleEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvent = null;


        try {
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:308:2: (iv_ruleEvent= ruleEvent EOF )
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:309:2: iv_ruleEvent= ruleEvent EOF
            {
             newCompositeNode(grammarAccess.getEventRule()); 
            pushFollow(FOLLOW_ruleEvent_in_entryRuleEvent579);
            iv_ruleEvent=ruleEvent();

            state._fsp--;

             current =iv_ruleEvent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEvent589); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEvent"


    // $ANTLR start "ruleEvent"
    // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:316:1: ruleEvent returns [EObject current=null] : ( (lv_code_0_0= RULE_STRING ) ) ;
    public final EObject ruleEvent() throws RecognitionException {
        EObject current = null;

        Token lv_code_0_0=null;

         enterRule(); 
            
        try {
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:319:28: ( ( (lv_code_0_0= RULE_STRING ) ) )
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:320:1: ( (lv_code_0_0= RULE_STRING ) )
            {
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:320:1: ( (lv_code_0_0= RULE_STRING ) )
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:321:1: (lv_code_0_0= RULE_STRING )
            {
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:321:1: (lv_code_0_0= RULE_STRING )
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:322:3: lv_code_0_0= RULE_STRING
            {
            lv_code_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEvent630); 

            			newLeafNode(lv_code_0_0, grammarAccess.getEventAccess().getCodeSTRINGTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEventRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"code",
                    		lv_code_0_0, 
                    		"STRING");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEvent"


    // $ANTLR start "entryRuleCommand"
    // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:346:1: entryRuleCommand returns [EObject current=null] : iv_ruleCommand= ruleCommand EOF ;
    public final EObject entryRuleCommand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommand = null;


        try {
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:347:2: (iv_ruleCommand= ruleCommand EOF )
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:348:2: iv_ruleCommand= ruleCommand EOF
            {
             newCompositeNode(grammarAccess.getCommandRule()); 
            pushFollow(FOLLOW_ruleCommand_in_entryRuleCommand670);
            iv_ruleCommand=ruleCommand();

            state._fsp--;

             current =iv_ruleCommand; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCommand680); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCommand"


    // $ANTLR start "ruleCommand"
    // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:355:1: ruleCommand returns [EObject current=null] : ( (lv_code_0_0= RULE_STRING ) ) ;
    public final EObject ruleCommand() throws RecognitionException {
        EObject current = null;

        Token lv_code_0_0=null;

         enterRule(); 
            
        try {
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:358:28: ( ( (lv_code_0_0= RULE_STRING ) ) )
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:359:1: ( (lv_code_0_0= RULE_STRING ) )
            {
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:359:1: ( (lv_code_0_0= RULE_STRING ) )
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:360:1: (lv_code_0_0= RULE_STRING )
            {
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:360:1: (lv_code_0_0= RULE_STRING )
            // ../org.xtext.example.statemachine/src-gen/org/xtext/example/statemachine/parser/antlr/internal/InternalStatemachine.g:361:3: lv_code_0_0= RULE_STRING
            {
            lv_code_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleCommand721); 

            			newLeafNode(lv_code_0_0, grammarAccess.getCommandAccess().getCodeSTRINGTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getCommandRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"code",
                    		lv_code_0_0, 
                    		"STRING");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCommand"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleStatemachine_in_entryRuleStatemachine75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatemachine85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleState_in_ruleStatemachine141 = new BitSet(new long[]{0x0000000000000812L});
    public static final BitSet FOLLOW_ruleTransition_in_ruleStatemachine168 = new BitSet(new long[]{0x0000000000000812L});
    public static final BitSet FOLLOW_ruleState_in_entryRuleState206 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleState216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleState253 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleState270 = new BitSet(new long[]{0x0000000000009020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleState292 = new BitSet(new long[]{0x0000000000009000L});
    public static final BitSet FOLLOW_12_in_ruleState311 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleState323 = new BitSet(new long[]{0x0000000000004020L});
    public static final BitSet FOLLOW_ruleCommand_in_ruleState344 = new BitSet(new long[]{0x0000000000004020L});
    public static final BitSet FOLLOW_14_in_ruleState357 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleState371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransition_in_entryRuleTransition407 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransition417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTransition462 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleTransition474 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTransition494 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleTransition507 = new BitSet(new long[]{0x0000000000040020L});
    public static final BitSet FOLLOW_ruleEvent_in_ruleTransition528 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleTransition541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvent_in_entryRuleEvent579 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEvent589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleEvent630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommand_in_entryRuleCommand670 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCommand680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleCommand721 = new BitSet(new long[]{0x0000000000000002L});

}