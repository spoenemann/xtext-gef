package org.xtext.example.statemachine.gmf.ui

import java.util.Collection
import org.eclipse.emf.common.util.URI
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart
import org.eclipse.jface.viewers.ISelection
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.ui.IEditorPart
import org.eclipse.ui.ISelectionListener
import org.eclipse.ui.IWorkbenchPart
import org.eclipse.ui.PlatformUI
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider
import org.xtext.example.statemachine.statemachine.State
import org.xtext.example.statemachine.statemachine.diagram.edit.parts.StateEditPart
import org.eclipse.xtext.nodemodel.util.NodeModelUtils

class EditedResourceProvider implements IEditedResourceProvider {
	
	val selectionListener = new SelectionListener
	
	new((State)=>void... stateChangeListeners) {
		selectionListener.stateChangeListeners = stateChangeListeners
		val workbenchWindow = PlatformUI.workbench.activeWorkbenchWindow
		val selectionService = workbenchWindow.selectionService
		selectionService.addSelectionListener(selectionListener)
		selectionListener.selectionChanged(workbenchWindow.activePage.activePart, selectionService.selection)
	}
	
	def dispose() {
		val selectionService = PlatformUI.workbench.activeWorkbenchWindow.selectionService
		selectionService.removeSelectionListener(selectionListener)
	}
	
	override createResource() {
		val resourceSet = new XtextResourceSet
		val uri = URI.createURI("embeddedResource.statemachine");
		val resource = resourceSet.createResource(uri) as XtextResource
		return resource
	}
	
	def createTextParts() {
		val state = selectedState
		if (state === null || state.eContainer === null) {
			throw new IllegalStateException
		}
		val stateNode = NodeModelUtils.findActualNodeFor(state)
		val model = NodeModelUtils.getNode(state.eContainer).text
		val prefix = model.substring(0, stateNode.offset)
		val suffix = model.substring(stateNode.endOffset)
		return #[prefix, stateNode.text, suffix]
	}
	
	def getSelectedState() {
		selectionListener.currentState
	}
	
	static class SelectionListener implements ISelectionListener {
		
		State currentState
		Collection<(State)=>void> stateChangeListeners
		
		override selectionChanged(IWorkbenchPart part, ISelection selection) {
			if (part instanceof IEditorPart) {
				if (selection instanceof IStructuredSelection) {
					val element = (selection as IStructuredSelection).firstElement
					if (element instanceof StateEditPart) {
						 handleState((element as IGraphicalEditPart).notationView.element as State)
						 return
					}
				}
				handleState(null)
			}
		}
		
		private def handleState(State state) {
			if (state !== currentState) {
				currentState = state
				stateChangeListeners.forEach[apply(state)]
			}
		}
		
	}
	
}