/**
 */
package org.xtext.example.statemachine.statemachine;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Verbatim Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.statemachine.statemachine.VerbatimExpression#getCode <em>Code</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.statemachine.statemachine.StatemachinePackage#getVerbatimExpression()
 * @model
 * @generated
 */
public interface VerbatimExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Code</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Code</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Code</em>' attribute.
   * @see #setCode(String)
   * @see org.xtext.example.statemachine.statemachine.StatemachinePackage#getVerbatimExpression_Code()
   * @model
   * @generated
   */
  String getCode();

  /**
   * Sets the value of the '{@link org.xtext.example.statemachine.statemachine.VerbatimExpression#getCode <em>Code</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Code</em>' attribute.
   * @see #getCode()
   * @generated
   */
  void setCode(String value);

} // VerbatimExpression
