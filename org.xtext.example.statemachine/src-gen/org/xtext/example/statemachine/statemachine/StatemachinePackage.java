/**
 */
package org.xtext.example.statemachine.statemachine;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.xtext.example.statemachine.statemachine.StatemachineFactory
 * @model kind="package"
 * @generated
 */
public interface StatemachinePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "statemachine";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://xtext.org/example/Statemachine";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "statemachine";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  StatemachinePackage eINSTANCE = org.xtext.example.statemachine.statemachine.impl.StatemachinePackageImpl.init();

  /**
   * The meta object id for the '{@link org.xtext.example.statemachine.statemachine.impl.StatemachineImpl <em>Statemachine</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.statemachine.statemachine.impl.StatemachineImpl
   * @see org.xtext.example.statemachine.statemachine.impl.StatemachinePackageImpl#getStatemachine()
   * @generated
   */
  int STATEMACHINE = 0;

  /**
   * The feature id for the '<em><b>States</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMACHINE__STATES = 0;

  /**
   * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMACHINE__TRANSITIONS = 1;

  /**
   * The number of structural features of the '<em>Statemachine</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMACHINE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.xtext.example.statemachine.statemachine.impl.StateImpl <em>State</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.statemachine.statemachine.impl.StateImpl
   * @see org.xtext.example.statemachine.statemachine.impl.StatemachinePackageImpl#getState()
   * @generated
   */
  int STATE = 1;

  /**
   * The feature id for the '<em><b>Initial</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__INITIAL = 0;

  /**
   * The feature id for the '<em><b>Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__FINAL = 1;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__ID = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__NAME = 3;

  /**
   * The feature id for the '<em><b>Actions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__ACTIONS = 4;

  /**
   * The number of structural features of the '<em>State</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link org.xtext.example.statemachine.statemachine.impl.TransitionImpl <em>Transition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.statemachine.statemachine.impl.TransitionImpl
   * @see org.xtext.example.statemachine.statemachine.impl.StatemachinePackageImpl#getTransition()
   * @generated
   */
  int TRANSITION = 2;

  /**
   * The feature id for the '<em><b>Source State</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__SOURCE_STATE = 0;

  /**
   * The feature id for the '<em><b>Target State</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__TARGET_STATE = 1;

  /**
   * The feature id for the '<em><b>Event</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__EVENT = 2;

  /**
   * The number of structural features of the '<em>Transition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.xtext.example.statemachine.statemachine.impl.CommandImpl <em>Command</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.statemachine.statemachine.impl.CommandImpl
   * @see org.xtext.example.statemachine.statemachine.impl.StatemachinePackageImpl#getCommand()
   * @generated
   */
  int COMMAND = 3;

  /**
   * The number of structural features of the '<em>Command</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMAND_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.xtext.example.statemachine.statemachine.impl.SetCommandImpl <em>Set Command</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.statemachine.statemachine.impl.SetCommandImpl
   * @see org.xtext.example.statemachine.statemachine.impl.StatemachinePackageImpl#getSetCommand()
   * @generated
   */
  int SET_COMMAND = 4;

  /**
   * The feature id for the '<em><b>Signal</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET_COMMAND__SIGNAL = COMMAND_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET_COMMAND__VALUE = COMMAND_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Set Command</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET_COMMAND_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.xtext.example.statemachine.statemachine.impl.ExecuteCommandImpl <em>Execute Command</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.statemachine.statemachine.impl.ExecuteCommandImpl
   * @see org.xtext.example.statemachine.statemachine.impl.StatemachinePackageImpl#getExecuteCommand()
   * @generated
   */
  int EXECUTE_COMMAND = 5;

  /**
   * The feature id for the '<em><b>Operation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXECUTE_COMMAND__OPERATION = COMMAND_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXECUTE_COMMAND__ARGUMENTS = COMMAND_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Execute Command</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXECUTE_COMMAND_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.xtext.example.statemachine.statemachine.impl.PrintCommandImpl <em>Print Command</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.statemachine.statemachine.impl.PrintCommandImpl
   * @see org.xtext.example.statemachine.statemachine.impl.StatemachinePackageImpl#getPrintCommand()
   * @generated
   */
  int PRINT_COMMAND = 6;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRINT_COMMAND__VALUE = COMMAND_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Print Command</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRINT_COMMAND_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.xtext.example.statemachine.statemachine.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.statemachine.statemachine.impl.ExpressionImpl
   * @see org.xtext.example.statemachine.statemachine.impl.StatemachinePackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 7;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.xtext.example.statemachine.statemachine.impl.VerbatimExpressionImpl <em>Verbatim Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.statemachine.statemachine.impl.VerbatimExpressionImpl
   * @see org.xtext.example.statemachine.statemachine.impl.StatemachinePackageImpl#getVerbatimExpression()
   * @generated
   */
  int VERBATIM_EXPRESSION = 8;

  /**
   * The feature id for the '<em><b>Code</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERBATIM_EXPRESSION__CODE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Verbatim Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERBATIM_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.xtext.example.statemachine.statemachine.impl.StatePropertyExpressionImpl <em>State Property Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.statemachine.statemachine.impl.StatePropertyExpressionImpl
   * @see org.xtext.example.statemachine.statemachine.impl.StatemachinePackageImpl#getStatePropertyExpression()
   * @generated
   */
  int STATE_PROPERTY_EXPRESSION = 9;

  /**
   * The feature id for the '<em><b>State</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_PROPERTY_EXPRESSION__STATE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Property</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_PROPERTY_EXPRESSION__PROPERTY = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>State Property Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_PROPERTY_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;


  /**
   * Returns the meta object for class '{@link org.xtext.example.statemachine.statemachine.Statemachine <em>Statemachine</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Statemachine</em>'.
   * @see org.xtext.example.statemachine.statemachine.Statemachine
   * @generated
   */
  EClass getStatemachine();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.example.statemachine.statemachine.Statemachine#getStates <em>States</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>States</em>'.
   * @see org.xtext.example.statemachine.statemachine.Statemachine#getStates()
   * @see #getStatemachine()
   * @generated
   */
  EReference getStatemachine_States();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.example.statemachine.statemachine.Statemachine#getTransitions <em>Transitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Transitions</em>'.
   * @see org.xtext.example.statemachine.statemachine.Statemachine#getTransitions()
   * @see #getStatemachine()
   * @generated
   */
  EReference getStatemachine_Transitions();

  /**
   * Returns the meta object for class '{@link org.xtext.example.statemachine.statemachine.State <em>State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State</em>'.
   * @see org.xtext.example.statemachine.statemachine.State
   * @generated
   */
  EClass getState();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.example.statemachine.statemachine.State#isInitial <em>Initial</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Initial</em>'.
   * @see org.xtext.example.statemachine.statemachine.State#isInitial()
   * @see #getState()
   * @generated
   */
  EAttribute getState_Initial();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.example.statemachine.statemachine.State#isFinal <em>Final</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Final</em>'.
   * @see org.xtext.example.statemachine.statemachine.State#isFinal()
   * @see #getState()
   * @generated
   */
  EAttribute getState_Final();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.example.statemachine.statemachine.State#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see org.xtext.example.statemachine.statemachine.State#getId()
   * @see #getState()
   * @generated
   */
  EAttribute getState_Id();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.example.statemachine.statemachine.State#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.xtext.example.statemachine.statemachine.State#getName()
   * @see #getState()
   * @generated
   */
  EAttribute getState_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.example.statemachine.statemachine.State#getActions <em>Actions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Actions</em>'.
   * @see org.xtext.example.statemachine.statemachine.State#getActions()
   * @see #getState()
   * @generated
   */
  EReference getState_Actions();

  /**
   * Returns the meta object for class '{@link org.xtext.example.statemachine.statemachine.Transition <em>Transition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transition</em>'.
   * @see org.xtext.example.statemachine.statemachine.Transition
   * @generated
   */
  EClass getTransition();

  /**
   * Returns the meta object for the reference '{@link org.xtext.example.statemachine.statemachine.Transition#getSourceState <em>Source State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Source State</em>'.
   * @see org.xtext.example.statemachine.statemachine.Transition#getSourceState()
   * @see #getTransition()
   * @generated
   */
  EReference getTransition_SourceState();

  /**
   * Returns the meta object for the reference '{@link org.xtext.example.statemachine.statemachine.Transition#getTargetState <em>Target State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target State</em>'.
   * @see org.xtext.example.statemachine.statemachine.Transition#getTargetState()
   * @see #getTransition()
   * @generated
   */
  EReference getTransition_TargetState();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.statemachine.statemachine.Transition#getEvent <em>Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Event</em>'.
   * @see org.xtext.example.statemachine.statemachine.Transition#getEvent()
   * @see #getTransition()
   * @generated
   */
  EReference getTransition_Event();

  /**
   * Returns the meta object for class '{@link org.xtext.example.statemachine.statemachine.Command <em>Command</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Command</em>'.
   * @see org.xtext.example.statemachine.statemachine.Command
   * @generated
   */
  EClass getCommand();

  /**
   * Returns the meta object for class '{@link org.xtext.example.statemachine.statemachine.SetCommand <em>Set Command</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Set Command</em>'.
   * @see org.xtext.example.statemachine.statemachine.SetCommand
   * @generated
   */
  EClass getSetCommand();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.example.statemachine.statemachine.SetCommand#getSignal <em>Signal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Signal</em>'.
   * @see org.xtext.example.statemachine.statemachine.SetCommand#getSignal()
   * @see #getSetCommand()
   * @generated
   */
  EAttribute getSetCommand_Signal();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.statemachine.statemachine.SetCommand#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.xtext.example.statemachine.statemachine.SetCommand#getValue()
   * @see #getSetCommand()
   * @generated
   */
  EReference getSetCommand_Value();

  /**
   * Returns the meta object for class '{@link org.xtext.example.statemachine.statemachine.ExecuteCommand <em>Execute Command</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Execute Command</em>'.
   * @see org.xtext.example.statemachine.statemachine.ExecuteCommand
   * @generated
   */
  EClass getExecuteCommand();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.example.statemachine.statemachine.ExecuteCommand#getOperation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operation</em>'.
   * @see org.xtext.example.statemachine.statemachine.ExecuteCommand#getOperation()
   * @see #getExecuteCommand()
   * @generated
   */
  EAttribute getExecuteCommand_Operation();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.example.statemachine.statemachine.ExecuteCommand#getArguments <em>Arguments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Arguments</em>'.
   * @see org.xtext.example.statemachine.statemachine.ExecuteCommand#getArguments()
   * @see #getExecuteCommand()
   * @generated
   */
  EReference getExecuteCommand_Arguments();

  /**
   * Returns the meta object for class '{@link org.xtext.example.statemachine.statemachine.PrintCommand <em>Print Command</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Print Command</em>'.
   * @see org.xtext.example.statemachine.statemachine.PrintCommand
   * @generated
   */
  EClass getPrintCommand();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.statemachine.statemachine.PrintCommand#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.xtext.example.statemachine.statemachine.PrintCommand#getValue()
   * @see #getPrintCommand()
   * @generated
   */
  EReference getPrintCommand_Value();

  /**
   * Returns the meta object for class '{@link org.xtext.example.statemachine.statemachine.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see org.xtext.example.statemachine.statemachine.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for class '{@link org.xtext.example.statemachine.statemachine.VerbatimExpression <em>Verbatim Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Verbatim Expression</em>'.
   * @see org.xtext.example.statemachine.statemachine.VerbatimExpression
   * @generated
   */
  EClass getVerbatimExpression();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.example.statemachine.statemachine.VerbatimExpression#getCode <em>Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Code</em>'.
   * @see org.xtext.example.statemachine.statemachine.VerbatimExpression#getCode()
   * @see #getVerbatimExpression()
   * @generated
   */
  EAttribute getVerbatimExpression_Code();

  /**
   * Returns the meta object for class '{@link org.xtext.example.statemachine.statemachine.StatePropertyExpression <em>State Property Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State Property Expression</em>'.
   * @see org.xtext.example.statemachine.statemachine.StatePropertyExpression
   * @generated
   */
  EClass getStatePropertyExpression();

  /**
   * Returns the meta object for the reference '{@link org.xtext.example.statemachine.statemachine.StatePropertyExpression#getState <em>State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>State</em>'.
   * @see org.xtext.example.statemachine.statemachine.StatePropertyExpression#getState()
   * @see #getStatePropertyExpression()
   * @generated
   */
  EReference getStatePropertyExpression_State();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.example.statemachine.statemachine.StatePropertyExpression#getProperty <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Property</em>'.
   * @see org.xtext.example.statemachine.statemachine.StatePropertyExpression#getProperty()
   * @see #getStatePropertyExpression()
   * @generated
   */
  EAttribute getStatePropertyExpression_Property();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  StatemachineFactory getStatemachineFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.xtext.example.statemachine.statemachine.impl.StatemachineImpl <em>Statemachine</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.statemachine.statemachine.impl.StatemachineImpl
     * @see org.xtext.example.statemachine.statemachine.impl.StatemachinePackageImpl#getStatemachine()
     * @generated
     */
    EClass STATEMACHINE = eINSTANCE.getStatemachine();

    /**
     * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMACHINE__STATES = eINSTANCE.getStatemachine_States();

    /**
     * The meta object literal for the '<em><b>Transitions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMACHINE__TRANSITIONS = eINSTANCE.getStatemachine_Transitions();

    /**
     * The meta object literal for the '{@link org.xtext.example.statemachine.statemachine.impl.StateImpl <em>State</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.statemachine.statemachine.impl.StateImpl
     * @see org.xtext.example.statemachine.statemachine.impl.StatemachinePackageImpl#getState()
     * @generated
     */
    EClass STATE = eINSTANCE.getState();

    /**
     * The meta object literal for the '<em><b>Initial</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATE__INITIAL = eINSTANCE.getState_Initial();

    /**
     * The meta object literal for the '<em><b>Final</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATE__FINAL = eINSTANCE.getState_Final();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATE__ID = eINSTANCE.getState_Id();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATE__NAME = eINSTANCE.getState_Name();

    /**
     * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE__ACTIONS = eINSTANCE.getState_Actions();

    /**
     * The meta object literal for the '{@link org.xtext.example.statemachine.statemachine.impl.TransitionImpl <em>Transition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.statemachine.statemachine.impl.TransitionImpl
     * @see org.xtext.example.statemachine.statemachine.impl.StatemachinePackageImpl#getTransition()
     * @generated
     */
    EClass TRANSITION = eINSTANCE.getTransition();

    /**
     * The meta object literal for the '<em><b>Source State</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION__SOURCE_STATE = eINSTANCE.getTransition_SourceState();

    /**
     * The meta object literal for the '<em><b>Target State</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION__TARGET_STATE = eINSTANCE.getTransition_TargetState();

    /**
     * The meta object literal for the '<em><b>Event</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION__EVENT = eINSTANCE.getTransition_Event();

    /**
     * The meta object literal for the '{@link org.xtext.example.statemachine.statemachine.impl.CommandImpl <em>Command</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.statemachine.statemachine.impl.CommandImpl
     * @see org.xtext.example.statemachine.statemachine.impl.StatemachinePackageImpl#getCommand()
     * @generated
     */
    EClass COMMAND = eINSTANCE.getCommand();

    /**
     * The meta object literal for the '{@link org.xtext.example.statemachine.statemachine.impl.SetCommandImpl <em>Set Command</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.statemachine.statemachine.impl.SetCommandImpl
     * @see org.xtext.example.statemachine.statemachine.impl.StatemachinePackageImpl#getSetCommand()
     * @generated
     */
    EClass SET_COMMAND = eINSTANCE.getSetCommand();

    /**
     * The meta object literal for the '<em><b>Signal</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SET_COMMAND__SIGNAL = eINSTANCE.getSetCommand_Signal();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SET_COMMAND__VALUE = eINSTANCE.getSetCommand_Value();

    /**
     * The meta object literal for the '{@link org.xtext.example.statemachine.statemachine.impl.ExecuteCommandImpl <em>Execute Command</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.statemachine.statemachine.impl.ExecuteCommandImpl
     * @see org.xtext.example.statemachine.statemachine.impl.StatemachinePackageImpl#getExecuteCommand()
     * @generated
     */
    EClass EXECUTE_COMMAND = eINSTANCE.getExecuteCommand();

    /**
     * The meta object literal for the '<em><b>Operation</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXECUTE_COMMAND__OPERATION = eINSTANCE.getExecuteCommand_Operation();

    /**
     * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXECUTE_COMMAND__ARGUMENTS = eINSTANCE.getExecuteCommand_Arguments();

    /**
     * The meta object literal for the '{@link org.xtext.example.statemachine.statemachine.impl.PrintCommandImpl <em>Print Command</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.statemachine.statemachine.impl.PrintCommandImpl
     * @see org.xtext.example.statemachine.statemachine.impl.StatemachinePackageImpl#getPrintCommand()
     * @generated
     */
    EClass PRINT_COMMAND = eINSTANCE.getPrintCommand();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRINT_COMMAND__VALUE = eINSTANCE.getPrintCommand_Value();

    /**
     * The meta object literal for the '{@link org.xtext.example.statemachine.statemachine.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.statemachine.statemachine.impl.ExpressionImpl
     * @see org.xtext.example.statemachine.statemachine.impl.StatemachinePackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '{@link org.xtext.example.statemachine.statemachine.impl.VerbatimExpressionImpl <em>Verbatim Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.statemachine.statemachine.impl.VerbatimExpressionImpl
     * @see org.xtext.example.statemachine.statemachine.impl.StatemachinePackageImpl#getVerbatimExpression()
     * @generated
     */
    EClass VERBATIM_EXPRESSION = eINSTANCE.getVerbatimExpression();

    /**
     * The meta object literal for the '<em><b>Code</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERBATIM_EXPRESSION__CODE = eINSTANCE.getVerbatimExpression_Code();

    /**
     * The meta object literal for the '{@link org.xtext.example.statemachine.statemachine.impl.StatePropertyExpressionImpl <em>State Property Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.statemachine.statemachine.impl.StatePropertyExpressionImpl
     * @see org.xtext.example.statemachine.statemachine.impl.StatemachinePackageImpl#getStatePropertyExpression()
     * @generated
     */
    EClass STATE_PROPERTY_EXPRESSION = eINSTANCE.getStatePropertyExpression();

    /**
     * The meta object literal for the '<em><b>State</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE_PROPERTY_EXPRESSION__STATE = eINSTANCE.getStatePropertyExpression_State();

    /**
     * The meta object literal for the '<em><b>Property</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATE_PROPERTY_EXPRESSION__PROPERTY = eINSTANCE.getStatePropertyExpression_Property();

  }

} //StatemachinePackage
