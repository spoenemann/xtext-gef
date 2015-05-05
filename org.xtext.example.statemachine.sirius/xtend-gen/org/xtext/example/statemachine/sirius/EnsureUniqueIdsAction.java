/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.xtext.example.statemachine.sirius;

import java.util.Collection;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.xtext.example.statemachine.StatemachineUtil;
import org.xtext.example.statemachine.statemachine.Statemachine;

@SuppressWarnings("all")
public class EnsureUniqueIdsAction implements IExternalJavaAction {
  @Override
  public boolean canExecute(final Collection<? extends EObject> selection) {
    final Function1<EObject, Boolean> _function = new Function1<EObject, Boolean>() {
      @Override
      public Boolean apply(final EObject it) {
        return Boolean.valueOf((it instanceof Statemachine));
      }
    };
    return IterableExtensions.exists(selection, _function);
  }
  
  @Override
  public void execute(final Collection<? extends EObject> selection, final Map<String, Object> parameters) {
    final Function1<EObject, Boolean> _function = new Function1<EObject, Boolean>() {
      @Override
      public Boolean apply(final EObject it) {
        return Boolean.valueOf((it instanceof Statemachine));
      }
    };
    final EObject statemachine = IterableExtensions.findFirst(selection, _function);
    if ((statemachine != null)) {
      Resource _eResource = statemachine.eResource();
      StatemachineUtil.ensureUniqueIds(_eResource);
    }
  }
}
