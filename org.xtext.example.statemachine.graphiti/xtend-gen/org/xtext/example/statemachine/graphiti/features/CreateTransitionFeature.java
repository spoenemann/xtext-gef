/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.xtext.example.statemachine.graphiti.features;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.xtext.example.statemachine.statemachine.State;
import org.xtext.example.statemachine.statemachine.Statemachine;
import org.xtext.example.statemachine.statemachine.StatemachineFactory;
import org.xtext.example.statemachine.statemachine.Transition;

@SuppressWarnings("all")
public class CreateTransitionFeature extends AbstractCreateConnectionFeature {
  public CreateTransitionFeature(final IFeatureProvider fp) {
    super(fp, "Transition", "Create Transition");
  }
  
  @Override
  public boolean canCreate(final ICreateConnectionContext context) {
    boolean _and = false;
    Anchor _sourceAnchor = context.getSourceAnchor();
    AnchorContainer _parent = null;
    if (_sourceAnchor!=null) {
      _parent=_sourceAnchor.getParent();
    }
    Object _businessObjectForPictogramElement = null;
    if (_parent!=null) {
      _businessObjectForPictogramElement=this.getBusinessObjectForPictogramElement(_parent);
    }
    if (!(_businessObjectForPictogramElement instanceof State)) {
      _and = false;
    } else {
      Anchor _targetAnchor = context.getTargetAnchor();
      AnchorContainer _parent_1 = null;
      if (_targetAnchor!=null) {
        _parent_1=_targetAnchor.getParent();
      }
      Object _businessObjectForPictogramElement_1 = null;
      if (_parent_1!=null) {
        _businessObjectForPictogramElement_1=this.getBusinessObjectForPictogramElement(_parent_1);
      }
      _and = (_businessObjectForPictogramElement_1 instanceof State);
    }
    return _and;
  }
  
  @Override
  public boolean canStartConnection(final ICreateConnectionContext context) {
    Anchor _sourceAnchor = context.getSourceAnchor();
    AnchorContainer _parent = null;
    if (_sourceAnchor!=null) {
      _parent=_sourceAnchor.getParent();
    }
    Object _businessObjectForPictogramElement = null;
    if (_parent!=null) {
      _businessObjectForPictogramElement=this.getBusinessObjectForPictogramElement(_parent);
    }
    return (_businessObjectForPictogramElement instanceof State);
  }
  
  @Override
  public Connection create(final ICreateConnectionContext context) {
    Anchor _sourceAnchor = context.getSourceAnchor();
    AnchorContainer _parent = _sourceAnchor.getParent();
    Object _businessObjectForPictogramElement = this.getBusinessObjectForPictogramElement(_parent);
    final State source = ((State) _businessObjectForPictogramElement);
    Anchor _targetAnchor = context.getTargetAnchor();
    AnchorContainer _parent_1 = _targetAnchor.getParent();
    Object _businessObjectForPictogramElement_1 = this.getBusinessObjectForPictogramElement(_parent_1);
    final State target = ((State) _businessObjectForPictogramElement_1);
    final Transition transition = StatemachineFactory.eINSTANCE.createTransition();
    transition.setSourceState(source);
    transition.setTargetState(target);
    EObject _eContainer = source.eContainer();
    final Statemachine statemachine = ((Statemachine) _eContainer);
    EList<Transition> _transitions = statemachine.getTransitions();
    _transitions.add(transition);
    Anchor _sourceAnchor_1 = context.getSourceAnchor();
    Anchor _targetAnchor_1 = context.getTargetAnchor();
    final AddConnectionContext addContext = new AddConnectionContext(_sourceAnchor_1, _targetAnchor_1);
    addContext.setNewObject(transition);
    IFeatureProvider _featureProvider = this.getFeatureProvider();
    PictogramElement _addIfPossible = _featureProvider.addIfPossible(addContext);
    return ((Connection) _addIfPossible);
  }
}
