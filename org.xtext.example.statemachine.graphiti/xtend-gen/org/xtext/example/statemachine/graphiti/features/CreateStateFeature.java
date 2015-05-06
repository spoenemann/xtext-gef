/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.xtext.example.statemachine.graphiti.features;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.IDirectEditingInfo;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.xtext.example.statemachine.StatemachineUtil;
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
    EList<State> _states = statemachine.getStates();
    _states.add(newState);
    Resource _eResource = statemachine.eResource();
    StatemachineUtil.ensureUniqueIds(_eResource);
    this.addGraphicalRepresentation(context, newState);
    IFeatureProvider _featureProvider = this.getFeatureProvider();
    IDirectEditingInfo _directEditingInfo = _featureProvider.getDirectEditingInfo();
    _directEditingInfo.setActive(true);
    return new Object[] { newState };
  }
}
