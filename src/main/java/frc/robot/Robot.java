package frc.robot; 

//Api
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController; 
import com.revrobotics.CANSparkMax; 
import com.revrobotics.CANSparkMaxLowLevel.MotorType; 

public class Robot extends TimedRobot { 

  /*Class Creation
    Replace = 1 and = 2 with the designated CAN motor
  */ 
  private static final int leftDeviceID = 14; 
  private static final int rightDeviceID = 15;
  private CANSparkMax m_leftMotor;
  private CANSparkMax m_rightMotor; 
  XboxController controller = new XboxController(0);


  @Override
  public void robotInit() {
    //initialize
    m_leftMotor = new CANSparkMax(leftDeviceID, MotorType.kBrushless);
    m_rightMotor = new CANSparkMax(rightDeviceID, MotorType.kBrushless);
    m_leftMotor.restoreFactoryDefaults();
    m_rightMotor.restoreFactoryDefaults();
  }

  @Override
  public void teleopPeriodic() { 
    //motor spins when trigger initiated 
    if (controller.getLeftTriggerAxis() > 0.1) {
      m_rightMotor.set(controller.getLeftTriggerAxis());
      m_leftMotor.set(controller.getLeftTriggerAxis()); 
    } 
    if (controller.getRightTriggerAxis() > 0.1){
      m_rightMotor.set(-1 * controller.getRightTriggerAxis());
      m_leftMotor.set(-1 * controller.getRightTriggerAxis());
    } 
  }
} 