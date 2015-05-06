/**
 */
package org.xtext.example.statemachine.statemachine;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Command</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.statemachine.statemachine.SetCommand#getSignal <em>Signal</em>}</li>
 *   <li>{@link org.xtext.example.statemachine.statemachine.SetCommand#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.statemachine.statemachine.StatemachinePackage#getSetCommand()
 * @model
 * @generated
 */
public interface SetCommand extends Command
{
  /**
   * Returns the value of the '<em><b>Signal</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Signal</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Signal</em>' attribute.
   * @see #setSignal(String)
   * @see org.xtext.example.statemachine.statemachine.StatemachinePackage#getSetCommand_Signal()
   * @model
   * @generated
   */
  String getSignal();

  /**
   * Sets the value of the '{@link org.xtext.example.statemachine.statemachine.SetCommand#getSignal <em>Signal</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Signal</em>' attribute.
   * @see #getSignal()
   * @generated
   */
  void setSignal(String value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(Expression)
   * @see org.xtext.example.statemachine.statemachine.StatemachinePackage#getSetCommand_Value()
   * @model containment="true"
   * @generated
   */
  Expression getValue();

  /**
   * Sets the value of the '{@link org.xtext.example.statemachine.statemachine.SetCommand#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(Expression value);

} // SetCommand
