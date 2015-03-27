package org.xtext.example.statemachine.statemachine.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;
import org.xtext.example.statemachine.statemachine.diagram.part.StatemachineVisualIDRegistry;

/**
 * @generated
 */
public class StatemachineNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 4003;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof StatemachineNavigatorItem) {
			StatemachineNavigatorItem item = (StatemachineNavigatorItem) element;
			return StatemachineVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
