/**
 */
package org.xtext.example.statemachine.statemachine;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execute Command</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.statemachine.statemachine.ExecuteCommand#getOperation <em>Operation</em>}</li>
 *   <li>{@link org.xtext.example.statemachine.statemachine.ExecuteCommand#getArguments <em>Arguments</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.statemachine.statemachine.StatemachinePackage#getExecuteCommand()
 * @model
 * @generated
 */
public interface ExecuteCommand extends Command
{
  /**
   * Returns the value of the '<em><b>Operation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operation</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operation</em>' attribute.
   * @see #setOperation(String)
   * @see org.xtext.example.statemachine.statemachine.StatemachinePackage#getExecuteCommand_Operation()
   * @model
   * @generated
   */
  String getOperation();

  /**
   * Sets the value of the '{@link org.xtext.example.statemachine.statemachine.ExecuteCommand#getOperation <em>Operation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operation</em>' attribute.
   * @see #getOperation()
   * @generated
   */
  void setOperation(String value);

  /**
   * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.example.statemachine.statemachine.Expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Arguments</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Arguments</em>' containment reference list.
   * @see org.xtext.example.statemachine.statemachine.StatemachinePackage#getExecuteCommand_Arguments()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getArguments();

} // ExecuteCommand
