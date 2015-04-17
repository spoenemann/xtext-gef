/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.xtext.example.statemachine.gmf.ui;

import com.google.inject.Inject;
import com.google.inject.Injector;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.xtext.example.statemachine.gmf.ui.EditedResourceProvider;
import org.xtext.example.statemachine.gmf.ui.EmbeddedEditor;
import org.xtext.example.statemachine.gmf.ui.EmbeddedEditorFactory;
import org.xtext.example.statemachine.gmf.ui.EmbeddedEditorModelAccess;
import org.xtext.example.statemachine.statemachine.State;
import org.xtext.example.statemachine.ui.internal.StatemachineActivator;

@SuppressWarnings("all")
public class TextPropertiesViewPart extends ViewPart {
  @Inject
  private EditedResourceProvider resourceProvider;
  
  @Inject
  private EmbeddedEditorFactory editorFactory;
  
  private XtextSourceViewer viewer;
  
  private EmbeddedEditorModelAccess modelAccess;
  
  public TextPropertiesViewPart() {
    super();
    StatemachineActivator _instance = StatemachineActivator.getInstance();
    final Injector injector = _instance.getInjector("org.xtext.example.statemachine.Statemachine");
    injector.injectMembers(this);
    final Procedure1<State> _function = new Procedure1<State>() {
      @Override
      public void apply(final State it) {
        TextPropertiesViewPart.this.refresh(it);
      }
    };
    this.resourceProvider.addStateChangeListener(_function);
  }
  
  @Override
  public void createPartControl(final Composite parent) {
    EmbeddedEditorFactory.Builder _newEditor = this.editorFactory.newEditor(this.resourceProvider);
    EmbeddedEditorFactory.Builder _showErrorAndWarningAnnotations = _newEditor.showErrorAndWarningAnnotations();
    final EmbeddedEditor editor = _showErrorAndWarningAnnotations.withParent(parent);
    EmbeddedEditorModelAccess _createPartialEditor = editor.createPartialEditor();
    this.modelAccess = _createPartialEditor;
    XtextSourceViewer _viewer = editor.getViewer();
    this.viewer = _viewer;
    State _selectedState = this.resourceProvider.getSelectedState();
    this.refresh(_selectedState);
  }
  
  @Override
  public void dispose() {
    this.resourceProvider.dispose();
    super.dispose();
  }
  
  public void refresh(final State state) {
    if ((state == null)) {
      this.modelAccess.updateModel("");
    } else {
      final EObject stateCopy = this.resourceProvider.copy(state);
      EObject _eContainer = stateCopy.eContainer();
      this.modelAccess.updateModel(_eContainer, stateCopy);
      this.viewer.setSelectedRange(0, 0);
    }
  }
  
  @Override
  public void setFocus() {
    Control _control = this.viewer.getControl();
    _control.setFocus();
  }
}
