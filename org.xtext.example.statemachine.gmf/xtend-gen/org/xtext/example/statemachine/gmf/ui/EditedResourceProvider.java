package org.xtext.example.statemachine.gmf.ui;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
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
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.xtext.example.statemachine.statemachine.State;
import org.xtext.example.statemachine.statemachine.diagram.edit.parts.StateEditPart;

@SuppressWarnings("all")
public class EditedResourceProvider implements IEditedResourceProvider {
  public static class SelectionListener implements ISelectionListener {
    private State currentState;
    
    private Collection<Procedure1<? super State>> stateChangeListeners;
    
    @Override
    public void selectionChanged(final IWorkbenchPart part, final ISelection selection) {
      if ((part instanceof IEditorPart)) {
        if ((selection instanceof IStructuredSelection)) {
          final Object element = ((IStructuredSelection) selection).getFirstElement();
          if ((element instanceof StateEditPart)) {
            View _notationView = ((IGraphicalEditPart) element).getNotationView();
            EObject _element = _notationView.getElement();
            this.handleState(((State) _element));
            return;
          }
        }
        this.handleState(null);
      }
    }
    
    private void handleState(final State state) {
      if ((state != this.currentState)) {
        this.currentState = state;
        final Procedure1<Procedure1<? super State>> _function = new Procedure1<Procedure1<? super State>>() {
          @Override
          public void apply(final Procedure1<? super State> it) {
            it.apply(state);
          }
        };
        IterableExtensions.<Procedure1<? super State>>forEach(this.stateChangeListeners, _function);
      }
    }
  }
  
  private final EditedResourceProvider.SelectionListener selectionListener = new EditedResourceProvider.SelectionListener();
  
  public EditedResourceProvider(final Procedure1<? super State>... stateChangeListeners) {
    this.selectionListener.stateChangeListeners = ((Collection<Procedure1<? super State>>)Conversions.doWrapArray(stateChangeListeners));
    IWorkbench _workbench = PlatformUI.getWorkbench();
    final IWorkbenchWindow workbenchWindow = _workbench.getActiveWorkbenchWindow();
    final ISelectionService selectionService = workbenchWindow.getSelectionService();
    selectionService.addSelectionListener(this.selectionListener);
    IWorkbenchPage _activePage = workbenchWindow.getActivePage();
    IWorkbenchPart _activePart = _activePage.getActivePart();
    ISelection _selection = selectionService.getSelection();
    this.selectionListener.selectionChanged(_activePart, _selection);
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
    final XtextResource resource = ((XtextResource) _createResource);
    return resource;
  }
  
  public List<String> createTextParts() {
    final State state = this.getSelectedState();
    boolean _or = false;
    if ((state == null)) {
      _or = true;
    } else {
      EObject _eContainer = state.eContainer();
      boolean _tripleEquals = (_eContainer == null);
      _or = _tripleEquals;
    }
    if (_or) {
      throw new IllegalStateException();
    }
    final ICompositeNode stateNode = NodeModelUtils.findActualNodeFor(state);
    EObject _eContainer_1 = state.eContainer();
    ICompositeNode _node = NodeModelUtils.getNode(_eContainer_1);
    final String model = _node.getText();
    int _offset = stateNode.getOffset();
    final String prefix = model.substring(0, _offset);
    int _endOffset = stateNode.getEndOffset();
    final String suffix = model.substring(_endOffset);
    String _text = stateNode.getText();
    return Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(prefix, _text, suffix));
  }
  
  public State getSelectedState() {
    return this.selectionListener.currentState;
  }
}
