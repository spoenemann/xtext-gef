/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xtext.example.statemachine.ui.views

import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider

class EditedResourceProvider implements IEditedResourceProvider {
	
	@Accessors(PUBLIC_GETTER)
	XtextResource resource
	
	override createResource() {
		val resourceSet = new XtextResourceSet
		val uri = URI.createURI("embeddedResource.statemachine")
		resource = resourceSet.createResource(uri) as XtextResource
		return resource
	}
	
}
