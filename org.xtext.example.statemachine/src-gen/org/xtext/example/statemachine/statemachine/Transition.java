/**
 */
package org.xtext.example.statemachine.statemachine;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.statemachine.statemachine.Transition#getSourceState <em>Source State</em>}</li>
 *   <li>{@link org.xtext.example.statemachine.statemachine.Transition#getTargetState <em>Target State</em>}</li>
 *   <li>{@link org.xtext.example.statemachine.statemachine.Transition#getEvent <em>Event</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.statemachine.statemachine.StatemachinePackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends EObject
{
  /**
   * Returns the value of the '<em><b>Source State</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Source State</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source State</em>' reference.
   * @see #setSourceState(State)
   * @see org.xtext.example.statemachine.statemachine.StatemachinePackage#getTransition_SourceState()
   * @model
   * @generated
   */
  State getSourceState();

  /**
   * Sets the value of the '{@link org.xtext.example.statemachine.statemachine.Transition#getSourceState <em>Source State</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source State</em>' reference.
   * @see #getSourceState()
   * @generated
   */
  void setSourceState(State value);

  /**
   * Returns the value of the '<em><b>Target State</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target State</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target State</em>' reference.
   * @see #setTargetState(State)
   * @see org.xtext.example.statemachine.statemachine.StatemachinePackage#getTransition_TargetState()
   * @model
   * @generated
   */
  State getTargetState();

  /**
   * Sets the value of the '{@link org.xtext.example.statemachine.statemachine.Transition#getTargetState <em>Target State</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target State</em>' reference.
   * @see #getTargetState()
   * @generated
   */
  void setTargetState(State value);

  /**
   * Returns the value of the '<em><b>Event</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Event</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Event</em>' containment reference.
   * @see #setEvent(Expression)
   * @see org.xtext.example.statemachine.statemachine.StatemachinePackage#getTransition_Event()
   * @model containment="true"
   * @generated
   */
  Expression getEvent();

  /**
   * Sets the value of the '{@link org.xtext.example.statemachine.statemachine.Transition#getEvent <em>Event</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Event</em>' containment reference.
   * @see #getEvent()
   * @generated
   */
  void setEvent(Expression value);

} // Transition
