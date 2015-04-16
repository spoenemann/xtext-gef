/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.xtext.example.statemachine.gmf.ui;

import com.google.common.base.Objects;
import com.google.inject.Injector;
import com.google.inject.Provider;
import java.util.List;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.xtext.example.statemachine.gmf.ui.EditedResourceProvider;
import org.xtext.example.statemachine.statemachine.State;
import org.xtext.example.statemachine.ui.internal.StatemachineActivator;

@SuppressWarnings("all")
public class TextPropertiesViewPart extends ViewPart {
  private final EditedResourceProvider resourceProvider = new EditedResourceProvider(new Procedure1<State>() {
    @Override
    public void apply(final State it) {
      TextPropertiesViewPart.this.refresh(it);
    }
  });
  
  private final Provider<EmbeddedEditorFactory.Builder> builderProvider = new Provider<EmbeddedEditorFactory.Builder>() {
    @Override
    public EmbeddedEditorFactory.Builder get() {
      EmbeddedEditorFactory.Builder _xblockexpression = null;
      {
        StatemachineActivator _instance = StatemachineActivator.getInstance();
        final Injector injector = _instance.getInjector("org.xtext.example.statemachine.Statemachine");
        _xblockexpression = injector.<EmbeddedEditorFactory.Builder>getInstance(EmbeddedEditorFactory.Builder.class);
      }
      return _xblockexpression;
    }
  };
  
  private Composite parent;
  
  private XtextSourceViewer viewer;
  
  @Override
  public void createPartControl(final Composite parent) {
    final Composite container = new Composite(parent, SWT.NONE);
    StackLayout _stackLayout = new StackLayout();
    container.setLayout(_stackLayout);
    this.parent = container;
    State _selectedState = this.resourceProvider.getSelectedState();
    this.refresh(_selectedState);
  }
  
  @Override
  public void dispose() {
    this.resourceProvider.dispose();
    super.dispose();
  }
  
  public void refresh(final State state) {
    boolean _notEquals = (!Objects.equal(this.viewer, null));
    if (_notEquals) {
      Control _control = this.viewer.getControl();
      _control.dispose();
      this.viewer = null;
    }
    if ((state != null)) {
      final List<String> textParts = this.resourceProvider.createTextParts();
      final EmbeddedEditorFactory editorFactory = new EmbeddedEditorFactory();
      editorFactory.setBuilderProvider(this.builderProvider);
      EmbeddedEditorFactory.Builder _newEditor = editorFactory.newEditor(this.resourceProvider);
      EmbeddedEditorFactory.Builder _showErrorAndWarningAnnotations = _newEditor.showErrorAndWarningAnnotations();
      final EmbeddedEditor editor = _showErrorAndWarningAnnotations.withParent(this.parent);
      String _get = textParts.get(0);
      String _get_1 = textParts.get(1);
      String _get_2 = textParts.get(2);
      editor.createPartialEditor(_get, _get_1, _get_2, true);
      XtextSourceViewer _viewer = editor.getViewer();
      this.viewer = _viewer;
      Layout _layout = this.parent.getLayout();
      XtextSourceViewer _viewer_1 = editor.getViewer();
      Control _control_1 = _viewer_1.getControl();
      ((StackLayout) _layout).topControl = _control_1;
      this.parent.layout();
    }
  }
  
  @Override
  public void setFocus() {
    boolean _notEquals = (!Objects.equal(this.viewer, null));
    if (_notEquals) {
      Control _control = this.viewer.getControl();
      _control.setFocus();
    }
  }
}
