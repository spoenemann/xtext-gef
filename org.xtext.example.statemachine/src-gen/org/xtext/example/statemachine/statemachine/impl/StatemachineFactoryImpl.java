/**
 */
package org.xtext.example.statemachine.statemachine.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.xtext.example.statemachine.statemachine.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StatemachineFactoryImpl extends EFactoryImpl implements StatemachineFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static StatemachineFactory init()
  {
    try
    {
      StatemachineFactory theStatemachineFactory = (StatemachineFactory)EPackage.Registry.INSTANCE.getEFactory(StatemachinePackage.eNS_URI);
      if (theStatemachineFactory != null)
      {
        return theStatemachineFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new StatemachineFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StatemachineFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case StatemachinePackage.STATEMACHINE: return createStatemachine();
      case StatemachinePackage.STATE: return createState();
      case StatemachinePackage.TRANSITION: return createTransition();
      case StatemachinePackage.COMMAND: return createCommand();
      case StatemachinePackage.SET_COMMAND: return createSetCommand();
      case StatemachinePackage.EXECUTE_COMMAND: return createExecuteCommand();
      case StatemachinePackage.PRINT_COMMAND: return createPrintCommand();
      case StatemachinePackage.EXPRESSION: return createExpression();
      case StatemachinePackage.VERBATIM_EXPRESSION: return createVerbatimExpression();
      case StatemachinePackage.STATE_PROPERTY_EXPRESSION: return createStatePropertyExpression();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Statemachine createStatemachine()
  {
    StatemachineImpl statemachine = new StatemachineImpl();
    return statemachine;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public State createState()
  {
    StateImpl state = new StateImpl();
    return state;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Transition createTransition()
  {
    TransitionImpl transition = new TransitionImpl();
    return transition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Command createCommand()
  {
    CommandImpl command = new CommandImpl();
    return command;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SetCommand createSetCommand()
  {
    SetCommandImpl setCommand = new SetCommandImpl();
    return setCommand;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExecuteCommand createExecuteCommand()
  {
    ExecuteCommandImpl executeCommand = new ExecuteCommandImpl();
    return executeCommand;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrintCommand createPrintCommand()
  {
    PrintCommandImpl printCommand = new PrintCommandImpl();
    return printCommand;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression createExpression()
  {
    ExpressionImpl expression = new ExpressionImpl();
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerbatimExpression createVerbatimExpression()
  {
    VerbatimExpressionImpl verbatimExpression = new VerbatimExpressionImpl();
    return verbatimExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StatePropertyExpression createStatePropertyExpression()
  {
    StatePropertyExpressionImpl statePropertyExpression = new StatePropertyExpressionImpl();
    return statePropertyExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StatemachinePackage getStatemachinePackage()
  {
    return (StatemachinePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static StatemachinePackage getPackage()
  {
    return StatemachinePackage.eINSTANCE;
  }

} //StatemachineFactoryImpl
