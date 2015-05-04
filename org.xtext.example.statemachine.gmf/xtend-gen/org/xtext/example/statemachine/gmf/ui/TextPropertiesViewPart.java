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
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure3;
import org.xtext.example.statemachine.StatemachineUtil;
import org.xtext.example.statemachine.gmf.ui.EditedResourceProvider;
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
  
  private boolean refreshing;
  
  private boolean mergingBack;
  
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
    XtextDocument _document = editor.getDocument();
    final IXtextModelListener _function = new IXtextModelListener() {
      @Override
      public void modelChanged(final XtextResource it) {
        TextPropertiesViewPart.this.documentChanged(it);
      }
    };
    _document.addModelListener(_function);
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
  
  protected void refresh(final State state, final Notification notification) {
    if (this.mergingBack) {
      return;
    }
    this.refreshing = true;
    try {
      if (((state == this.currentViewedState) && (notification != null))) {
        final State mergeResult = this.resourceProvider.<State>mergeForward(state, notification);
        if ((mergeResult != null)) {
          Resource _eResource = mergeResult.eResource();
          final String uriFragment = _eResource.getURIFragment(mergeResult);
          EObject _eContainer = mergeResult.eContainer();
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
        final EObject stateCopy = this.createSerializableCopy(state);
        Resource _eResource_1 = stateCopy.eResource();
        final String uriFragment_1 = _eResource_1.getURIFragment(stateCopy);
        EObject _eContainer_1 = stateCopy.eContainer();
        String _serialize_1 = this.serializer.serialize(_eContainer_1);
        this.modelAccess.updateModel(_serialize_1, uriFragment_1);
        this.viewer.setSelectedRange(0, 0);
        String _editablePart_1 = this.modelAccess.getEditablePart();
        this.initialContent = _editablePart_1;
      }
      this.currentViewedState = state;
    } finally {
      this.refreshing = false;
    }
  }
  
  protected EObject createSerializableCopy(final EObject object) {
    EObject _eContainer = object.eContainer();
    boolean _tripleEquals = (_eContainer == null);
    if (_tripleEquals) {
      throw new IllegalStateException();
    }
    final EcoreUtil.Copier copier = new EcoreUtil.Copier();
    EObject _eContainer_1 = object.eContainer();
    final EObject modelCopy = copier.copy(_eContainer_1);
    copier.copyReferences();
    final XtextResource dummyResource = new XtextResource();
    EList<EObject> _contents = dummyResource.getContents();
    _contents.add(modelCopy);
    StatemachineUtil.ensureUniqueIds(dummyResource);
    return copier.get(object);
  }
  
  protected State documentChanged(final XtextResource resource) {
    State _xifexpression = null;
    if (((!this.refreshing) && (this.currentViewedState != null))) {
      State _xblockexpression = null;
      {
        this.mergingBack = true;
        State _xtrycatchfinallyexpression = null;
        try {
          _xtrycatchfinallyexpression = this.resourceProvider.<State>mergeBack(this.currentViewedState, this.editingDomain);
        } finally {
          this.mergingBack = false;
        }
        _xblockexpression = _xtrycatchfinallyexpression;
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  protected void handleDiscardedChanges() {
    final Status status = new Status(Status.WARNING, "org.xtext.example.statemachine.gmf", "The previous text changes have been discarded.");
    StatusManager _manager = StatusManager.getManager();
    _manager.handle(status);
  }
  
  @Override
  public void setFocus() {
    Control _control = this.viewer.getControl();
    _control.setFocus();
  }
}
