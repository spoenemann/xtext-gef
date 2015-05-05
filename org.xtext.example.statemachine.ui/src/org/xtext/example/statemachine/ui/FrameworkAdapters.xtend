/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xtext.example.statemachine.ui

import java.util.ArrayList
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.transaction.TransactionalEditingDomain

final class FrameworkAdapters {
	
	private new() {}
	
	interface IAdapter {
		def boolean appliesTo(Object element)
		def EObject getModel(Object element)
		def TransactionalEditingDomain getEditingDomain(Object element)
	}
	
	static val adapters = new ArrayList<IAdapter>
	
	static def addAdapter(IAdapter adapter) {
		synchronized (adapters) {
			if (!adapters.exists[class == adapter.class])
				adapters += adapter
		}
	}
	
	static def getAdapter(Object element) {
		synchronized (adapters) {
			adapters.findFirst[appliesTo(element)]
		}
	}
	
}