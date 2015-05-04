package org.xtext.example.statemachine.gmf.ui;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure3;
import org.xtext.example.statemachine.StatemachineUtil;

@SuppressWarnings("all")
public class EditedResourceProvider implements IEditedResourceProvider {
  public static class SelectionListener implements ISelectionListener {
    private final ArrayList<Procedure3<? super EObject, ? super Notification, ? super TransactionalEditingDomain>> stateChangeListeners = new ArrayList<Procedure3<? super EObject, ? super Notification, ? super TransactionalEditingDomain>>();
    
    private Collection<Class<? extends EObject>> types;
    
    private EObject currentObject;
    
    private TransactionalEditingDomain editingDomain;
    
    private Adapter adapter;
    
    @Override
    public void selectionChanged(final IWorkbenchPart part, final ISelection selection) {
      if ((part instanceof IEditorPart)) {
        if ((selection instanceof IStructuredSelection)) {
          final Object element = ((IStructuredSelection) selection).getFirstElement();
          if ((element instanceof IGraphicalEditPart)) {
            View _notationView = ((IGraphicalEditPart)element).getNotationView();
            final EObject object = _notationView.getElement();
            final Function1<Class<? extends EObject>, Boolean> _function = new Function1<Class<? extends EObject>, Boolean>() {
              @Override
              public Boolean apply(final Class<? extends EObject> it) {
                return Boolean.valueOf(it.isInstance(object));
              }
            };
            boolean _exists = IterableExtensions.<Class<? extends EObject>>exists(this.types, _function);
            if (_exists) {
              TransactionalEditingDomain _editingDomain = ((IGraphicalEditPart)element).getEditingDomain();
              this.handleSelection(object, _editingDomain);
              return;
            }
          }
        }
        this.editingDomain = null;
        this.handleSelection(null, null);
      }
    }
    
    private boolean handleSelection(final EObject object, final TransactionalEditingDomain editingDomain) {
      boolean _xifexpression = false;
      if ((object != this.currentObject)) {
        boolean _xblockexpression = false;
        {
          boolean _notEquals = (!Objects.equal(this.currentObject, null));
          if (_notEquals) {
            EList<Adapter> _eAdapters = this.currentObject.eAdapters();
            _eAdapters.remove(this.adapter);
          }
          this.currentObject = object;
          final Procedure1<Procedure3<? super EObject, ? super Notification, ? super TransactionalEditingDomain>> _function = new Procedure1<Procedure3<? super EObject, ? super Notification, ? super TransactionalEditingDomain>>() {
            @Override
            public void apply(final Procedure3<? super EObject, ? super Notification, ? super TransactionalEditingDomain> it) {
              it.apply(object, null, editingDomain);
            }
          };
          IterableExtensions.<Procedure3<? super EObject, ? super Notification, ? super TransactionalEditingDomain>>forEach(this.stateChangeListeners, _function);
          boolean _xifexpression_1 = false;
          if ((object != null)) {
            boolean _xblockexpression_1 = false;
            {
              this.adapter = new AdapterImpl() {
                @Override
                public void notifyChanged(final Notification msg) {
                  int _eventType = msg.getEventType();
                  boolean _notEquals = (_eventType != Notification.REMOVING_ADAPTER);
                  if (_notEquals) {
                    final Procedure1<Procedure3<? super EObject, ? super Notification, ? super TransactionalEditingDomain>> _function = new Procedure1<Procedure3<? super EObject, ? super Notification, ? super TransactionalEditingDomain>>() {
                      @Override
                      public void apply(final Procedure3<? super EObject, ? super Notification, ? super TransactionalEditingDomain> it) {
                        it.apply(object, msg, editingDomain);
                      }
                    };
                    IterableExtensions.<Procedure3<? super EObject, ? super Notification, ? super TransactionalEditingDomain>>forEach(SelectionListener.this.stateChangeListeners, _function);
                  }
                }
              };
              EList<Adapter> _eAdapters_1 = object.eAdapters();
              _xblockexpression_1 = _eAdapters_1.add(this.adapter);
            }
            _xifexpression_1 = _xblockexpression_1;
          }
          _xblockexpression = _xifexpression_1;
        }
        _xifexpression = _xblockexpression;
      }
      return _xifexpression;
    }
  }
  
  private final EditedResourceProvider.SelectionListener selectionListener = new EditedResourceProvider.SelectionListener();
  
  private XtextResource resource;
  
  public EditedResourceProvider(final Collection<Class<? extends EObject>> types) {
    this.selectionListener.types = types;
    IWorkbench _workbench = PlatformUI.getWorkbench();
    final IWorkbenchWindow workbenchWindow = _workbench.getActiveWorkbenchWindow();
    final ISelectionService selectionService = workbenchWindow.getSelectionService();
    selectionService.addSelectionListener(this.selectionListener);
    IWorkbenchPage _activePage = workbenchWindow.getActivePage();
    IWorkbenchPart _activePart = _activePage.getActivePart();
    ISelection _selection = selectionService.getSelection();
    this.selectionListener.selectionChanged(_activePart, _selection);
  }
  
  public boolean addStateChangeListener(final Procedure3<? super EObject, ? super Notification, ? super TransactionalEditingDomain> listener) {
    return this.selectionListener.stateChangeListeners.add(listener);
  }
  
  public void dispose() {
    IWorkbench _workbench = PlatformUI.getWorkbench();
    IWorkbenchWindow _activeWorkbenchWindow = _workbench.getActiveWorkbenchWindow();
    final ISelectionService selectionService = _activeWorkbenchWindow.getSelectionService();
    selectionService.removeSelectionListener(this.selectionListener);
  }
  
  @Override
  public XtextResource createResource() {
    final XtextResourceSet resourceSet = new XtextResourceSet();
    final URI uri = URI.createURI("embeddedResource.statemachine");
    Resource _createResource = resourceSet.createResource(uri);
    this.resource = ((XtextResource) _createResource);
    return this.resource;
  }
  
  public <T extends EObject> T mergeForward(final T object, final Notification notification) {
    Resource _eResource = object.eResource();
    final String uriFragment = _eResource.getURIFragment(object);
    final EObject copy = this.resource.getEObject(uriFragment);
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
      StatemachineUtil.apply(notification, copy);
      return ((T) copy);
    } catch (final Throwable _t) {
      if (_t instanceof UnsupportedOperationException) {
        final UnsupportedOperationException uoe = (UnsupportedOperationException)_t;
        return null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public <T extends EObject> T mergeBack(final T object, final TransactionalEditingDomain editingDomain) {
    Resource _eResource = object.eResource();
    final String uriFragment = _eResource.getURIFragment(object);
    final EObject copy = this.resource.getEObject(uriFragment);
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
        StatemachineUtil.copyFeatures(copy, object);
      }
    });
    return ((T) copy);
  }
  
  public EObject getSelectedObject() {
    return this.selectionListener.currentObject;
  }
  
  public TransactionalEditingDomain getEditingDomain() {
    return this.selectionListener.editingDomain;
  }
}
