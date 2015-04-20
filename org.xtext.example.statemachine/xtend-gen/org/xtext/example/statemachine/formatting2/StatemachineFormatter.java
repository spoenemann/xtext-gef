/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.xtext.example.statemachine.formatting2;

import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.xtext.example.statemachine.statemachine.Command;
import org.xtext.example.statemachine.statemachine.State;
import org.xtext.example.statemachine.statemachine.Statemachine;
import org.xtext.example.statemachine.statemachine.StatemachinePackage;
import org.xtext.example.statemachine.statemachine.Transition;

@SuppressWarnings("all")
public class StatemachineFormatter extends AbstractFormatter2 {
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
        it.setNewLines(1, 1, 2);
      }
    };
    document.<State>append(state, _function);
    ISemanticRegion _regionForKeyword = this.regionAccess.regionForKeyword(state, "state");
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    ISemanticRegion _append = document.append(_regionForKeyword, _function_1);
    ISemanticRegion _regionForKeyword_1 = this.regionAccess.regionForKeyword(state, "end");
    final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.newLine();
      }
    };
    ISemanticRegion _prepend = document.prepend(_regionForKeyword_1, _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.indent();
      }
    };
    document.<ISemanticRegion, ISemanticRegion>interior(_append, _prepend, _function_3);
    String _name = state.getName();
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_name);
    boolean _not = (!_isNullOrEmpty);
    if (_not) {
      ISemanticRegion _regionForFeature = this.regionAccess.regionForFeature(state, StatemachinePackage.Literals.STATE__NAME);
      final Procedure1<IHiddenRegionFormatter> _function_4 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.oneSpace();
        }
      };
      document.prepend(_regionForFeature, _function_4);
    }
    ISemanticRegion _regionForKeyword_2 = this.regionAccess.regionForKeyword(state, "actions");
    final Procedure1<IHiddenRegionFormatter> _function_5 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.newLine();
      }
    };
    ISemanticRegion _prepend_1 = document.prepend(_regionForKeyword_2, _function_5);
    final Procedure1<IHiddenRegionFormatter> _function_6 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    document.append(_prepend_1, _function_6);
    ISemanticRegion _regionForKeyword_3 = this.regionAccess.regionForKeyword(state, "{");
    final Procedure1<IHiddenRegionFormatter> _function_7 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.newLine();
      }
    };
    ISemanticRegion _append_1 = document.append(_regionForKeyword_3, _function_7);
    ISemanticRegion _regionForKeyword_4 = this.regionAccess.regionForKeyword(state, "}");
    final Procedure1<IHiddenRegionFormatter> _function_8 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.indent();
      }
    };
    document.<ISemanticRegion, ISemanticRegion>interior(_append_1, _regionForKeyword_4, _function_8);
    EList<Command> _actions = state.getActions();
    final Procedure1<Command> _function_9 = new Procedure1<Command>() {
      @Override
      public void apply(final Command it) {
        final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.newLine();
          }
        };
        document.<Command>append(it, _function);
      }
    };
    IterableExtensions.<Command>forEach(_actions, _function_9);
  }
  
  protected void _format(final Transition transition, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.setNewLines(1, 1, 2);
      }
    };
    document.<Transition>append(transition, _function);
    List<ISemanticRegion> _regionsForKeywords = this.regionAccess.regionsForKeywords(transition, "=>", "(", ")");
    final Procedure1<ISemanticRegion> _function_1 = new Procedure1<ISemanticRegion>() {
      @Override
      public void apply(final ISemanticRegion it) {
        final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.oneSpace();
          }
        };
        ISemanticRegion _prepend = document.prepend(it, _function);
        final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.oneSpace();
          }
        };
        document.append(_prepend, _function_1);
      }
    };
    IterableExtensions.<ISemanticRegion>forEach(_regionsForKeywords, _function_1);
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
