/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.xtext.xproperties;

import com.google.common.base.Objects;
import java.util.ArrayList;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
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
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure3;
import org.eclipse.xtext.xbase.lib.Pure;
import org.xtext.xproperties.FrameworkAdapters;

@SuppressWarnings("all")
class EObjectSelectionListener implements ISelectionListener {
  private final ArrayList<Procedure3<? super EObject, ? super Notification, ? super TransactionalEditingDomain>> stateChangeListeners = new ArrayList<Procedure3<? super EObject, ? super Notification, ? super TransactionalEditingDomain>>();
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private EObject selectedObject;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private IEditorPart currentEditor;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private TransactionalEditingDomain editingDomain;
  
  private Adapter adapter;
  
  public EObjectSelectionListener() {
    IWorkbench _workbench = PlatformUI.getWorkbench();
    final IWorkbenchWindow workbenchWindow = _workbench.getActiveWorkbenchWindow();
    final ISelectionService selectionService = workbenchWindow.getSelectionService();
    selectionService.addSelectionListener(this);
    IWorkbenchPage _activePage = workbenchWindow.getActivePage();
    IWorkbenchPart _activePart = _activePage.getActivePart();
    ISelection _selection = selectionService.getSelection();
    this.selectionChanged(_activePart, _selection);
  }
  
  public TransactionalEditingDomain dispose() {
    TransactionalEditingDomain _xblockexpression = null;
    {
      IWorkbench _workbench = PlatformUI.getWorkbench();
      IWorkbenchWindow _activeWorkbenchWindow = _workbench.getActiveWorkbenchWindow();
      final ISelectionService selectionService = _activeWorkbenchWindow.getSelectionService();
      selectionService.removeSelectionListener(this);
      this.stateChangeListeners.clear();
      this.selectedObject = null;
      this.currentEditor = null;
      _xblockexpression = this.editingDomain = null;
    }
    return _xblockexpression;
  }
  
  public boolean addStateChangeListener(final Procedure3<? super EObject, ? super Notification, ? super TransactionalEditingDomain> listener) {
    return this.stateChangeListeners.add(listener);
  }
  
  @Override
  public void selectionChanged(final IWorkbenchPart part, final ISelection selection) {
    if ((part instanceof IEditorPart)) {
      this.currentEditor = ((IEditorPart)part);
      if ((selection instanceof IStructuredSelection)) {
        final Object element = ((IStructuredSelection) selection).getFirstElement();
        final FrameworkAdapters.IAdapter adapter = FrameworkAdapters.getAdapter(element);
        if ((adapter != null)) {
          EObject _model = adapter.getModel(element);
          TransactionalEditingDomain _editingDomain = adapter.getEditingDomain(element);
          this.handleSelection(_model, _editingDomain);
          return;
        }
      }
      this.editingDomain = null;
      this.handleSelection(null, null);
    }
  }
  
  private boolean handleSelection(final EObject object, final TransactionalEditingDomain editingDomain) {
    boolean _xifexpression = false;
    if ((object != this.selectedObject)) {
      boolean _xblockexpression = false;
      {
        boolean _notEquals = (!Objects.equal(this.selectedObject, null));
        if (_notEquals) {
          EList<Adapter> _eAdapters = this.selectedObject.eAdapters();
          _eAdapters.remove(this.adapter);
        }
        this.selectedObject = object;
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
                  IterableExtensions.<Procedure3<? super EObject, ? super Notification, ? super TransactionalEditingDomain>>forEach(EObjectSelectionListener.this.stateChangeListeners, _function);
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
  
  @Pure
  public EObject getSelectedObject() {
    return this.selectedObject;
  }
  
  @Pure
  public IEditorPart getCurrentEditor() {
    return this.currentEditor;
  }
  
  @Pure
  public TransactionalEditingDomain getEditingDomain() {
    return this.editingDomain;
  }
}
