/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.xtext.example.statemachine.formatting2;

import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.xtext.example.statemachine.services.StatemachineGrammarAccess;
import org.xtext.example.statemachine.statemachine.Command;
import org.xtext.example.statemachine.statemachine.Event;
import org.xtext.example.statemachine.statemachine.State;
import org.xtext.example.statemachine.statemachine.Statemachine;
import org.xtext.example.statemachine.statemachine.Transition;

@SuppressWarnings("all")
public class StatemachineFormatter extends AbstractFormatter2 {
  @Inject
  @Extension
  private StatemachineGrammarAccess _statemachineGrammarAccess;
  
  protected void _format(final Statemachine statemachine, @Extension final IFormattableDocument document) {
    EList<State> _states = statemachine.getStates();
    for (final State states : _states) {
      this.format(states, document);
    }
    EList<Transition> _transitions = statemachine.getTransitions();
    for (final Transition transitions : _transitions) {
      this.format(transitions, document);
    }
  }
  
  protected void _format(final State state, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.setNewLines(1);
      }
    };
    document.<State>append(state, _function);
    EList<Command> _actions = state.getActions();
    for (final Command actions : _actions) {
      this.format(actions, document);
    }
  }
  
  protected void _format(final Transition transition, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.setNewLines(1);
      }
    };
    document.<Transition>append(transition, _function);
    Event _event = transition.getEvent();
    this.format(_event, document);
  }
  
  public void format(final Object state, final IFormattableDocument document) {
    if (state instanceof XtextResource) {
      _format((XtextResource)state, document);
      return;
    } else if (state instanceof State) {
      _format((State)state, document);
      return;
    } else if (state instanceof Statemachine) {
      _format((Statemachine)state, document);
      return;
    } else if (state instanceof Transition) {
      _format((Transition)state, document);
      return;
    } else if (state == null) {
      _format((Void)null, document);
      return;
    } else if (state != null) {
      _format(state, document);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(state, document).toString());
    }
  }
}
