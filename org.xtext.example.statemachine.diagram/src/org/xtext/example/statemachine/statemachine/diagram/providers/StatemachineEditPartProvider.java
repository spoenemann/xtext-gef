package org.xtext.example.statemachine.statemachine.diagram.providers;

import org.eclipse.gmf.tooling.runtime.providers.DefaultEditPartProvider;
import org.xtext.example.statemachine.statemachine.diagram.edit.parts.StatemachineEditPart;
import org.xtext.example.statemachine.statemachine.diagram.edit.parts.StatemachineEditPartFactory;
import org.xtext.example.statemachine.statemachine.diagram.part.StatemachineVisualIDRegistry;

/**
 * @generated
 */
public class StatemachineEditPartProvider extends DefaultEditPartProvider {

	/**
	 * @generated
	 */
	public StatemachineEditPartProvider() {
		super(new StatemachineEditPartFactory(),
				StatemachineVisualIDRegistry.TYPED_INSTANCE,
				StatemachineEditPart.MODEL_ID);
	}

}
