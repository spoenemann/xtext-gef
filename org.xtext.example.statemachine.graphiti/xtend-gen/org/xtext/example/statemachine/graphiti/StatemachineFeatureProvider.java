/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.xtext.example.statemachine.graphiti;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;
import org.xtext.example.statemachine.graphiti.features.AddStateFeature;
import org.xtext.example.statemachine.graphiti.features.AddTransitionFeature;
import org.xtext.example.statemachine.graphiti.features.CreateStateFeature;
import org.xtext.example.statemachine.graphiti.features.CreateTransitionFeature;
import org.xtext.example.statemachine.graphiti.features.DirectEditStateFeature;
import org.xtext.example.statemachine.graphiti.features.UpdateStateFeature;
import org.xtext.example.statemachine.statemachine.State;
import org.xtext.example.statemachine.statemachine.Transition;

@SuppressWarnings("all")
public class StatemachineFeatureProvider extends DefaultFeatureProvider {
  public StatemachineFeatureProvider(final IDiagramTypeProvider dtp) {
    super(dtp);
  }
  
  @Override
  public ICreateFeature[] getCreateFeatures() {
    CreateStateFeature _createStateFeature = new CreateStateFeature(this);
    return new ICreateFeature[] { _createStateFeature };
  }
  
  @Override
  public ICreateConnectionFeature[] getCreateConnectionFeatures() {
    CreateTransitionFeature _createTransitionFeature = new CreateTransitionFeature(this);
    return new ICreateConnectionFeature[] { _createTransitionFeature };
  }
  
  @Override
  public IAddFeature getAddFeature(final IAddContext context) {
    IAddFeature _switchResult = null;
    Object _newObject = context.getNewObject();
    boolean _matched = false;
    if (!_matched) {
      if (_newObject instanceof State) {
        _matched=true;
        _switchResult = new AddStateFeature(this);
      }
    }
    if (!_matched) {
      if (_newObject instanceof Transition) {
        _matched=true;
        _switchResult = new AddTransitionFeature(this);
      }
    }
    if (!_matched) {
      _switchResult = super.getAddFeature(context);
    }
    return _switchResult;
  }
  
  @Override
  public IUpdateFeature getUpdateFeature(final IUpdateContext context) {
    IUpdateFeature _xblockexpression = null;
    {
      final PictogramElement pictogramElement = context.getPictogramElement();
      if ((pictogramElement instanceof ContainerShape)) {
        final Object bo = this.getBusinessObjectForPictogramElement(pictogramElement);
        if ((bo instanceof State)) {
          return new UpdateStateFeature(this);
        }
      }
      _xblockexpression = super.getUpdateFeature(context);
    }
    return _xblockexpression;
  }
  
  @Override
  public IDirectEditingFeature getDirectEditingFeature(final IDirectEditingContext context) {
    IDirectEditingFeature _xblockexpression = null;
    {
      PictogramElement _pictogramElement = context.getPictogramElement();
      final Object bo = this.getBusinessObjectForPictogramElement(_pictogramElement);
      if ((bo instanceof State)) {
        return new DirectEditStateFeature(this);
      }
      _xblockexpression = super.getDirectEditingFeature(context);
    }
    return _xblockexpression;
  }
}
