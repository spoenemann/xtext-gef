/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.xtext.example.statemachine.graphiti;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.xtext.example.statemachine.graphiti.StatemachineFeatureProvider;

@SuppressWarnings("all")
public class StatemachineDiagramTypeProvider extends AbstractDiagramTypeProvider {
  public StatemachineDiagramTypeProvider() {
    StatemachineFeatureProvider _statemachineFeatureProvider = new StatemachineFeatureProvider(this);
    this.setFeatureProvider(_statemachineFeatureProvider);
  }
  
  @Override
  public boolean isAutoUpdateAtStartup() {
    return true;
  }
  
  @Override
  public boolean isAutoUpdateAtRuntime() {
    return true;
  }
  
  @Override
  public boolean isAutoUpdateAtReset() {
    return true;
  }
}
