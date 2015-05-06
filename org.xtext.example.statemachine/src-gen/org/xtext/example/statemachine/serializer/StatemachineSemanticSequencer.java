/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xtext.example.statemachine.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.xtext.example.statemachine.services.StatemachineGrammarAccess;
import org.xtext.example.statemachine.statemachine.ExecuteCommand;
import org.xtext.example.statemachine.statemachine.PrintCommand;
import org.xtext.example.statemachine.statemachine.SetCommand;
import org.xtext.example.statemachine.statemachine.State;
import org.xtext.example.statemachine.statemachine.StatePropertyExpression;
import org.xtext.example.statemachine.statemachine.Statemachine;
import org.xtext.example.statemachine.statemachine.StatemachinePackage;
import org.xtext.example.statemachine.statemachine.Transition;
import org.xtext.example.statemachine.statemachine.VerbatimExpression;

@SuppressWarnings("all")
public class StatemachineSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private StatemachineGrammarAccess grammarAccess;
	
	@Override
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == StatemachinePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case StatemachinePackage.EXECUTE_COMMAND:
				sequence_ExecuteCommand(context, (ExecuteCommand) semanticObject); 
				return; 
			case StatemachinePackage.PRINT_COMMAND:
				sequence_PrintCommand(context, (PrintCommand) semanticObject); 
				return; 
			case StatemachinePackage.SET_COMMAND:
				sequence_SetCommand(context, (SetCommand) semanticObject); 
				return; 
			case StatemachinePackage.STATE:
				sequence_State(context, (State) semanticObject); 
				return; 
			case StatemachinePackage.STATE_PROPERTY_EXPRESSION:
				sequence_StatePropertyExpression(context, (StatePropertyExpression) semanticObject); 
				return; 
			case StatemachinePackage.STATEMACHINE:
				sequence_Statemachine(context, (Statemachine) semanticObject); 
				return; 
			case StatemachinePackage.TRANSITION:
				sequence_Transition(context, (Transition) semanticObject); 
				return; 
			case StatemachinePackage.VERBATIM_EXPRESSION:
				sequence_VerbatimExpression(context, (VerbatimExpression) semanticObject); 
				return; 
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (operation=ID (arguments+=Expression arguments+=Expression*)?)
	 */
	protected void sequence_ExecuteCommand(EObject context, ExecuteCommand semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=Expression
	 */
	protected void sequence_PrintCommand(EObject context, PrintCommand semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, StatemachinePackage.Literals.PRINT_COMMAND__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StatemachinePackage.Literals.PRINT_COMMAND__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPrintCommandAccess().getValueExpressionParserRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (signal=ID value=Expression)
	 */
	protected void sequence_SetCommand(EObject context, SetCommand semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, StatemachinePackage.Literals.SET_COMMAND__SIGNAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StatemachinePackage.Literals.SET_COMMAND__SIGNAL));
			if(transientValues.isValueTransient(semanticObject, StatemachinePackage.Literals.SET_COMMAND__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StatemachinePackage.Literals.SET_COMMAND__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSetCommandAccess().getSignalIDTerminalRuleCall_1_0(), semanticObject.getSignal());
		feeder.accept(grammarAccess.getSetCommandAccess().getValueExpressionParserRuleCall_3_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (state=[State|ID] property=ID)
	 */
	protected void sequence_StatePropertyExpression(EObject context, StatePropertyExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, StatemachinePackage.Literals.STATE_PROPERTY_EXPRESSION__STATE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StatemachinePackage.Literals.STATE_PROPERTY_EXPRESSION__STATE));
			if(transientValues.isValueTransient(semanticObject, StatemachinePackage.Literals.STATE_PROPERTY_EXPRESSION__PROPERTY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StatemachinePackage.Literals.STATE_PROPERTY_EXPRESSION__PROPERTY));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getStatePropertyExpressionAccess().getStateStateIDTerminalRuleCall_0_0_1(), semanticObject.getState());
		feeder.accept(grammarAccess.getStatePropertyExpressionAccess().getPropertyIDTerminalRuleCall_2_0(), semanticObject.getProperty());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (initial?='initial'? final?='final'? id=ID name=STRING? actions+=Command*)
	 */
	protected void sequence_State(EObject context, State semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((states+=State | transitions+=Transition)*)
	 */
	protected void sequence_Statemachine(EObject context, Statemachine semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (sourceState=[State|ID] targetState=[State|ID] event=Expression?)
	 */
	protected void sequence_Transition(EObject context, Transition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     code=STRING
	 */
	protected void sequence_VerbatimExpression(EObject context, VerbatimExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, StatemachinePackage.Literals.VERBATIM_EXPRESSION__CODE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StatemachinePackage.Literals.VERBATIM_EXPRESSION__CODE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getVerbatimExpressionAccess().getCodeSTRINGTerminalRuleCall_0(), semanticObject.getCode());
		feeder.finish();
	}
}
