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
import org.xtext.example.statemachine.statemachine.ExecuteCommand;
import org.xtext.example.statemachine.statemachine.Expression;
import org.xtext.example.statemachine.statemachine.PrintCommand;
import org.xtext.example.statemachine.statemachine.SetCommand;
import org.xtext.example.statemachine.statemachine.State;
import org.xtext.example.statemachine.statemachine.StatePropertyExpression;
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
    boolean _isInitial = state.isInitial();
    if (_isInitial) {
      ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(state);
      ISemanticRegion _keyword = _regionFor.keyword("initial");
      final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.oneSpace();
        }
      };
      document.append(_keyword, _function);
    }
    boolean _isFinal = state.isFinal();
    if (_isFinal) {
      ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(state);
      ISemanticRegion _keyword_1 = _regionFor_1.keyword("final");
      final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.oneSpace();
        }
      };
      document.append(_keyword_1, _function_1);
    }
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(state);
    ISemanticRegion _keyword_2 = _regionFor_2.keyword("state");
    final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    ISemanticRegion _append = document.append(_keyword_2, _function_2);
    ISemanticRegionsFinder _regionFor_3 = this.textRegionExtensions.regionFor(state);
    ISemanticRegion _keyword_3 = _regionFor_3.keyword("end");
    final Procedure1<IHiddenRegionFormatter> _function_3 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.indent();
      }
    };
    document.<ISemanticRegion, ISemanticRegion>interior(_append, _keyword_3, _function_3);
    String _name = state.getName();
    boolean _tripleNotEquals = (_name != null);
    if (_tripleNotEquals) {
      ISemanticRegionsFinder _regionFor_4 = this.textRegionExtensions.regionFor(state);
      ISemanticRegion _feature = _regionFor_4.feature(StatemachinePackage.Literals.STATE__NAME);
      final Procedure1<IHiddenRegionFormatter> _function_4 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.oneSpace();
        }
      };
      document.prepend(_feature, _function_4);
    }
    ISemanticRegionsFinder _regionFor_5 = this.textRegionExtensions.regionFor(state);
    ISemanticRegion _keyword_4 = _regionFor_5.keyword("actions");
    final Procedure1<IHiddenRegionFormatter> _function_5 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.newLine();
      }
    };
    ISemanticRegion _prepend = document.prepend(_keyword_4, _function_5);
    final Procedure1<IHiddenRegionFormatter> _function_6 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    document.append(_prepend, _function_6);
    ISemanticRegionsFinder _regionFor_6 = this.textRegionExtensions.regionFor(state);
    ISemanticRegion _keyword_5 = _regionFor_6.keyword("{");
    final Procedure1<IHiddenRegionFormatter> _function_7 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.newLine();
      }
    };
    ISemanticRegion _append_1 = document.append(_keyword_5, _function_7);
    ISemanticRegionsFinder _regionFor_7 = this.textRegionExtensions.regionFor(state);
    ISemanticRegion _keyword_6 = _regionFor_7.keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_8 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.newLine();
      }
    };
    ISemanticRegion _append_2 = document.append(_keyword_6, _function_8);
    final Procedure1<IHiddenRegionFormatter> _function_9 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.indent();
      }
    };
    document.<ISemanticRegion, ISemanticRegion>interior(_append_1, _append_2, _function_9);
    final Procedure1<IHiddenRegionFormatter> _function_10 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.setNewLines(1, 1, 2);
      }
    };
    document.<State>append(state, _function_10);
    EList<Command> _actions = state.getActions();
    for (final Command command : _actions) {
      document.<Command>format(command);
    }
  }
  
  protected void _format(final Transition transition, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(transition);
    List<ISemanticRegion> _keywords = _regionFor.keywords("=>", "(", ")");
    final Procedure1<ISemanticRegion> _function = new Procedure1<ISemanticRegion>() {
      @Override
      public void apply(final ISemanticRegion it) {
        final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.oneSpace();
          }
        };
        document.surround(it, _function);
      }
    };
    IterableExtensions.<ISemanticRegion>forEach(_keywords, _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.setNewLines(1, 1, 2);
      }
    };
    document.<Transition>append(transition, _function_1);
    Expression _event = transition.getEvent();
    document.<Expression>format(_event);
  }
  
  protected void _format(final SetCommand command, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(command);
    ISemanticRegion _keyword = _regionFor.keyword("set");
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    document.append(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(command);
    ISemanticRegion _feature = _regionFor_1.feature(StatemachinePackage.Literals.SET_COMMAND__SIGNAL);
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    document.append(_feature, _function_1);
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(command);
    ISemanticRegion _keyword_1 = _regionFor_2.keyword("=");
    final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    document.append(_keyword_1, _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.newLine();
      }
    };
    document.<SetCommand>append(command, _function_3);
    Expression _value = command.getValue();
    document.<Expression>format(_value);
  }
  
  protected void _format(final ExecuteCommand command, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(command);
    ISemanticRegion _keyword = _regionFor.keyword("execute");
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    document.append(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(command);
    ISemanticRegion _keyword_1 = _regionFor_1.keyword("(");
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    document.surround(_keyword_1, _function_1);
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(command);
    List<ISemanticRegion> _keywords = _regionFor_2.keywords(",");
    final Procedure1<ISemanticRegion> _function_2 = new Procedure1<ISemanticRegion>() {
      @Override
      public void apply(final ISemanticRegion it) {
        final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.noSpace();
          }
        };
        document.prepend(it, _function);
        final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.oneSpace();
          }
        };
        document.append(it, _function_1);
      }
    };
    IterableExtensions.<ISemanticRegion>forEach(_keywords, _function_2);
    ISemanticRegionsFinder _regionFor_3 = this.textRegionExtensions.regionFor(command);
    ISemanticRegion _keyword_2 = _regionFor_3.keyword(")");
    final Procedure1<IHiddenRegionFormatter> _function_3 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    document.prepend(_keyword_2, _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.newLine();
      }
    };
    document.<ExecuteCommand>append(command, _function_4);
    EList<Expression> _arguments = command.getArguments();
    for (final Expression expression : _arguments) {
      document.<Expression>format(expression);
    }
  }
  
  protected void _format(final PrintCommand command, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(command);
    ISemanticRegion _keyword = _regionFor.keyword("print");
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    document.append(_keyword, _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.newLine();
      }
    };
    document.<PrintCommand>append(command, _function_1);
    Expression _value = command.getValue();
    document.<Expression>format(_value);
  }
  
  protected void _format(final StatePropertyExpression expression, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(expression);
    ISemanticRegion _keyword = _regionFor.keyword(".");
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    document.surround(_keyword, _function);
  }
  
  public void format(final Object command, final IFormattableDocument document) {
    if (command instanceof XtextResource) {
      _format((XtextResource)command, document);
      return;
    } else if (command instanceof ExecuteCommand) {
      _format((ExecuteCommand)command, document);
      return;
    } else if (command instanceof PrintCommand) {
      _format((PrintCommand)command, document);
      return;
    } else if (command instanceof SetCommand) {
      _format((SetCommand)command, document);
      return;
    } else if (command instanceof StatePropertyExpression) {
      _format((StatePropertyExpression)command, document);
      return;
    } else if (command instanceof State) {
      _format((State)command, document);
      return;
    } else if (command instanceof Statemachine) {
      _format((Statemachine)command, document);
      return;
    } else if (command instanceof Transition) {
      _format((Transition)command, document);
      return;
    } else if (command == null) {
      _format((Void)null, document);
      return;
    } else if (command != null) {
      _format(command, document);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(command, document).toString());
    }
  }
}
