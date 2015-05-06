/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xtext.example.statemachine.ui.views

import com.google.inject.Inject
import java.util.ArrayList
import org.eclipse.emf.common.notify.Adapter
import org.eclipse.emf.common.notify.Notification
import org.eclipse.emf.common.notify.impl.AdapterImpl
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.transaction.RecordingCommand
import org.eclipse.emf.transaction.TransactionalEditingDomain
import org.eclipse.jface.viewers.ISelection
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.ui.IEditorPart
import org.eclipse.ui.ISelectionListener
import org.eclipse.ui.IWorkbenchPart
import org.eclipse.ui.PlatformUI
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider
import org.xtext.example.statemachine.StatemachineUtil
import org.xtext.example.statemachine.merging.IModelMerger
import org.xtext.example.statemachine.ui.FrameworkAdapters

class EditedResourceProvider implements IEditedResourceProvider {
	
	@Inject IModelMerger modelMerger
	
	val selectionListener = new SelectionListener

	@Accessors(PUBLIC_GETTER)
	XtextResource resource
	
	new() {
		val workbenchWindow = PlatformUI.workbench.activeWorkbenchWindow
		val selectionService = workbenchWindow.selectionService
		selectionService.addSelectionListener(selectionListener)
		selectionListener.selectionChanged(workbenchWindow.activePage.activePart, selectionService.selection)
	}
	
	def addStateChangeListener((EObject, Notification, TransactionalEditingDomain)=>void listener) {
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
	
	def <T extends EObject> mergeForward(T object, Notification notification) {
		val uriFragment = object.eResource().getURIFragment(object)
		val copy = resource.getEObject(uriFragment)
		if (copy === null || copy.eContainer === null) {
			return null
		}
		try {
			modelMerger.apply(notification, copy)
			return copy as T
		} catch (UnsupportedOperationException uoe) {
			return null
		}
	}
	
	def <T extends EObject> mergeBack(T object, TransactionalEditingDomain editingDomain) {
		val uriFragment = object.eResource().getURIFragment(object)
		val copy = resource.getEObject(uriFragment)
		if (copy === null || copy.eContainer === null) {
			return null
		}
		editingDomain.commandStack.execute(new RecordingCommand(editingDomain, 'Text Changes') {
			override protected doExecute() {
				modelMerger.merge(copy, object)
			}
		})
		return copy as T
	}
	
	def getSelectedObject() {
		selectionListener.currentObject
	}
	
	def getEditorPart() {
		selectionListener.currentEditor
	}
	
	def getEditingDomain() {
		selectionListener.editingDomain
	}
	
	static class SelectionListener implements ISelectionListener {
		
		val stateChangeListeners = new ArrayList<(EObject, Notification, TransactionalEditingDomain)=>void>
		EObject currentObject
		IEditorPart currentEditor
		TransactionalEditingDomain editingDomain
		Adapter adapter
		
		override selectionChanged(IWorkbenchPart part, ISelection selection) {
			if (part instanceof IEditorPart) {
				currentEditor = part
				if (selection instanceof IStructuredSelection) {
					val element = (selection as IStructuredSelection).firstElement
					val adapter = FrameworkAdapters.getAdapter(element)
					if (adapter !== null) {
						handleSelection(adapter.getModel(element), adapter.getEditingDomain(element))
						return
					}
				}
				editingDomain = null
				handleSelection(null, null)
			}
		}
		
		private def handleSelection(EObject object, TransactionalEditingDomain editingDomain) {
			if (object !== currentObject) {
				if (currentObject != null) {
					currentObject.eAdapters -= adapter
				}
				currentObject = object
				stateChangeListeners.forEach[apply(object, null, editingDomain)]
				if (object !== null) {
					 adapter = new AdapterImpl {
						override notifyChanged(Notification msg) {
							if (msg.eventType != Notification.REMOVING_ADAPTER) {
								stateChangeListeners.forEach[apply(object, msg, editingDomain)]
							}
						}
					}
					object.eAdapters += adapter
				}
			}
		}
		
	}
	
}
