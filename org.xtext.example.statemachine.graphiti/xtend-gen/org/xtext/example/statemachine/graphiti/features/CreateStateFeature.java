/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.xtext.example.statemachine.graphiti.features;

import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.features.IDirectEditingInfo;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.xtext.example.statemachine.statemachine.State;
import org.xtext.example.statemachine.statemachine.Statemachine;
import org.xtext.example.statemachine.statemachine.StatemachineFactory;

@SuppressWarnings("all")
public class CreateStateFeature extends AbstractCreateFeature {
  public CreateStateFeature(final IFeatureProvider fp) {
    super(fp, "State", "Create State");
  }
  
  @Override
  public boolean canCreate(final ICreateContext context) {
    boolean _and = false;
    ContainerShape _targetContainer = context.getTargetContainer();
    if (!(_targetContainer instanceof Diagram)) {
      _and = false;
    } else {
      ContainerShape _targetContainer_1 = context.getTargetContainer();
      Object _businessObjectForPictogramElement = this.getBusinessObjectForPictogramElement(_targetContainer_1);
      _and = (_businessObjectForPictogramElement instanceof Statemachine);
    }
    return _and;
  }
  
  @Override
  public Object[] create(final ICreateContext context) {
    ContainerShape _targetContainer = context.getTargetContainer();
    Object _businessObjectForPictogramElement = this.getBusinessObjectForPictogramElement(_targetContainer);
    final Statemachine statemachine = ((Statemachine) _businessObjectForPictogramElement);
    final State newState = StatemachineFactory.eINSTANCE.createState();
    newState.setName("");
    String _createUniqueStateId = this.createUniqueStateId(statemachine);
    newState.setId(_createUniqueStateId);
    EList<State> _states = statemachine.getStates();
    _states.add(newState);
    this.addGraphicalRepresentation(context, newState);
    IFeatureProvider _featureProvider = this.getFeatureProvider();
    IDirectEditingInfo _directEditingInfo = _featureProvider.getDirectEditingInfo();
    _directEditingInfo.setActive(true);
    return new Object[] { newState };
  }
  
  protected String createUniqueStateId(final Statemachine statemachine) {
    int lastNr = 0;
    EList<State> _states = statemachine.getStates();
    for (final State state : _states) {
      String _id = state.getId();
      boolean _startsWith = _id.startsWith("_state");
      if (_startsWith) {
        try {
          String _id_1 = state.getId();
          String _substring = _id_1.substring(6);
          final int nr = Integer.parseInt(_substring);
          if ((nr > lastNr)) {
            lastNr = nr;
          }
        } catch (final Throwable _t) {
          if (_t instanceof NumberFormatException) {
            final NumberFormatException nfe = (NumberFormatException)_t;
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
    }
    return ("_state" + Integer.valueOf((lastNr + 1)));
  }
}
