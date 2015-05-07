/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xtext.example.statemachine.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.xtext.example.statemachine.ui.properties.StatemachineModelMerger;
import org.xtext.xproperties.IModelMerger;

/**
 * Use this class to register components to be used within the IDE.
 */
public class StatemachineUiModule extends AbstractStatemachineUiModule {
	
	public StatemachineUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	public Class<? extends IModelMerger> bindIModelMerger() {
		return StatemachineModelMerger.class;
	}
	
}
