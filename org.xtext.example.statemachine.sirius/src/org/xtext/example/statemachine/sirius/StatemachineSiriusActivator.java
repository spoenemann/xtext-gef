/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xtext.example.statemachine.sirius;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.sirius.business.api.componentization.ViewpointRegistry;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.osgi.framework.BundleContext;

public class StatemachineSiriusActivator extends Plugin {
	
	public static final String PLUGIN_ID = "org.xtext.example.statemachine.sirius";

	private static BundleContext context;
	
	private final Collection<Viewpoint> viewpoints = new ArrayList<Viewpoint>();

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		super.start(bundleContext);
		StatemachineSiriusActivator.context = bundleContext;
		viewpoints.addAll(ViewpointRegistry.getInstance().registerFromPlugin(PLUGIN_ID + "/model/statemachine.odesign")); 
	}

	public void stop(BundleContext bundleContext) throws Exception {
		for (Viewpoint viewpoint : viewpoints) {
			ViewpointRegistry.getInstance().disposeFromPlugin(viewpoint);
	    }
	    viewpoints.clear();
		StatemachineSiriusActivator.context = null;
		super.stop(bundleContext);
	}

}
