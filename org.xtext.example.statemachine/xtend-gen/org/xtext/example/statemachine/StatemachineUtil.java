/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.xtext.example.statemachine;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.xtext.example.statemachine.statemachine.State;
import org.xtext.example.statemachine.statemachine.Statemachine;
import org.xtext.example.statemachine.statemachine.Transition;

@SuppressWarnings("all")
public final class StatemachineUtil {
  private static class Context {
    private int lastNr;
  }
  
  public static void ensureUniqueIds(final Resource resource) {
    final HashSet<String> assignedIds = new HashSet<String>();
    EList<EObject> _contents = resource.getContents();
    Iterable<Statemachine> _filter = Iterables.<Statemachine>filter(_contents, Statemachine.class);
    final Procedure1<Statemachine> _function = new Procedure1<Statemachine>() {
      @Override
      public void apply(final Statemachine it) {
        EList<Transition> _transitions = it.getTransitions();
        final Procedure1<Transition> _function = new Procedure1<Transition>() {
          @Override
          public void apply(final Transition it) {
            State _sourceState = it.getSourceState();
            Resource _eResource = _sourceState.eResource();
            boolean _notEquals = (!Objects.equal(_eResource, resource));
            if (_notEquals) {
              State _sourceState_1 = it.getSourceState();
              String _id = _sourceState_1.getId();
              assignedIds.add(_id);
            }
            State _targetState = it.getTargetState();
            Resource _eResource_1 = _targetState.eResource();
            boolean _notEquals_1 = (!Objects.equal(_eResource_1, resource));
            if (_notEquals_1) {
              State _targetState_1 = it.getTargetState();
              String _id_1 = _targetState_1.getId();
              assignedIds.add(_id_1);
            }
          }
        };
        IterableExtensions.<Transition>forEach(_transitions, _function);
      }
    };
    IterableExtensions.<Statemachine>forEach(_filter, _function);
    final StatemachineUtil.Context context = new StatemachineUtil.Context();
    EList<EObject> _contents_1 = resource.getContents();
    Iterable<Statemachine> _filter_1 = Iterables.<Statemachine>filter(_contents_1, Statemachine.class);
    final Procedure1<Statemachine> _function_1 = new Procedure1<Statemachine>() {
      @Override
      public void apply(final Statemachine it) {
        StatemachineUtil.ensureUniqueIds(it, context, assignedIds);
      }
    };
    IterableExtensions.<Statemachine>forEach(_filter_1, _function_1);
  }
  
  private static void ensureUniqueIds(final Statemachine model, final StatemachineUtil.Context context, final Set<String> assignedIds) {
    EList<State> _states = model.getStates();
    for (final State state : _states) {
      {
        boolean _or = false;
        String _id = state.getId();
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_id);
        if (_isNullOrEmpty) {
          _or = true;
        } else {
          String _id_1 = state.getId();
          boolean _startsWith = _id_1.startsWith("_state");
          _or = _startsWith;
        }
        if (_or) {
          do {
            context.lastNr++;
          } while(assignedIds.contains(("_state" + Integer.valueOf(context.lastNr))));
          state.setId(("_state" + Integer.valueOf(context.lastNr)));
        } else {
          String _id_2 = state.getId();
          boolean _contains = assignedIds.contains(_id_2);
          if (_contains) {
            do {
              context.lastNr++;
            } while(assignedIds.contains(((state.getId() + "_") + Integer.valueOf(context.lastNr))));
            String _id_3 = state.getId();
            String _plus = (_id_3 + "_");
            String _plus_1 = (_plus + Integer.valueOf(context.lastNr));
            state.setId(_plus_1);
          }
        }
        String _id_4 = state.getId();
        assignedIds.add(_id_4);
      }
    }
  }
}
