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
    Object _businessObjectForPictogramElement = this.getBusinessObjectForPictogramElement(_pictogramElement);
    return (_businessObjectForPictogramElement instanceof State);
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
    if ((_pictogramElement_1 instanceof Shape)) {
      PictogramElement _pictogramElement_2 = context.getPictogramElement();
      ContainerShape _container = ((Shape) _pictogramElement_2).getContainer();
      this.updatePictogramElement(_container);
    } else {
      PictogramElement _pictogramElement_3 = context.getPictogramElement();
      this.updatePictogramElement(_pictogramElement_3);
    }
  }
}
