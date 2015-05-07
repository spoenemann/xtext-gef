/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xtext.xproperties

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.service.OperationCanceledManager
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.IAcceptor
import org.eclipse.xtext.util.ITextRegion
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.validation.CheckType
import org.eclipse.xtext.validation.Issue
import org.eclipse.xtext.validation.Issue.IssueImpl
import org.eclipse.xtext.validation.ResourceValidatorImpl

class EmbeddedResourceValidator extends ResourceValidatorImpl {
	
	@Inject OperationCanceledManager operationCanceledManager
	
	@Inject IModelMerger modelMerger
	
	@Accessors
	EObject originalObject
	
	@Accessors
	()=>String embeddedTextProvider
	
	@Accessors
	()=>ITextRegion visibleRegionProvider
	
	override protected validate(Resource resource, CheckMode mode, CancelIndicator monitor, IAcceptor<Issue> acceptor) {
		super.validate(resource, mode, monitor, acceptor)
		operationCanceledManager.checkCanceled(monitor)
		if (originalObject === null)
			return
		
		val visibleRegion = visibleRegionProvider.apply()
		val embeddedModel = resource.contents.head
		val matchingObject = modelMerger.findMatchingObject(embeddedModel, originalObject)
		if (matchingObject === null) {
			error('The selected element cannot be removed or renamed in this view.',
				visibleRegion.offset, visibleRegion.length, acceptor)
		} else {
			val selectedNode = NodeModelUtils.getNode(matchingObject)
			if (selectedNode !== null) {
				val embeddedText = embeddedTextProvider.apply()
				val selectedOffset = selectedNode.offset
				if (selectedOffset > visibleRegion.offset) {
					val prefix = embeddedText.substring(visibleRegion.offset, selectedOffset)
					val start = nonWhitespaceStart(prefix)
					if (start >= 0) {
						error('Only the content of the selected element may be edited in this view.',
							visibleRegion.offset + start, nonWhitespaceEnd(prefix) - start, acceptor)
					}
				}
				val selectedEndOffset = selectedOffset + selectedNode.length
				val visibleEndOffset = visibleRegion.offset + visibleRegion.length
				if (selectedEndOffset < visibleEndOffset) {
					val suffix = embeddedText.substring(selectedEndOffset, visibleEndOffset)
					val start = nonWhitespaceStart(suffix)
					if (start >= 0) {
						error('Only the content of the selected element may be edited in this view.',
							selectedEndOffset + start, nonWhitespaceEnd(suffix) - start, acceptor)
					}
				}
			}
		}
	}
	
	private def nonWhitespaceStart(String s) {
		for (var i = 0; i < s.length; i++) {
			if (!Character.isWhitespace(s.charAt(i)))
				return i
		}
		return -1
	}
	
	private def nonWhitespaceEnd(String s) {
		for (var i = s.length - 1; i >= 0; i--) {
			if (!Character.isWhitespace(s.charAt(i)))
				return i + 1
		}
		return -1
	}
	
	protected def error(String message, int offset, int length, IAcceptor<Issue> acceptor) {
		acceptor.accept(new IssueImpl => [ issue |
			issue.type = CheckType.FAST
			issue.severity = Severity.ERROR
			issue.message = message
			issue.offset = offset
			issue.length = length
		])
	}
	
}