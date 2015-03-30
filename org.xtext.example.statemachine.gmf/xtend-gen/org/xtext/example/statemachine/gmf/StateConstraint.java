/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.xtext.example.statemachine.gmf;

import com.google.common.base.Objects;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.ConstraintSeverity;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.model.ModelConstraint;
import org.eclipse.emf.validation.service.AbstractConstraintDescriptor;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.xtext.example.statemachine.statemachine.State;

@SuppressWarnings("all")
public class StateConstraint extends ModelConstraint {
  private static class Descriptor extends AbstractConstraintDescriptor {
    @Override
    public String getBody() {
      return null;
    }
    
    @Override
    public String getDescription() {
      return "State validation";
    }
    
    @Override
    public EvaluationMode<?> getEvaluationMode() {
      return EvaluationMode.BATCH;
    }
    
    @Override
    public String getId() {
      return "org.xtext.example.statemachine.gmf.StateValidation";
    }
    
    @Override
    public String getMessagePattern() {
      return "The name of a state must not be empty.";
    }
    
    @Override
    public String getName() {
      return "StateValidation";
    }
    
    @Override
    public String getPluginId() {
      return "org.xtext.example.statemachine.gmf";
    }
    
    @Override
    public ConstraintSeverity getSeverity() {
      return ConstraintSeverity.ERROR;
    }
    
    @Override
    public int getStatusCode() {
      return 0;
    }
    
    @Override
    public boolean targetsEvent(final Notification notification) {
      return true;
    }
    
    @Override
    public boolean targetsTypeOf(final EObject eObject) {
      return (eObject instanceof State);
    }
  }
  
  public StateConstraint() {
    super(new StateConstraint.Descriptor());
  }
  
  @Override
  public boolean equals(final Object other) {
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(other, null));
    if (!_notEquals) {
      _and = false;
    } else {
      Class<?> _class = other.getClass();
      Class<? extends StateConstraint> _class_1 = this.getClass();
      boolean _equals = Objects.equal(_class, _class_1);
      _and = _equals;
    }
    return _and;
  }
  
  @Override
  public int hashCode() {
    Class<? extends StateConstraint> _class = this.getClass();
    return _class.hashCode();
  }
  
  @Override
  public IStatus validate(final IValidationContext ctx) {
    IStatus _xifexpression = null;
    EObject _target = ctx.getTarget();
    if ((_target instanceof State)) {
      IStatus _xblockexpression = null;
      {
        EObject _target_1 = ctx.getTarget();
        final State state = ((State) _target_1);
        IStatus _xifexpression_1 = null;
        String _name = state.getName();
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_name);
        if (_isNullOrEmpty) {
          _xifexpression_1 = ctx.createFailureStatus();
        }
        _xblockexpression = _xifexpression_1;
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
}
