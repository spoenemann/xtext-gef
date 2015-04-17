package org.xtext.example.statemachine.gmf.ui

import java.util.ArrayList
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.util.EcoreUtil.Copier
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
import org.xtext.example.statemachine.StatemachineUtil
import org.xtext.example.statemachine.statemachine.State
import org.xtext.example.statemachine.statemachine.Statemachine
import org.xtext.example.statemachine.statemachine.diagram.edit.parts.StateEditPart

class EditedResourceProvider implements IEditedResourceProvider {
	
	val selectionListener = new SelectionListener

	XtextResource resource
	
	new() {
		val workbenchWindow = PlatformUI.workbench.activeWorkbenchWindow
		val selectionService = workbenchWindow.selectionService
		selectionService.addSelectionListener(selectionListener)
		selectionListener.selectionChanged(workbenchWindow.activePage.activePart, selectionService.selection)
	}
	
	def addStateChangeListener((State)=>void listener) {
		selectionListener.stateChangeListeners.add(listener)
	}
	
	def dispose() {
		val selectionService = PlatformUI.workbench.activeWorkbenchWindow.selectionService
		selectionService.removeSelectionListener(selectionListener)
	}
	
	override createResource() {
		val resourceSet = new XtextResourceSet
		val uri = URI.createURI("embeddedResource.statemachine")
		resource = resourceSet.createResource(uri) as XtextResource
		return resource
	}
	
	def copy(State state) {
		if (!(state.eContainer instanceof Statemachine))
			throw new IllegalStateException
		val copier = new Copier
		val modelCopy = copier.copy(state.eContainer)
		copier.copyReferences()
		val dummyResource = new XtextResource
		dummyResource.contents += modelCopy
		StatemachineUtil.ensureUniqueIds(dummyResource)
		return copier.get(state)
	}
	
	def getSelectedState() {
		selectionListener.currentState
	}
	
	static class SelectionListener implements ISelectionListener {
		
		State currentState
		val stateChangeListeners = new ArrayList<(State)=>void>
		
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