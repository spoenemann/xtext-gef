/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xtext.example.statemachine.graphiti

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider
import org.eclipse.graphiti.ui.internal.parts.IPictogramElementEditPart
import org.xtext.example.statemachine.ui.FrameworkAdapters

class StatemachineDiagramTypeProvider extends AbstractDiagramTypeProvider {
	
	static class GraphitiFrameworkAdapter implements FrameworkAdapters.IAdapter {
		override appliesTo(Object element) {
			element instanceof IPictogramElementEditPart
		}
		
		override getModel(Object element) {
			(element as IPictogramElementEditPart).pictogramElement.link.businessObjects.head
		}
		
		override getEditingDomain(Object element) {
			(element as IPictogramElementEditPart).configurationProvider.diagramBehavior.editingDomain
		}
	}
	
	new() {
		featureProvider = new StatemachineFeatureProvider(this)
		FrameworkAdapters.addAdapter(new GraphitiFrameworkAdapter)
	}
	
	override isAutoUpdateAtStartup() {
		true
	}
	
	override isAutoUpdateAtRuntime() {
		true
	}
	
	override isAutoUpdateAtReset() {
		true
	}
	
}