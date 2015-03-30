/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.xtext.example.statemachine;

import com.google.inject.Inject;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.xtext.example.statemachine.statemachine.State;

@SuppressWarnings("all")
public class StatemachineQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {
  @Inject
  private IQualifiedNameConverter converter;
  
  public QualifiedName qualifiedName(final State state) {
    String _id = state.getId();
    return this.converter.toQualifiedName(_id);
  }
}
