/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xtext.example.statemachine.graphiti

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider

class StatemachineDiagramTypeProvider extends AbstractDiagramTypeProvider {
	
	new() {
		featureProvider = new StatemachineFeatureProvider(this)
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