/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.xtext.example.statemachine.ui.views;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Injector;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure3;
import org.xtext.example.statemachine.ui.internal.StatemachineActivator;
import org.xtext.example.statemachine.ui.views.EditedResourceProvider;

@SuppressWarnings("all")
public class TextPropertiesViewPart extends ViewPart {
  @Inject
  private EditedResourceProvider resourceProvider;
  
  @Inject
  private EmbeddedEditorFactory editorFactory;
  
  @Inject
  private ISerializer serializer;
  
  private XtextSourceViewer viewer;
  
  private EmbeddedEditorModelAccess modelAccess;
  
  private EObject currentViewedObject;
  
  private TransactionalEditingDomain editingDomain;
  
  private String lastMergedContent;
  
  private boolean refreshing;
  
  private boolean mergingBack;
  
  private Thread clearStatusThread;
  
  public TextPropertiesViewPart() {
    super();
    StatemachineActivator _instance = StatemachineActivator.getInstance();
    final Injector injector = _instance.getInjector("org.xtext.example.statemachine.Statemachine");
    injector.injectMembers(this);
    final Procedure3<EObject, Notification, TransactionalEditingDomain> _function = new Procedure3<EObject, Notification, TransactionalEditingDomain>() {
      @Override
      public void apply(final EObject object, final Notification notification, final TransactionalEditingDomain editingDomain) {
        TextPropertiesViewPart.this.refresh(object, notification);
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
    this.refresh(_selectedObject, null);
    TransactionalEditingDomain _editingDomain = this.resourceProvider.getEditingDomain();
    this.editingDomain = _editingDomain;
  }
  
  @Override
  public void dispose() {
    this.resourceProvider.dispose();
    super.dispose();
  }
  
  protected void refresh(final EObject object, final Notification notification) {
    boolean _or = false;
    if (this.refreshing) {
      _or = true;
    } else {
      _or = this.mergingBack;
    }
    if (_or) {
      return;
    }
    this.refreshing = true;
    try {
      if (((object == this.currentViewedObject) && (notification != null))) {
        final EObject mergeResult = this.resourceProvider.<EObject>mergeForward(object, notification);
        if ((mergeResult != null)) {
          Resource _eResource = mergeResult.eResource();
          final String uriFragment = _eResource.getURIFragment(mergeResult);
          EObject _eContainer = mergeResult.eContainer();
          String _serialize = this.serializer.serialize(_eContainer);
          this.modelAccess.updateModel(_serialize, uriFragment);
          String _editablePart = this.modelAccess.getEditablePart();
          this.lastMergedContent = _editablePart;
          return;
        }
      }
      if ((this.currentViewedObject != null)) {
        final String content = this.modelAccess.getEditablePart();
        boolean _notEquals = (!Objects.equal(content, this.lastMergedContent));
        if (_notEquals) {
          EObject mergeSource = null;
          boolean _and = false;
          if (!(object != this.currentViewedObject)) {
            _and = false;
          } else {
            XtextResource _resource = this.resourceProvider.getResource();
            IParseResult _parseResult = _resource.getParseResult();
            Iterable<INode> _syntaxErrors = _parseResult.getSyntaxErrors();
            boolean _isEmpty = IterableExtensions.isEmpty(_syntaxErrors);
            _and = _isEmpty;
          }
          if (_and) {
            EObject _mergeBack = this.resourceProvider.<EObject>mergeBack(this.currentViewedObject, this.editingDomain);
            mergeSource = _mergeBack;
          }
          if ((mergeSource == null)) {
            this.handleDiscardedChanges();
          }
        }
      }
      if ((object == null)) {
        this.lastMergedContent = "";
        this.modelAccess.updateModel(this.lastMergedContent);
      } else {
        Resource _eResource_1 = object.eResource();
        final String uriFragment_1 = _eResource_1.getURIFragment(object);
        EObject _eContainer_1 = object.eContainer();
        String _serialize_1 = this.serializer.serialize(_eContainer_1);
        this.modelAccess.updateModel(_serialize_1, uriFragment_1);
        this.viewer.setSelectedRange(0, 0);
        String _editablePart_1 = this.modelAccess.getEditablePart();
        this.lastMergedContent = _editablePart_1;
      }
      this.currentViewedObject = object;
    } finally {
      this.refreshing = false;
    }
  }
  
  protected String documentChanged(final XtextResource resource) {
    String _xifexpression = null;
    boolean _and = false;
    if (!(((!this.refreshing) && (!this.mergingBack)) && (this.currentViewedObject != null))) {
      _and = false;
    } else {
      IParseResult _parseResult = resource.getParseResult();
      Iterable<INode> _syntaxErrors = _parseResult.getSyntaxErrors();
      boolean _isEmpty = IterableExtensions.isEmpty(_syntaxErrors);
      _and = _isEmpty;
    }
    if (_and) {
      String _xblockexpression = null;
      {
        this.mergingBack = true;
        String _xtrycatchfinallyexpression = null;
        try {
          String _xblockexpression_1 = null;
          {
            this.resourceProvider.<EObject>mergeBack(this.currentViewedObject, this.editingDomain);
            String _editablePart = this.modelAccess.getEditablePart();
            _xblockexpression_1 = this.lastMergedContent = _editablePart;
          }
          _xtrycatchfinallyexpression = _xblockexpression_1;
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
    boolean _and = false;
    if (!(this.clearStatusThread != null)) {
      _and = false;
    } else {
      boolean _isAlive = this.clearStatusThread.isAlive();
      _and = _isAlive;
    }
    if (_and) {
      this.clearStatusThread.interrupt();
    }
    IViewSite _viewSite = this.getViewSite();
    Shell _shell = _viewSite.getShell();
    final Display display = _shell.getDisplay();
    IViewSite _viewSite_1 = this.getViewSite();
    IActionBars _actionBars = _viewSite_1.getActionBars();
    IEditorPart _editorPart = this.resourceProvider.getEditorPart();
    IEditorSite _editorSite = _editorPart.getEditorSite();
    IActionBars _actionBars_1 = _editorSite.getActionBars();
    final List<IActionBars> actionBars = Collections.<IActionBars>unmodifiableList(CollectionLiterals.<IActionBars>newArrayList(_actionBars, _actionBars_1));
    final Runnable _function = new Runnable() {
      @Override
      public void run() {
        final Procedure1<IActionBars> _function = new Procedure1<IActionBars>() {
          @Override
          public void apply(final IActionBars it) {
            IStatusLineManager _statusLineManager = it.getStatusLineManager();
            _statusLineManager.setErrorMessage("Warning: The previous text changes have been discarded due to syntax errors.");
          }
        };
        IterableExtensions.<IActionBars>forEach(actionBars, _function);
      }
    };
    display.asyncExec(_function);
    final Runnable _function_1 = new Runnable() {
      @Override
      public void run() {
        try {
          Thread.sleep(5000);
          final Runnable _function = new Runnable() {
            @Override
            public void run() {
              final Procedure1<IActionBars> _function = new Procedure1<IActionBars>() {
                @Override
                public void apply(final IActionBars it) {
                  IStatusLineManager _statusLineManager = it.getStatusLineManager();
                  _statusLineManager.setErrorMessage(null);
                }
              };
              IterableExtensions.<IActionBars>forEach(actionBars, _function);
            }
          };
          display.syncExec(_function);
        } catch (final Throwable _t) {
          if (_t instanceof InterruptedException) {
            final InterruptedException exception = (InterruptedException)_t;
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
    };
    Thread _thread = new Thread(_function_1);
    this.clearStatusThread = _thread;
    this.clearStatusThread.start();
  }
  
  @Override
  public void setFocus() {
    Control _control = this.viewer.getControl();
    _control.setFocus();
  }
}
