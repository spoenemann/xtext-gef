/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.xtext.example.statemachine.gmf.ui;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Injector;
import java.util.Collections;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure3;
import org.xtext.example.statemachine.gmf.ui.EditedResourceProvider;
import org.xtext.example.statemachine.gmf.ui.EmbeddedEditor;
import org.xtext.example.statemachine.gmf.ui.EmbeddedEditorFactory;
import org.xtext.example.statemachine.gmf.ui.EmbeddedEditorModelAccess;
import org.xtext.example.statemachine.statemachine.State;
import org.xtext.example.statemachine.ui.internal.StatemachineActivator;

@SuppressWarnings("all")
public class TextPropertiesViewPart extends ViewPart {
  private final EditedResourceProvider resourceProvider = new EditedResourceProvider(Collections.<Class<? extends EObject>>unmodifiableList(CollectionLiterals.<Class<? extends EObject>>newArrayList(State.class)));
  
  @Inject
  private EmbeddedEditorFactory editorFactory;
  
  @Inject
  private ISerializer serializer;
  
  private XtextSourceViewer viewer;
  
  private EmbeddedEditorModelAccess modelAccess;
  
  private State currentViewedState;
  
  private TransactionalEditingDomain editingDomain;
  
  private String initialContent;
  
  public TextPropertiesViewPart() {
    super();
    StatemachineActivator _instance = StatemachineActivator.getInstance();
    final Injector injector = _instance.getInjector("org.xtext.example.statemachine.Statemachine");
    injector.injectMembers(this);
    final Procedure3<EObject, Notification, TransactionalEditingDomain> _function = new Procedure3<EObject, Notification, TransactionalEditingDomain>() {
      @Override
      public void apply(final EObject object, final Notification notification, final TransactionalEditingDomain editingDomain) {
        TextPropertiesViewPart.this.refresh(((State) object), notification);
        TextPropertiesViewPart.this.editingDomain = editingDomain;
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
    EObject _selectedObject = this.resourceProvider.getSelectedObject();
    this.refresh(((State) _selectedObject), null);
    TransactionalEditingDomain _editingDomain = this.resourceProvider.getEditingDomain();
    this.editingDomain = _editingDomain;
  }
  
  @Override
  public void dispose() {
    this.resourceProvider.dispose();
    super.dispose();
  }
  
  public void refresh(final State state, final Notification notification) {
    if (((state == this.currentViewedState) && (notification != null))) {
      final State mergeResult = this.resourceProvider.<State>mergeForward(state, notification);
      if ((mergeResult != null)) {
        final EObject stateCopy = this.resourceProvider.createSerializableCopy(mergeResult);
        Resource _eResource = stateCopy.eResource();
        final String uriFragment = _eResource.getURIFragment(stateCopy);
        EObject _eContainer = stateCopy.eContainer();
        String _serialize = this.serializer.serialize(_eContainer);
        this.modelAccess.updateModel(_serialize, uriFragment);
        String _editablePart = this.modelAccess.getEditablePart();
        this.initialContent = _editablePart;
        return;
      }
    }
    if ((this.currentViewedState != null)) {
      final String content = this.modelAccess.getEditablePart();
      boolean _notEquals = (!Objects.equal(content, this.initialContent));
      if (_notEquals) {
        if ((state == this.currentViewedState)) {
          this.handleDiscardedChanges();
        } else {
          final State mergeSource = this.resourceProvider.<State>mergeBack(this.currentViewedState, this.editingDomain);
          if ((mergeSource == null)) {
            this.handleDiscardedChanges();
          }
        }
      }
    }
    if ((state == null)) {
      this.modelAccess.updateModel("");
    } else {
      final EObject stateCopy_1 = this.resourceProvider.createSerializableCopy(state);
      Resource _eResource_1 = stateCopy_1.eResource();
      final String uriFragment_1 = _eResource_1.getURIFragment(stateCopy_1);
      EObject _eContainer_1 = stateCopy_1.eContainer();
      String _serialize_1 = this.serializer.serialize(_eContainer_1);
      this.modelAccess.updateModel(_serialize_1, uriFragment_1);
      this.viewer.setSelectedRange(0, 0);
      String _editablePart_1 = this.modelAccess.getEditablePart();
      this.initialContent = _editablePart_1;
    }
    this.currentViewedState = state;
  }
  
  public String handleDiscardedChanges() {
    return InputOutput.<String>println("Warning: The previous text changes have been discarded.");
  }
  
  @Override
  public void setFocus() {
    Control _control = this.viewer.getControl();
    _control.setFocus();
  }
}
