/**
 */
package org.xtext.example.statemachine.statemachine;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Property Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.statemachine.statemachine.StatePropertyExpression#getState <em>State</em>}</li>
 *   <li>{@link org.xtext.example.statemachine.statemachine.StatePropertyExpression#getProperty <em>Property</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.statemachine.statemachine.StatemachinePackage#getStatePropertyExpression()
 * @model
 * @generated
 */
public interface StatePropertyExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>State</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>State</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>State</em>' reference.
   * @see #setState(State)
   * @see org.xtext.example.statemachine.statemachine.StatemachinePackage#getStatePropertyExpression_State()
   * @model
   * @generated
   */
  State getState();

  /**
   * Sets the value of the '{@link org.xtext.example.statemachine.statemachine.StatePropertyExpression#getState <em>State</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>State</em>' reference.
   * @see #getState()
   * @generated
   */
  void setState(State value);

  /**
   * Returns the value of the '<em><b>Property</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Property</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Property</em>' attribute.
   * @see #setProperty(String)
   * @see org.xtext.example.statemachine.statemachine.StatemachinePackage#getStatePropertyExpression_Property()
   * @model
   * @generated
   */
  String getProperty();

  /**
   * Sets the value of the '{@link org.xtext.example.statemachine.statemachine.StatePropertyExpression#getProperty <em>Property</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Property</em>' attribute.
   * @see #getProperty()
   * @generated
   */
  void setProperty(String value);

} // StatePropertyExpression
