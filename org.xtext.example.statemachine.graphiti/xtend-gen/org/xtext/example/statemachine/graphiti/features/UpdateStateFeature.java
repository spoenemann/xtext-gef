/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.xtext.example.statemachine.graphiti.features;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.xtext.example.statemachine.statemachine.State;

@SuppressWarnings("all")
public class UpdateStateFeature extends AbstractUpdateFeature {
  public UpdateStateFeature(final IFeatureProvider fp) {
    super(fp);
  }
  
  @Override
  public boolean canUpdate(final IUpdateContext context) {
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
  public IReason updateNeeded(final IUpdateContext context) {
    PictogramElement _pictogramElement = context.getPictogramElement();
    final ContainerShape containerShape = ((ContainerShape) _pictogramElement);
    EList<Shape> _children = containerShape.getChildren();
    final Function1<Shape, GraphicsAlgorithm> _function = new Function1<Shape, GraphicsAlgorithm>() {
      @Override
      public GraphicsAlgorithm apply(final Shape it) {
        return it.getGraphicsAlgorithm();
      }
    };
    List<GraphicsAlgorithm> _map = ListExtensions.<Shape, GraphicsAlgorithm>map(_children, _function);
    Iterable<Text> _filter = Iterables.<Text>filter(_map, Text.class);
    Text _head = IterableExtensions.<Text>head(_filter);
    String _value = null;
    if (_head!=null) {
      _value=_head.getValue();
    }
    String pictogramName = _value;
    String businessName = null;
    final Object bo = this.getBusinessObjectForPictogramElement(containerShape);
    if ((bo instanceof State)) {
      String _name = ((State)bo).getName();
      businessName = _name;
    }
    boolean _notEquals = (!Objects.equal(pictogramName, businessName));
    if (_notEquals) {
      return Reason.createTrueReason("Name is out of date");
    } else {
      return Reason.createFalseReason();
    }
  }
  
  @Override
  public boolean update(final IUpdateContext context) {
    PictogramElement _pictogramElement = context.getPictogramElement();
    final ContainerShape containerShape = ((ContainerShape) _pictogramElement);
    String businessName = null;
    final Object bo = this.getBusinessObjectForPictogramElement(containerShape);
    if ((bo instanceof State)) {
      String _name = ((State)bo).getName();
      businessName = _name;
    }
    EList<Shape> _children = containerShape.getChildren();
    final Function1<Shape, GraphicsAlgorithm> _function = new Function1<Shape, GraphicsAlgorithm>() {
      @Override
      public GraphicsAlgorithm apply(final Shape it) {
        return it.getGraphicsAlgorithm();
      }
    };
    List<GraphicsAlgorithm> _map = ListExtensions.<Shape, GraphicsAlgorithm>map(_children, _function);
    Iterable<Text> _filter = Iterables.<Text>filter(_map, Text.class);
    Text _head = IterableExtensions.<Text>head(_filter);
    if (_head!=null) {
      _head.setValue(businessName);
    }
    return false;
  }
}
