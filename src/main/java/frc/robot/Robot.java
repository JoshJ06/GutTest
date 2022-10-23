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
  private static final int firstStepID = 15; 
  private static final int secondStepID = 15;
  private static final int shooterID = 15;

  private CANSparkMax firstStep;
  private CANSparkMax secondStep; 
  private CANSparkMax shooter;
  XboxController controller = new XboxController(0);


  @Override
  public void robotInit() {
    //initialize
    firstStep = new CANSparkMax(firstStepID, MotorType.kBrushless);
    secondStep = new CANSparkMax(secondStepID, MotorType.kBrushless);
    shooter = new CANSparkMax(shooterID, MotorType.kBrushless);

    firstStep.restoreFactoryDefaults();
    secondStep.restoreFactoryDefaults();
    shooter.restoreFactoryDefaults();
  }

  @Override
  public void teleopPeriodic() { 
    //motor spins when trigger initiated
    if (controller.getLeftTriggerAxis() > 0.1) {
      firstStep.set(controller.getLeftTriggerAxis());
      secondStep.set(controller.getLeftTriggerAxis()); 
    } 
    if (controller.getRightTriggerAxis() > 0.1){
      shooter.set(-2.5);
    }
  }
} 