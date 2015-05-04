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
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegionsFinder;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.xtext.example.statemachine.statemachine.Command;
import org.xtext.example.statemachine.statemachine.State;
import org.xtext.example.statemachine.statemachine.Statemachine;
import org.xtext.example.statemachine.statemachine.StatemachinePackage;
import org.xtext.example.statemachine.statemachine.Transition;

@SuppressWarnings("all")
public class StatemachineFormatter extends AbstractFormatter2 {
  protected void _format(final Statemachine statemachine, @Extension final IFormattableDocument document) {
    EList<State> _states = statemachine.getStates();
    for (final State state : _states) {
      document.<State>format(state);
    }
    EList<Transition> _transitions = statemachine.getTransitions();
    for (final Transition transition : _transitions) {
      document.<Transition>format(transition);
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
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(state);
    ISemanticRegion _keyword = _regionFor.keyword("state");
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    ISemanticRegion _append = document.append(_keyword, _function_1);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(state);
    ISemanticRegion _keyword_1 = _regionFor_1.keyword("end");
    final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.indent();
      }
    };
    document.<ISemanticRegion, ISemanticRegion>interior(_append, _keyword_1, _function_2);
    String _name = state.getName();
    boolean _tripleEquals = (_name == null);
    if (_tripleEquals) {
      ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(state);
      ISemanticRegion _feature = _regionFor_2.feature(StatemachinePackage.Literals.STATE__ID);
      final Procedure1<IHiddenRegionFormatter> _function_3 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.newLine();
        }
      };
      document.append(_feature, _function_3);
    } else {
      ISemanticRegionsFinder _regionFor_3 = this.textRegionExtensions.regionFor(state);
      ISemanticRegion _feature_1 = _regionFor_3.feature(StatemachinePackage.Literals.STATE__ID);
      final Procedure1<IHiddenRegionFormatter> _function_4 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.oneSpace();
        }
      };
      document.append(_feature_1, _function_4);
      ISemanticRegionsFinder _regionFor_4 = this.textRegionExtensions.regionFor(state);
      ISemanticRegion _feature_2 = _regionFor_4.feature(StatemachinePackage.Literals.STATE__NAME);
      final Procedure1<IHiddenRegionFormatter> _function_5 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.newLine();
        }
      };
      document.append(_feature_2, _function_5);
    }
    ISemanticRegionsFinder _regionFor_5 = this.textRegionExtensions.regionFor(state);
    ISemanticRegion _keyword_2 = _regionFor_5.keyword("actions");
    final Procedure1<IHiddenRegionFormatter> _function_6 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    document.append(_keyword_2, _function_6);
    ISemanticRegionsFinder _regionFor_6 = this.textRegionExtensions.regionFor(state);
    ISemanticRegion _keyword_3 = _regionFor_6.keyword("{");
    final Procedure1<IHiddenRegionFormatter> _function_7 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.newLine();
      }
    };
    ISemanticRegion _append_1 = document.append(_keyword_3, _function_7);
    ISemanticRegionsFinder _regionFor_7 = this.textRegionExtensions.regionFor(state);
    ISemanticRegion _keyword_4 = _regionFor_7.keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_8 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.newLine();
      }
    };
    ISemanticRegion _append_2 = document.append(_keyword_4, _function_8);
    final Procedure1<IHiddenRegionFormatter> _function_9 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.indent();
      }
    };
    document.<ISemanticRegion, ISemanticRegion>interior(_append_1, _append_2, _function_9);
    EList<Command> _actions = state.getActions();
    final Procedure1<Command> _function_10 = new Procedure1<Command>() {
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
    IterableExtensions.<Command>forEach(_actions, _function_10);
  }
  
  protected void _format(final Transition transition, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.setNewLines(1, 1, 2);
      }
    };
    document.<Transition>append(transition, _function);
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(transition);
    List<ISemanticRegion> _keywords = _regionFor.keywords("=>", "(", ")");
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
    IterableExtensions.<ISemanticRegion>forEach(_keywords, _function_1);
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
