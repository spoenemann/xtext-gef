/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.xtext.example.statemachine.merging;

import com.google.common.base.Objects;
import com.google.common.collect.Iterators;
import java.util.Iterator;
import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.xtext.example.statemachine.merging.IModelMerger;
import org.xtext.example.statemachine.statemachine.Command;
import org.xtext.example.statemachine.statemachine.State;
import org.xtext.example.statemachine.statemachine.StatePropertyExpression;
import org.xtext.example.statemachine.statemachine.StatemachinePackage;

@SuppressWarnings("all")
public class ExplicitModelMerger implements IModelMerger {
  @Override
  public void merge(final EObject source, final EObject destination) {
    EClass _eClass = source.eClass();
    EClass _eClass_1 = destination.eClass();
    boolean _notEquals = (!Objects.equal(_eClass, _eClass_1));
    if (_notEquals) {
      throw new IllegalArgumentException();
    } else {
      if ((destination instanceof State)) {
        this.merge(((State) source), ((State) destination));
      } else {
        EClass _eClass_2 = destination.eClass();
        String _name = _eClass_2.getName();
        String _plus = ("Type " + _name);
        String _plus_1 = (_plus + " not supported");
        throw new UnsupportedOperationException(_plus_1);
      }
    }
  }
  
  protected void merge(final State source, final State destination) {
    String _name = source.getName();
    destination.setName(_name);
    boolean _isInitial = source.isInitial();
    destination.setInitial(_isInitial);
    boolean _isFinal = source.isFinal();
    destination.setFinal(_isFinal);
    EList<Command> _actions = destination.getActions();
    _actions.clear();
    EList<Command> _actions_1 = source.getActions();
    for (final Command sourceCommand : _actions_1) {
      {
        final EcoreUtil.Copier copier = new EcoreUtil.Copier();
        EObject _copy = copier.copy(sourceCommand);
        final Command newCommand = ((Command) _copy);
        EList<Command> _actions_2 = destination.getActions();
        _actions_2.add(newCommand);
        this.link(sourceCommand, copier);
      }
    }
  }
  
  protected void link(final EObject object, final Map<EObject, EObject> copyMap) {
    TreeIterator<EObject> _eAllContents = object.eAllContents();
    Iterator<StatePropertyExpression> _filter = Iterators.<StatePropertyExpression>filter(_eAllContents, StatePropertyExpression.class);
    final Function1<StatePropertyExpression, Boolean> _function = new Function1<StatePropertyExpression, Boolean>() {
      @Override
      public Boolean apply(final StatePropertyExpression it) {
        State _state = it.getState();
        return Boolean.valueOf((_state != null));
      }
    };
    Iterator<StatePropertyExpression> _filter_1 = IteratorExtensions.<StatePropertyExpression>filter(_filter, _function);
    final Procedure1<StatePropertyExpression> _function_1 = new Procedure1<StatePropertyExpression>() {
      @Override
      public void apply(final StatePropertyExpression expression) {
        Resource _eResource = object.eResource();
        State _state = expression.getState();
        final String uriFragment = _eResource.getURIFragment(_state);
        EObject _get = copyMap.get(expression);
        final StatePropertyExpression newExpression = ((StatePropertyExpression) _get);
        Resource _eResource_1 = newExpression.eResource();
        EObject _eObject = _eResource_1.getEObject(uriFragment);
        newExpression.setState(((State) _eObject));
      }
    };
    IteratorExtensions.<StatePropertyExpression>forEach(_filter_1, _function_1);
  }
  
  @Override
  public void apply(final Notification notification, final EObject destination) {
    if ((destination instanceof State)) {
      this.apply(notification, ((State) destination));
    } else {
      EClass _eClass = destination.eClass();
      String _name = _eClass.getName();
      String _plus = ("Type " + _name);
      String _plus_1 = (_plus + " not supported");
      throw new UnsupportedOperationException(_plus_1);
    }
  }
  
  protected void apply(final Notification notification, final State destination) {
    Object _feature = notification.getFeature();
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_feature, StatemachinePackage.Literals.STATE__ID)) {
        _matched=true;
        String _newStringValue = notification.getNewStringValue();
        destination.setId(_newStringValue);
      }
    }
    if (!_matched) {
      if (Objects.equal(_feature, StatemachinePackage.Literals.STATE__NAME)) {
        _matched=true;
        String _newStringValue_1 = notification.getNewStringValue();
        destination.setName(_newStringValue_1);
      }
    }
    if (!_matched) {
      Object _feature_1 = notification.getFeature();
      String _string = null;
      if (_feature_1!=null) {
        _string=_feature_1.toString();
      }
      String _plus = ("Feature " + _string);
      String _plus_1 = (_plus + " not supported");
      throw new UnsupportedOperationException(_plus_1);
    }
  }
}
