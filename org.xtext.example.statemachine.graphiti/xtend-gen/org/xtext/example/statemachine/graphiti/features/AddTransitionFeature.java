/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.xtext.example.statemachine.graphiti.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.styles.Color;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.IColorConstant;
import org.eclipse.xtext.xbase.lib.Extension;
import org.xtext.example.statemachine.statemachine.Transition;

@SuppressWarnings("all")
public class AddTransitionFeature extends AbstractAddFeature {
  @Extension
  private final IPeCreateService _iPeCreateService = Graphiti.getPeCreateService();
  
  @Extension
  private final IGaService _iGaService = Graphiti.getGaService();
  
  public AddTransitionFeature(final IFeatureProvider fp) {
    super(fp);
  }
  
  @Override
  public boolean canAdd(final IAddContext context) {
    boolean _and = false;
    if (!(context instanceof IAddConnectionContext)) {
      _and = false;
    } else {
      Object _newObject = context.getNewObject();
      _and = (_newObject instanceof Transition);
    }
    return _and;
  }
  
  @Override
  public PictogramElement add(final IAddContext context) {
    final IAddConnectionContext addConContext = ((IAddConnectionContext) context);
    Object _newObject = context.getNewObject();
    final Transition addedTransition = ((Transition) _newObject);
    Diagram _diagram = this.getDiagram();
    final FreeFormConnection connection = this._iPeCreateService.createFreeFormConnection(_diagram);
    Anchor _sourceAnchor = addConContext.getSourceAnchor();
    connection.setStart(_sourceAnchor);
    Anchor _targetAnchor = addConContext.getTargetAnchor();
    connection.setEnd(_targetAnchor);
    final Polyline polyline = this._iGaService.createPolyline(connection);
    Color _manageColor = this.manageColor(IColorConstant.DARK_GRAY);
    polyline.setForeground(_manageColor);
    this.link(connection, addedTransition);
    return connection;
  }
}
