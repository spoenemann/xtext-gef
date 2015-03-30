/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xtext.example.statemachine.gmf

import java.util.Collection
import org.eclipse.emf.common.notify.Notification
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.validation.model.IModelConstraint
import org.eclipse.emf.validation.service.IModelConstraintProvider
import org.xtext.example.statemachine.statemachine.State
import org.xtext.example.statemachine.statemachine.StatemachinePackage

class StatemachineConstraintProvider implements IModelConstraintProvider {
	
	override getBatchConstraints(EObject eObject, Collection<IModelConstraint> constraints) {
		var result = constraints
		if (eObject instanceof State) {
			if (result === null) {
				result = newHashSet
			}
			result += getConstraint(eObject as State)
		}
		return result
	}
	
	override getLiveConstraints(Notification notification, Collection<IModelConstraint> constraints) {
		var result = constraints
		if (notification.feature == StatemachinePackage.Literals.STATE__NAME) {
			if (result === null) {
				result = newHashSet
			}
			result += getConstraint(notification.notifier as State)
		}
		return result
	}
	
	private def getConstraint(State state) {
		new StateConstraint
	}
	
}