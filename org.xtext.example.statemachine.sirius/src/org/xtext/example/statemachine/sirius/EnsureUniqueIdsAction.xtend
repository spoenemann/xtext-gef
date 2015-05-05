/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xtext.example.statemachine.sirius

import java.util.Collection
import java.util.Map
import org.eclipse.emf.ecore.EObject
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction
import org.xtext.example.statemachine.StatemachineUtil
import org.xtext.example.statemachine.statemachine.Statemachine

class EnsureUniqueIdsAction implements IExternalJavaAction {
	
	override canExecute(Collection<? extends EObject> selection) {
		selection.exists[it instanceof Statemachine]
	}
	
	override execute(Collection<? extends EObject> selection, Map<String, Object> parameters) {
		val statemachine = selection.findFirst[it instanceof Statemachine]
		if (statemachine !== null) {
			StatemachineUtil.ensureUniqueIds(statemachine.eResource)
		}
	}
	
}