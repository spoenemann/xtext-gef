/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.xtext.example.statemachine.graphiti.features;

import org.eclipse.graphiti.features.IDirectEditingInfo;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Color;
import org.eclipse.graphiti.mm.algorithms.styles.Font;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.IColorConstant;
import org.eclipse.xtext.xbase.lib.Extension;
import org.xtext.example.statemachine.statemachine.State;

@SuppressWarnings("all")
public class AddStateFeature extends AbstractAddShapeFeature {
  @Extension
  private final IPeCreateService _iPeCreateService = Graphiti.getPeCreateService();
  
  @Extension
  private final IGaService _iGaService = Graphiti.getGaService();
  
  public AddStateFeature(final IFeatureProvider fp) {
    super(fp);
  }
  
  @Override
  public boolean canAdd(final IAddContext context) {
    boolean _and = false;
    Object _newObject = context.getNewObject();
    if (!(_newObject instanceof State)) {
      _and = false;
    } else {
      ContainerShape _targetContainer = context.getTargetContainer();
      _and = (_targetContainer instanceof Diagram);
    }
    return _and;
  }
  
  @Override
  public PictogramElement add(final IAddContext context) {
    Object _newObject = context.getNewObject();
    final State addedState = ((State) _newObject);
    ContainerShape _targetContainer = context.getTargetContainer();
    final Diagram targetDiagram = ((Diagram) _targetContainer);
    int _xifexpression = (int) 0;
    int _width = context.getWidth();
    boolean _lessEqualsThan = (_width <= 0);
    if (_lessEqualsThan) {
      _xifexpression = 50;
    } else {
      int _width_1 = context.getWidth();
      _xifexpression = Math.max(_width_1, 20);
    }
    final int width = _xifexpression;
    int _xifexpression_1 = (int) 0;
    int _height = context.getHeight();
    boolean _lessEqualsThan_1 = (_height <= 0);
    if (_lessEqualsThan_1) {
      _xifexpression_1 = 50;
    } else {
      int _height_1 = context.getHeight();
      _xifexpression_1 = Math.max(_height_1, 20);
    }
    final int height = _xifexpression_1;
    final ContainerShape containerShape = this._iPeCreateService.createContainerShape(targetDiagram, true);
    this._iPeCreateService.createChopboxAnchor(containerShape);
    final Rectangle rectangle = this._iGaService.createRectangle(containerShape);
    Color _manageColor = this.manageColor(IColorConstant.BLACK);
    rectangle.setForeground(_manageColor);
    Color _manageColor_1 = this.manageColor(IColorConstant.LIGHT_LIGHT_GRAY);
    rectangle.setBackground(_manageColor_1);
    int _x = context.getX();
    int _y = context.getY();
    this._iGaService.setLocationAndSize(rectangle, _x, _y, width, height);
    this.link(containerShape, addedState);
    final Shape textShape = this._iPeCreateService.createShape(containerShape, false);
    String _name = addedState.getName();
    final Text text = this._iGaService.createText(textShape, _name);
    Color _manageColor_2 = this.manageColor(IColorConstant.BLACK);
    text.setForeground(_manageColor_2);
    text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
    Diagram _diagram = this.getDiagram();
    Font _manageFont = this.manageFont(_diagram, "Arial", 12);
    text.setFont(_manageFont);
    this._iGaService.setLocationAndSize(text, 0, 0, width, 20);
    this.link(textShape, addedState);
    IFeatureProvider _featureProvider = this.getFeatureProvider();
    final IDirectEditingInfo directEditingInfo = _featureProvider.getDirectEditingInfo();
    directEditingInfo.setMainPictogramElement(containerShape);
    directEditingInfo.setPictogramElement(textShape);
    directEditingInfo.setGraphicsAlgorithm(text);
    return containerShape;
  }
}
