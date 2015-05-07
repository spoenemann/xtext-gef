/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.xtext.example.statemachine.graphiti;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.PictogramLink;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.graphiti.ui.internal.parts.IPictogramElementEditPart;
import org.eclipse.graphiti.ui.platform.IConfigurationProvider;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.xtext.example.statemachine.graphiti.StatemachineFeatureProvider;
import org.xtext.example.statemachine.statemachine.State;
import org.xtext.xproperties.FrameworkAdapters;

@SuppressWarnings("all")
public class StatemachineDiagramTypeProvider extends AbstractDiagramTypeProvider {
  public static class GraphitiFrameworkAdapter implements FrameworkAdapters.IAdapter {
    @Override
    public boolean appliesTo(final Object element) {
      boolean _and = false;
      if (!(element instanceof IPictogramElementEditPart)) {
        _and = false;
      } else {
        EObject _model = this.getModel(element);
        _and = (_model instanceof State);
      }
      return _and;
    }
    
    @Override
    public EObject getModel(final Object element) {
      PictogramElement _pictogramElement = ((IPictogramElementEditPart) element).getPictogramElement();
      PictogramLink _link = _pictogramElement.getLink();
      EList<EObject> _businessObjects = _link.getBusinessObjects();
      return IterableExtensions.<EObject>head(_businessObjects);
    }
    
    @Override
    public TransactionalEditingDomain getEditingDomain(final Object element) {
      IConfigurationProvider _configurationProvider = ((IPictogramElementEditPart) element).getConfigurationProvider();
      DiagramBehavior _diagramBehavior = _configurationProvider.getDiagramBehavior();
      return _diagramBehavior.getEditingDomain();
    }
  }
  
  public StatemachineDiagramTypeProvider() {
    StatemachineFeatureProvider _statemachineFeatureProvider = new StatemachineFeatureProvider(this);
    this.setFeatureProvider(_statemachineFeatureProvider);
    StatemachineDiagramTypeProvider.GraphitiFrameworkAdapter _graphitiFrameworkAdapter = new StatemachineDiagramTypeProvider.GraphitiFrameworkAdapter();
    FrameworkAdapters.addAdapter(_graphitiFrameworkAdapter);
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
