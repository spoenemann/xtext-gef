/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xtext.xproperties

import java.util.ArrayList
import org.eclipse.emf.common.notify.Adapter
import org.eclipse.emf.common.notify.Notification
import org.eclipse.emf.common.notify.impl.AdapterImpl
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.transaction.TransactionalEditingDomain
import org.eclipse.jface.viewers.ISelection
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.ui.IEditorPart
import org.eclipse.ui.ISelectionListener
import org.eclipse.ui.IWorkbenchPart
import org.eclipse.ui.PlatformUI
import org.eclipse.xtend.lib.annotations.Accessors

package class EObjectSelectionListener implements ISelectionListener {
		
	val stateChangeListeners = new ArrayList<(EObject, Notification, TransactionalEditingDomain)=>void>
	
	@Accessors(PUBLIC_GETTER)
	EObject selectedObject
	
	@Accessors(PUBLIC_GETTER)
	IEditorPart currentEditor
	
	@Accessors(PUBLIC_GETTER)
	TransactionalEditingDomain editingDomain
	
	Adapter adapter
	
	new() {
		val workbenchWindow = PlatformUI.workbench.activeWorkbenchWindow
		val selectionService = workbenchWindow.selectionService
		selectionService.addSelectionListener(this)
		selectionChanged(workbenchWindow.activePage.activePart, selectionService.selection)
	}
	
	def dispose() {
		val selectionService = PlatformUI.workbench.activeWorkbenchWindow.selectionService
		selectionService.removeSelectionListener(this)
		stateChangeListeners.clear()
		selectedObject = null
		currentEditor = null
		editingDomain = null
	}
	
	def addStateChangeListener((EObject, Notification, TransactionalEditingDomain)=>void listener) {
		stateChangeListeners.add(listener)
	}
	
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
		if (object !== selectedObject) {
			if (selectedObject != null) {
				selectedObject.eAdapters -= adapter
			}
			selectedObject = object
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
