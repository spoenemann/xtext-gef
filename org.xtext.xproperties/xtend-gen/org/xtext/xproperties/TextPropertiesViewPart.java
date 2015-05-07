/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.xtext.xproperties;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.text.IRegion;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Resource;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess;
import org.eclipse.xtext.ui.editor.validation.IValidationIssueProcessor;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure3;
import org.xtext.xproperties.EObjectSelectionListener;
import org.xtext.xproperties.EditedResourceProvider;
import org.xtext.xproperties.EmbeddedResourceValidator;
import org.xtext.xproperties.IModelMerger;

@SuppressWarnings("all")
public class TextPropertiesViewPart extends ViewPart {
  @Inject
  private EditedResourceProvider resourceProvider;
  
  @Inject
  private IModelMerger modelMerger;
  
  @Inject
  private EmbeddedEditorFactory editorFactory;
  
  @Inject
  private EmbeddedResourceValidator resourceValidator;
  
  @Inject
  private ISerializer serializer;
  
  private final ArrayList<Resource> swtResources = new ArrayList<Resource>();
  
  private final ExecutorService executorService = Executors.newCachedThreadPool();
  
  private EObjectSelectionListener selectionListener;
  
  private XtextSourceViewer viewer;
  
  private EmbeddedEditorModelAccess modelAccess;
  
  private EObject currentViewedObject;
  
  private TransactionalEditingDomain editingDomain;
  
  private String lastMergedContent;
  
  private boolean refreshing;
  
  private boolean mergingBack;
  
  private Thread clearStatusThread;
  
  private List<Issue> validationErrors;
  
  @Override
  public void createPartControl(final Composite parent) {
    EmbeddedEditorFactory.Builder _newEditor = this.editorFactory.newEditor(this.resourceProvider);
    EmbeddedEditorFactory.Builder _showErrorAndWarningAnnotations = _newEditor.showErrorAndWarningAnnotations();
    EmbeddedEditorFactory.Builder _withResourceValidator = _showErrorAndWarningAnnotations.withResourceValidator(this.resourceValidator);
    final IValidationIssueProcessor _function = new IValidationIssueProcessor() {
      @Override
      public void processIssues(final List<Issue> issues, final IProgressMonitor monitor) {
        final Function1<Issue, Boolean> _function = new Function1<Issue, Boolean>() {
          @Override
          public Boolean apply(final Issue it) {
            Severity _severity = it.getSeverity();
            return Boolean.valueOf(Objects.equal(_severity, Severity.ERROR));
          }
        };
        Iterable<Issue> _filter = IterableExtensions.<Issue>filter(issues, _function);
        List<Issue> _list = IterableExtensions.<Issue>toList(_filter);
        TextPropertiesViewPart.this.validationErrors = _list;
        final Callable<String> _function_1 = new Callable<String>() {
          @Override
          public String call() throws Exception {
            return TextPropertiesViewPart.this.documentChanged();
          }
        };
        TextPropertiesViewPart.this.executorService.<String>submit(_function_1);
      }
    };
    EmbeddedEditorFactory.Builder _processIssuesBy = _withResourceValidator.processIssuesBy(_function);
    final EmbeddedEditor editor = _processIssuesBy.withParent(parent);
    EmbeddedEditorModelAccess _createPartialEditor = editor.createPartialEditor();
    this.modelAccess = _createPartialEditor;
    XtextSourceViewer _viewer = editor.getViewer();
    this.viewer = _viewer;
    StyledText _textWidget = this.viewer.getTextWidget();
    Font _font = this.getFont();
    _textWidget.setFont(_font);
    final Function0<String> _function_1 = new Function0<String>() {
      @Override
      public String apply() {
        return TextPropertiesViewPart.this.modelAccess.getSerializedModel();
      }
    };
    this.resourceValidator.setEmbeddedTextProvider(_function_1);
    final Function0<ITextRegion> _function_2 = new Function0<ITextRegion>() {
      @Override
      public ITextRegion apply() {
        TextRegion _xblockexpression = null;
        {
          final IRegion region = TextPropertiesViewPart.this.viewer.getVisibleRegion();
          int _offset = region.getOffset();
          int _length = region.getLength();
          _xblockexpression = new TextRegion(_offset, _length);
        }
        return _xblockexpression;
      }
    };
    this.resourceValidator.setVisibleRegionProvider(_function_2);
    EObjectSelectionListener _eObjectSelectionListener = new EObjectSelectionListener();
    this.selectionListener = _eObjectSelectionListener;
    final Procedure3<EObject, Notification, TransactionalEditingDomain> _function_3 = new Procedure3<EObject, Notification, TransactionalEditingDomain>() {
      @Override
      public void apply(final EObject object, final Notification notification, final TransactionalEditingDomain editingDomain) {
        TextPropertiesViewPart.this.refresh(object, notification);
        TextPropertiesViewPart.this.editingDomain = editingDomain;
      }
    };
    this.selectionListener.addStateChangeListener(_function_3);
    EObject _selectedObject = this.selectionListener.getSelectedObject();
    this.refresh(_selectedObject, null);
    TransactionalEditingDomain _editingDomain = this.selectionListener.getEditingDomain();
    this.editingDomain = _editingDomain;
  }
  
  protected Font getFont() {
    IViewSite _viewSite = this.getViewSite();
    Shell _shell = _viewSite.getShell();
    Display _display = _shell.getDisplay();
    final Font font = new Font(_display, "Courier", 14, 0);
    this.swtResources.add(font);
    return font;
  }
  
  @Override
  public void dispose() {
    if (this.selectionListener!=null) {
      this.selectionListener.dispose();
    }
    final Procedure1<Resource> _function = new Procedure1<Resource>() {
      @Override
      public void apply(final Resource it) {
        it.dispose();
      }
    };
    IterableExtensions.<Resource>forEach(this.swtResources, _function);
    this.swtResources.clear();
    this.executorService.shutdown();
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
        final EObject mergeResult = this.mergeForward(object, notification);
        if ((mergeResult != null)) {
          org.eclipse.emf.ecore.resource.Resource _eResource = mergeResult.eResource();
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
            boolean _isEmpty = this.validationErrors.isEmpty();
            _and = _isEmpty;
          }
          if (_and) {
            EObject _mergeBack = this.mergeBack(this.currentViewedObject, this.editingDomain);
            mergeSource = _mergeBack;
          }
          if ((mergeSource == null)) {
            this.handleDiscardedChanges();
          }
        }
      }
      this.resourceValidator.setOriginalObject(object);
      if ((object == null)) {
        this.lastMergedContent = "";
        this.modelAccess.updateModel(this.lastMergedContent);
      } else {
        org.eclipse.emf.ecore.resource.Resource _eResource_1 = object.eResource();
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
  
  protected String documentChanged() {
    String _xifexpression = null;
    boolean _and = false;
    if (!(((!this.refreshing) && (!this.mergingBack)) && (this.currentViewedObject != null))) {
      _and = false;
    } else {
      boolean _isEmpty = this.validationErrors.isEmpty();
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
            final EObject mergeSource = this.mergeBack(this.currentViewedObject, this.editingDomain);
            String _xifexpression_1 = null;
            if ((mergeSource != null)) {
              String _editablePart = this.modelAccess.getEditablePart();
              _xifexpression_1 = this.lastMergedContent = _editablePart;
            }
            _xblockexpression_1 = _xifexpression_1;
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
  
  protected EObject mergeForward(final EObject object, final Notification notification) {
    XtextResource _resource = this.resourceProvider.getResource();
    IParseResult _parseResult = _resource.getParseResult();
    final EObject modelCopy = _parseResult.getRootASTElement();
    final EObject copy = this.modelMerger.findMatchingObject(modelCopy, object);
    boolean _or = false;
    if ((copy == null)) {
      _or = true;
    } else {
      EObject _eContainer = copy.eContainer();
      boolean _tripleEquals = (_eContainer == null);
      _or = _tripleEquals;
    }
    if (_or) {
      return null;
    }
    try {
      this.modelMerger.apply(notification, copy);
      return copy;
    } catch (final Throwable _t) {
      if (_t instanceof UnsupportedOperationException) {
        final UnsupportedOperationException uoe = (UnsupportedOperationException)_t;
        return null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  protected EObject mergeBack(final EObject object, final TransactionalEditingDomain editingDomain) {
    XtextResource _resource = this.resourceProvider.getResource();
    IParseResult _parseResult = _resource.getParseResult();
    final EObject modelCopy = _parseResult.getRootASTElement();
    final EObject copy = this.modelMerger.findMatchingObject(modelCopy, object);
    boolean _or = false;
    if ((copy == null)) {
      _or = true;
    } else {
      EObject _eContainer = copy.eContainer();
      boolean _tripleEquals = (_eContainer == null);
      _or = _tripleEquals;
    }
    if (_or) {
      return null;
    }
    CommandStack _commandStack = editingDomain.getCommandStack();
    _commandStack.execute(new RecordingCommand(editingDomain, "Text Changes") {
      @Override
      protected void doExecute() {
        TextPropertiesViewPart.this.modelMerger.merge(copy, object);
      }
    });
    return copy;
  }
  
  protected Future<?> handleDiscardedChanges() {
    Future<?> _xblockexpression = null;
    {
      if ((this.clearStatusThread != null)) {
        this.clearStatusThread.interrupt();
      }
      IViewSite _viewSite = this.getViewSite();
      Shell _shell = _viewSite.getShell();
      final Display display = _shell.getDisplay();
      IViewSite _viewSite_1 = this.getViewSite();
      IActionBars _actionBars = _viewSite_1.getActionBars();
      IEditorPart _currentEditor = this.selectionListener.getCurrentEditor();
      IEditorSite _editorSite = _currentEditor.getEditorSite();
      IActionBars _actionBars_1 = _editorSite.getActionBars();
      final List<IActionBars> actionBars = Collections.<IActionBars>unmodifiableList(CollectionLiterals.<IActionBars>newArrayList(_actionBars, _actionBars_1));
      final Runnable _function = new Runnable() {
        @Override
        public void run() {
          final Procedure1<IActionBars> _function = new Procedure1<IActionBars>() {
            @Override
            public void apply(final IActionBars it) {
              IStatusLineManager _statusLineManager = it.getStatusLineManager();
              _statusLineManager.setErrorMessage("Warning: The previous text changes have been discarded due to validation errors.");
            }
          };
          IterableExtensions.<IActionBars>forEach(actionBars, _function);
        }
      };
      display.asyncExec(_function);
      final Function1<Object, Object> _function_1 = new Function1<Object, Object>() {
        @Override
        public Object apply(final Object it) {
          Object _xtrycatchfinallyexpression = null;
          try {
            Thread _currentThread = Thread.currentThread();
            TextPropertiesViewPart.this.clearStatusThread = _currentThread;
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
              _xtrycatchfinallyexpression = null;
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          } finally {
            Thread _currentThread_1 = Thread.currentThread();
            boolean _equals = Objects.equal(TextPropertiesViewPart.this.clearStatusThread, _currentThread_1);
            if (_equals) {
              TextPropertiesViewPart.this.clearStatusThread = null;
            }
          }
          return _xtrycatchfinallyexpression;
        }
      };
      _xblockexpression = this.executorService.submit(
        ((Runnable) new Runnable() {
            public void run() {
              _function_1.apply(null);
            }
        }));
    }
    return _xblockexpression;
  }
  
  @Override
  public void setFocus() {
    Control _control = this.viewer.getControl();
    _control.setFocus();
  }
}
