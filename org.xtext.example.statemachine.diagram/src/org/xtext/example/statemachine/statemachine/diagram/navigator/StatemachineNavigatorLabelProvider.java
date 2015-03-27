package org.xtext.example.statemachine.statemachine.diagram.navigator;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;
import org.xtext.example.statemachine.statemachine.diagram.edit.parts.StateEditPart;
import org.xtext.example.statemachine.statemachine.diagram.edit.parts.StateNameEditPart;
import org.xtext.example.statemachine.statemachine.diagram.edit.parts.StatemachineEditPart;
import org.xtext.example.statemachine.statemachine.diagram.edit.parts.TransitionEditPart;
import org.xtext.example.statemachine.statemachine.diagram.part.StatemachineDiagramEditorPlugin;
import org.xtext.example.statemachine.statemachine.diagram.part.StatemachineVisualIDRegistry;
import org.xtext.example.statemachine.statemachine.diagram.providers.StatemachineElementTypes;
import org.xtext.example.statemachine.statemachine.diagram.providers.StatemachineParserProvider;

/**
 * @generated
 */
public class StatemachineNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		StatemachineDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		StatemachineDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof StatemachineNavigatorItem
				&& !isOwnView(((StatemachineNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof StatemachineNavigatorGroup) {
			StatemachineNavigatorGroup group = (StatemachineNavigatorGroup) element;
			return StatemachineDiagramEditorPlugin.getInstance()
					.getBundledImage(group.getIcon());
		}

		if (element instanceof StatemachineNavigatorItem) {
			StatemachineNavigatorItem navigatorItem = (StatemachineNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (StatemachineVisualIDRegistry.getVisualID(view)) {
		case StatemachineEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://xtext.org/example/Statemachine?Statemachine", StatemachineElementTypes.Statemachine_1000); //$NON-NLS-1$
		case StateEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://xtext.org/example/Statemachine?State", StatemachineElementTypes.State_2001); //$NON-NLS-1$
		case TransitionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://xtext.org/example/Statemachine?Transition", StatemachineElementTypes.Transition_4001); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = StatemachineDiagramEditorPlugin
				.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& StatemachineElementTypes.isKnownElementType(elementType)) {
			image = StatemachineElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (element instanceof StatemachineNavigatorGroup) {
			StatemachineNavigatorGroup group = (StatemachineNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof StatemachineNavigatorItem) {
			StatemachineNavigatorItem navigatorItem = (StatemachineNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (StatemachineVisualIDRegistry.getVisualID(view)) {
		case StatemachineEditPart.VISUAL_ID:
			return getStatemachine_1000Text(view);
		case StateEditPart.VISUAL_ID:
			return getState_2001Text(view);
		case TransitionEditPart.VISUAL_ID:
			return getTransition_4001Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getStatemachine_1000Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getState_2001Text(View view) {
		IParser parser = StatemachineParserProvider.getParser(
				StatemachineElementTypes.State_2001,
				view.getElement() != null ? view.getElement() : view,
				StatemachineVisualIDRegistry
						.getType(StateNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			StatemachineDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getTransition_4001Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return StatemachineEditPart.MODEL_ID
				.equals(StatemachineVisualIDRegistry.getModelID(view));
	}

}
