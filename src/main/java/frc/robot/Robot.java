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
  private static final int leftDeviceID = 1; 
  private static final int rightDeviceID = 2;
  private CANSparkMax m_leftMotor;
  private CANSparkMax m_rightMotor; 
  XboxController controller = new XboxController(0);


  @Override
  public void robotInit() {
    //initialize
    m_leftMotor = new CANSparkMax(leftDeviceID, MotorType.kBrushless);
    m_rightMotor = new CANSparkMax(rightDeviceID, MotorType.kBrushless); 
 
  }

  @Override
  public void teleopPeriodic() { 
    //motor go brrrrrrrrrr when A key pressed
    if (controller.getAButton()) {
      m_rightMotor.set(0.5);
      m_leftMotor.set(0.5);  
    } 
    else{
      m_rightMotor.set(0);
      m_leftMotor.set(0);  
    }
  } 
} 