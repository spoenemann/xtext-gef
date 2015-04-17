/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xtext.example.statemachine;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.serializer.impl.Serializer;

import com.google.inject.Inject;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class StatemachineRuntimeModule extends AbstractStatemachineRuntimeModule {
	
	@Override
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return StatemachineQualifiedNameProvider.class;
	}
	
	@Override
	public Class<? extends ISerializer> bindISerializer() {
		return MySerializer.class;
	}
	
	static class MySerializer extends Serializer {
		@Override
		public void serialize(EObject obj, Writer writer, SaveOptions options) throws IOException {
			serialize(obj, (Appendable) writer, options);
			writer.flush();
		}
	}
	
}
