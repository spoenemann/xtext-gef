package org.xtext.example.statemachine.statemachine.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;
import org.xtext.example.statemachine.statemachine.State;
import org.xtext.example.statemachine.statemachine.Statemachine;
import org.xtext.example.statemachine.statemachine.StatemachinePackage;
import org.xtext.example.statemachine.statemachine.Transition;
import org.xtext.example.statemachine.statemachine.diagram.edit.parts.StateEditPart;
import org.xtext.example.statemachine.statemachine.diagram.edit.parts.StatemachineEditPart;
import org.xtext.example.statemachine.statemachine.diagram.edit.parts.TransitionEditPart;
import org.xtext.example.statemachine.statemachine.diagram.providers.StatemachineElementTypes;

/**
 * @generated
 */
public class StatemachineDiagramUpdater {

	/**
	 * @generated
	 */
	public static List<StatemachineNodeDescriptor> getSemanticChildren(View view) {
		switch (StatemachineVisualIDRegistry.getVisualID(view)) {
		case StatemachineEditPart.VISUAL_ID:
			return getStatemachine_1000SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatemachineNodeDescriptor> getStatemachine_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Statemachine modelElement = (Statemachine) view.getElement();
		LinkedList<StatemachineNodeDescriptor> result = new LinkedList<StatemachineNodeDescriptor>();
		for (Iterator<?> it = modelElement.getStates().iterator(); it.hasNext();) {
			State childElement = (State) it.next();
			int visualID = StatemachineVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == StateEditPart.VISUAL_ID) {
				result.add(new StatemachineNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachineLinkDescriptor> getContainedLinks(View view) {
		switch (StatemachineVisualIDRegistry.getVisualID(view)) {
		case StatemachineEditPart.VISUAL_ID:
			return getStatemachine_1000ContainedLinks(view);
		case StateEditPart.VISUAL_ID:
			return getState_2001ContainedLinks(view);
		case TransitionEditPart.VISUAL_ID:
			return getTransition_4001ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatemachineLinkDescriptor> getIncomingLinks(View view) {
		switch (StatemachineVisualIDRegistry.getVisualID(view)) {
		case StateEditPart.VISUAL_ID:
			return getState_2001IncomingLinks(view);
		case TransitionEditPart.VISUAL_ID:
			return getTransition_4001IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatemachineLinkDescriptor> getOutgoingLinks(View view) {
		switch (StatemachineVisualIDRegistry.getVisualID(view)) {
		case StateEditPart.VISUAL_ID:
			return getState_2001OutgoingLinks(view);
		case TransitionEditPart.VISUAL_ID:
			return getTransition_4001OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatemachineLinkDescriptor> getStatemachine_1000ContainedLinks(
			View view) {
		Statemachine modelElement = (Statemachine) view.getElement();
		LinkedList<StatemachineLinkDescriptor> result = new LinkedList<StatemachineLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachineLinkDescriptor> getState_2001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatemachineLinkDescriptor> getTransition_4001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatemachineLinkDescriptor> getState_2001IncomingLinks(
			View view) {
		State modelElement = (State) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<StatemachineLinkDescriptor> result = new LinkedList<StatemachineLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachineLinkDescriptor> getTransition_4001IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatemachineLinkDescriptor> getState_2001OutgoingLinks(
			View view) {
		State modelElement = (State) view.getElement();
		LinkedList<StatemachineLinkDescriptor> result = new LinkedList<StatemachineLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatemachineLinkDescriptor> getTransition_4001OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	private static Collection<StatemachineLinkDescriptor> getContainedTypeModelFacetLinks_Transition_4001(
			Statemachine container) {
		LinkedList<StatemachineLinkDescriptor> result = new LinkedList<StatemachineLinkDescriptor>();
		for (Iterator<?> links = container.getTransitions().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Transition) {
				continue;
			}
			Transition link = (Transition) linkObject;
			if (TransitionEditPart.VISUAL_ID != StatemachineVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			State dst = link.getTargetState();
			State src = link.getSourceState();
			result.add(new StatemachineLinkDescriptor(src, dst, link,
					StatemachineElementTypes.Transition_4001,
					TransitionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<StatemachineLinkDescriptor> getIncomingTypeModelFacetLinks_Transition_4001(
			State target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<StatemachineLinkDescriptor> result = new LinkedList<StatemachineLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != StatemachinePackage.eINSTANCE
					.getTransition_TargetState()
					|| false == setting.getEObject() instanceof Transition) {
				continue;
			}
			Transition link = (Transition) setting.getEObject();
			if (TransitionEditPart.VISUAL_ID != StatemachineVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			State src = link.getSourceState();
			result.add(new StatemachineLinkDescriptor(src, target, link,
					StatemachineElementTypes.Transition_4001,
					TransitionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<StatemachineLinkDescriptor> getOutgoingTypeModelFacetLinks_Transition_4001(
			State source) {
		Statemachine container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof Statemachine) {
				container = (Statemachine) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<StatemachineLinkDescriptor> result = new LinkedList<StatemachineLinkDescriptor>();
		for (Iterator<?> links = container.getTransitions().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Transition) {
				continue;
			}
			Transition link = (Transition) linkObject;
			if (TransitionEditPart.VISUAL_ID != StatemachineVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			State dst = link.getTargetState();
			State src = link.getSourceState();
			if (src != source) {
				continue;
			}
			result.add(new StatemachineLinkDescriptor(src, dst, link,
					StatemachineElementTypes.Transition_4001,
					TransitionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {
		/**
		 * @generated
		 */
		@Override
		public List<StatemachineNodeDescriptor> getSemanticChildren(View view) {
			return StatemachineDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<StatemachineLinkDescriptor> getContainedLinks(View view) {
			return StatemachineDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<StatemachineLinkDescriptor> getIncomingLinks(View view) {
			return StatemachineDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<StatemachineLinkDescriptor> getOutgoingLinks(View view) {
			return StatemachineDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
