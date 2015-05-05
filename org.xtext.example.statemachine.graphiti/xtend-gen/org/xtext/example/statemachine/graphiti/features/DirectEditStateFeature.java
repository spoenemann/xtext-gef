/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.xtext.example.statemachine.graphiti.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.impl.AbstractDirectEditingFeature;
import org.eclipse.graphiti.func.IDirectEditing;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.xtext.example.statemachine.statemachine.State;

@SuppressWarnings("all")
public class DirectEditStateFeature extends AbstractDirectEditingFeature {
  public DirectEditStateFeature(final IFeatureProvider fp) {
    super(fp);
  }
  
  @Override
  public int getEditingType() {
    return IDirectEditing.TYPE_TEXT;
  }
  
  @Override
  public boolean canDirectEdit(final IDirectEditingContext context) {
    PictogramElement _pictogramElement = context.getPictogramElement();
    final Object bo = this.getBusinessObjectForPictogramElement(_pictogramElement);
    boolean _and = false;
    if (!(bo instanceof State)) {
      _and = false;
    } else {
      GraphicsAlgorithm _graphicsAlgorithm = context.getGraphicsAlgorithm();
      _and = (_graphicsAlgorithm instanceof Text);
    }
    return _and;
  }
  
  @Override
  public String getInitialValue(final IDirectEditingContext context) {
    PictogramElement _pictogramElement = context.getPictogramElement();
    Object _businessObjectForPictogramElement = this.getBusinessObjectForPictogramElement(_pictogramElement);
    final State state = ((State) _businessObjectForPictogramElement);
    return state.getName();
  }
  
  @Override
  public void setValue(final String value, final IDirectEditingContext context) {
    PictogramElement _pictogramElement = context.getPictogramElement();
    Object _businessObjectForPictogramElement = this.getBusinessObjectForPictogramElement(_pictogramElement);
    final State state = ((State) _businessObjectForPictogramElement);
    state.setName(value);
    PictogramElement _pictogramElement_1 = context.getPictogramElement();
    ContainerShape _container = ((Shape) _pictogramElement_1).getContainer();
    this.updatePictogramElement(_container);
  }
}
