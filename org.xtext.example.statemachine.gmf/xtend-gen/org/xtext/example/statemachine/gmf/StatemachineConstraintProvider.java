/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.xtext.example.statemachine.gmf;

import com.google.common.base.Objects;
import java.util.Collection;
import java.util.HashSet;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.model.IModelConstraint;
import org.eclipse.emf.validation.service.IModelConstraintProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.xtext.example.statemachine.gmf.StateConstraint;
import org.xtext.example.statemachine.statemachine.State;
import org.xtext.example.statemachine.statemachine.StatemachinePackage;

@SuppressWarnings("all")
public class StatemachineConstraintProvider implements IModelConstraintProvider {
  @Override
  public Collection<IModelConstraint> getBatchConstraints(final EObject eObject, final Collection<IModelConstraint> constraints) {
    Collection<IModelConstraint> result = constraints;
    if ((eObject instanceof State)) {
      if ((result == null)) {
        HashSet<IModelConstraint> _newHashSet = CollectionLiterals.<IModelConstraint>newHashSet();
        result = _newHashSet;
      }
      StateConstraint _constraint = this.getConstraint(((State) eObject));
      result.add(_constraint);
    }
    return result;
  }
  
  @Override
  public Collection<IModelConstraint> getLiveConstraints(final Notification notification, final Collection<IModelConstraint> constraints) {
    Collection<IModelConstraint> result = constraints;
    Object _feature = notification.getFeature();
    boolean _equals = Objects.equal(_feature, StatemachinePackage.Literals.STATE__NAME);
    if (_equals) {
      if ((result == null)) {
        HashSet<IModelConstraint> _newHashSet = CollectionLiterals.<IModelConstraint>newHashSet();
        result = _newHashSet;
      }
      Object _notifier = notification.getNotifier();
      StateConstraint _constraint = this.getConstraint(((State) _notifier));
      result.add(_constraint);
    }
    return result;
  }
  
  private StateConstraint getConstraint(final State state) {
    return new StateConstraint();
  }
}
