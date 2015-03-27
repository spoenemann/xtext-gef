package org.xtext.example.statemachine.statemachine.diagram.providers;

import org.xtext.example.statemachine.statemachine.diagram.part.StatemachineDiagramEditorPlugin;

/**
 * @generated
 */
public class ElementInitializers {

	protected ElementInitializers() {
		// use #getInstance to access cached instance
	}

	/**
	 * @generated
	 */
	public static ElementInitializers getInstance() {
		ElementInitializers cached = StatemachineDiagramEditorPlugin
				.getInstance().getElementInitializers();
		if (cached == null) {
			StatemachineDiagramEditorPlugin.getInstance()
					.setElementInitializers(cached = new ElementInitializers());
		}
		return cached;
	}
}
