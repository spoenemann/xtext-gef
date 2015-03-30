/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xtext.example.statemachine.gmf

import org.eclipse.emf.common.notify.Notification
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.validation.IValidationContext
import org.eclipse.emf.validation.model.ModelConstraint
import org.eclipse.emf.validation.service.AbstractConstraintDescriptor
import org.xtext.example.statemachine.statemachine.State
import org.eclipse.emf.validation.model.EvaluationMode
import org.eclipse.emf.validation.model.ConstraintSeverity

class StateConstraint extends ModelConstraint {
	
	new() {
		super(new Descriptor)
	}
	
	override equals(Object other) {
		other != null && other.getClass == this.getClass
	}
	
	override hashCode() {
		getClass.hashCode
	}
	
	override validate(IValidationContext ctx) {
		if (ctx.target instanceof State) {
			val state = ctx.target as State
			if (state.name.nullOrEmpty) {
				ctx.createFailureStatus
			}
		}
	}
	
	private static class Descriptor extends AbstractConstraintDescriptor {
		
		override getBody() {
		}
		
		override getDescription() {
			'State validation'
		}
		
		override getEvaluationMode() {
			EvaluationMode.BATCH
		}
		
		override getId() {
			'org.xtext.example.statemachine.gmf.StateValidation'
		}
		
		override getMessagePattern() {
			'The name of a state must not be empty.'
		}
		
		override getName() {
			'StateValidation'
		}
		
		override getPluginId() {
			'org.xtext.example.statemachine.gmf'
		}
		
		override getSeverity() {
			ConstraintSeverity.ERROR
		}
		
		override getStatusCode() {
			0
		}
		
		override targetsEvent(Notification notification) {
			true
		}
		
		override targetsTypeOf(EObject eObject) {
			eObject instanceof State
		}
		
	}
	
}