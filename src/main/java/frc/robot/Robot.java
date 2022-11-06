package frc.robot;
//Api
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController; 
import com.revrobotics.CANSparkMax; 
import com.revrobotics.CANSparkMaxLowLevel.MotorType; 

public class Robot extends TimedRobot { 

  /*Class Creation
    Replace = '14' and = '15' with the designated CAN motor
  */ 
  private static final int firstStepID = 18; 
  private static final int secondStepID = 19;
  private static final int shooterID = 24;
  private static final int intakeIDtwo = 22;
  //private static final int intakeIDone = 22;



  private CANSparkMax firstStep;
  private CANSparkMax secondStep; 
  private CANSparkMax shooter;
  //private CANSparkMax intakeOne;
  private CANSparkMax intakeTwo;
  private CANSparkMax climber;


  XboxController controller = new XboxController(0);


  @Override
  public void robotInit() {
    //initialize
    firstStep = new CANSparkMax(firstStepID, MotorType.kBrushless);
    secondStep = new CANSparkMax(secondStepID, MotorType.kBrushless);
    shooter = new CANSparkMax(shooterID, MotorType.kBrushless);
    //intakeOne = new CANSparkMax(intakeIDone, MotorType.kBrushless);
    intakeTwo = new CANSparkMax(intakeIDtwo, MotorType.kBrushless);

    firstStep.restoreFactoryDefaults();
    secondStep.restoreFactoryDefaults();
    shooter.restoreFactoryDefaults();
    //intakeOne.restoreFactoryDefaults();
    intakeTwo.restoreFactoryDefaults();
    //climber.restoreFactoryDefaults();
  }

  @Override
  public void teleopPeriodic() { 
    //motor spins when trigger initiated
    if (controller.getLeftTriggerAxis() > 0.15) {
      //intakeOne.set(controller.getLeftTriggerAxis());
      intakeTwo.set(controller.getLeftTriggerAxis());
    } 
    if (controller.getRightTriggerAxis() > 0.15){
      firstStep.set(controller.getLeftTriggerAxis());
      secondStep.set(controller.getLeftTriggerAxis());
    }
    if (controller.getRightStickButton ()){
      shooter.set(-1);
    }
  }
} 