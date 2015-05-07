/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xtext.xproperties

import java.util.Collection
import org.eclipse.emf.common.notify.Notification
import org.eclipse.emf.common.util.BasicMonitor
import org.eclipse.emf.compare.EMFCompare
import org.eclipse.emf.compare.merge.BatchMerger
import org.eclipse.emf.compare.rcp.EMFCompareRCPPlugin
import org.eclipse.emf.compare.scope.DefaultComparisonScope
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EStructuralFeature

import static org.eclipse.emf.common.notify.Notification.*
import org.eclipse.emf.ecore.util.EcoreUtil

class GenericModelMerger implements IModelMerger {
	
	override findMatchingObject(EObject model, EObject object) {
		val scope = new DefaultComparisonScope(model.eResource, object.eResource, null)
		val comparison = EMFCompare.builder.build().compare(scope)
		return comparison.getMatch(object).left
	}
	
	protected def findMatchingObjects(EObject model, Collection<EObject> objects) {
		if (objects.empty)
			throw new IllegalArgumentException
		val scope = new DefaultComparisonScope(model.eResource, objects.head.eResource, null)
		val comparison = EMFCompare.builder.build().compare(scope)
		return objects.map[object | comparison.getMatch(object).left].filterNull.toList
	}
	
	override merge(EObject source, EObject destination) {
		val scope = new DefaultComparisonScope(destination, source, null)
		val comparison = EMFCompare.builder.build().compare(scope)
		val merger = new BatchMerger(EMFCompareRCPPlugin.getDefault.mergerRegistry)
		merger.copyAllRightToLeft(comparison.differences, new BasicMonitor)
	}
	
	override apply(Notification notification, EObject destination) {
		val feature = notification.feature
		if (feature instanceof EStructuralFeature) {
			assertNot(feature instanceof EReference && (feature as EReference).isContainer)
			switch (notification.eventType) {
				case ADD: {
					assertThat(feature.isMany)
					val collection = destination.eGet(feature) as Collection<Object>
					if (feature instanceof EReference) {
						if (feature.isContainment)
							collection.add(EcoreUtil.copy(notification.newValue as EObject))
						else
							collection.add(findMatchingObject(destination, notification.newValue as EObject))
					} else
						collection.add(notification.newValue)
				}
				case ADD_MANY: {
					assertThat(feature.isMany)
					val collection = destination.eGet(feature) as Collection<Object>
					if (feature instanceof EReference) {
						if (feature.isContainment)
							collection.addAll((notification.newValue as Collection<EObject>).map[EcoreUtil.copy(it)])
						else
							collection.addAll(findMatchingObjects(destination, notification.newValue as Collection<EObject>))
					} else
						collection.addAll(notification.newValue as Collection<Object>)
				}
				case REMOVE: {
					assertThat(feature.isMany)
					val collection = destination.eGet(feature) as Collection<Object>
					if (feature instanceof EReference)
						collection.remove(findMatchingObject(destination, notification.oldValue as EObject))
					else
						collection.remove(notification.oldValue)
				}
				case REMOVE_MANY: {
					assertThat(feature.isMany)
					val collection = destination.eGet(feature) as Collection<Object>
					if (feature instanceof EReference)
						collection.removeAll(findMatchingObjects(destination, notification.oldValue as Collection<EObject>))
					else
						collection.removeAll(notification.oldValue as Collection<Object>)
				}
				case SET: {
					assertNot(feature.isMany)
					if (feature instanceof EReference) {
						if (feature.isContainment)
							destination.eSet(feature, EcoreUtil.copy(notification.newValue as EObject))
						else
							destination.eSet(feature, findMatchingObject(destination, notification.newValue as EObject))
					} else
						destination.eSet(feature, notification.newValue)
				}
				case UNSET: {
					assertNot(feature.isMany)
					destination.eUnset(feature)
				}
			}
		} else {
			throw new UnsupportedOperationException('Feature ' + feature + ' not supported.')
		}
	}
	
	private static def assertThat(boolean b) {
		if (!b) throw new AssertionError
	}
	
	private static def assertNot(boolean b) {
		assertThat(!b)
	}
	
}