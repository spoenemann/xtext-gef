/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.xtext.example.statemachine.graphiti.features;

import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.impl.AbstractLayoutFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.xtext.example.statemachine.statemachine.State;

@SuppressWarnings("all")
public class LayoutStateFeature extends AbstractLayoutFeature {
  @Extension
  private final IGaService _iGaService = Graphiti.getGaService();
  
  public LayoutStateFeature(final IFeatureProvider fp) {
    super(fp);
  }
  
  @Override
  public boolean canLayout(final ILayoutContext context) {
    boolean _and = false;
    PictogramElement _pictogramElement = context.getPictogramElement();
    if (!(_pictogramElement instanceof ContainerShape)) {
      _and = false;
    } else {
      PictogramElement _pictogramElement_1 = context.getPictogramElement();
      Object _businessObjectForPictogramElement = this.getBusinessObjectForPictogramElement(_pictogramElement_1);
      _and = (_businessObjectForPictogramElement instanceof State);
    }
    return _and;
  }
  
  @Override
  public boolean layout(final ILayoutContext context) {
    PictogramElement _pictogramElement = context.getPictogramElement();
    final ContainerShape containerShape = ((ContainerShape) _pictogramElement);
    final GraphicsAlgorithm primaryGa = containerShape.getGraphicsAlgorithm();
    EList<Shape> _children = containerShape.getChildren();
    final Function1<Shape, GraphicsAlgorithm> _function = new Function1<Shape, GraphicsAlgorithm>() {
      @Override
      public GraphicsAlgorithm apply(final Shape it) {
        return it.getGraphicsAlgorithm();
      }
    };
    List<GraphicsAlgorithm> _map = ListExtensions.<Shape, GraphicsAlgorithm>map(_children, _function);
    final Function1<GraphicsAlgorithm, Boolean> _function_1 = new Function1<GraphicsAlgorithm, Boolean>() {
      @Override
      public Boolean apply(final GraphicsAlgorithm it) {
        return Boolean.valueOf((it instanceof Text));
      }
    };
    final GraphicsAlgorithm text = IterableExtensions.<GraphicsAlgorithm>findFirst(_map, _function_1);
    int _width = primaryGa.getWidth();
    this._iGaService.setLocationAndSize(text, 0, 0, _width, 20);
    return true;
  }
}
