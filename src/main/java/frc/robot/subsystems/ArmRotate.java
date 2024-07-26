package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmRotate extends SubsystemBase {

  private static final double speedMultiplier = 0.1;
  private final Servo m_servo;

  public ArmRotate() {
    m_servo = new Servo(5);
  }

  public void setPosition(double position) {
    // Implement logic to handle position (e.g., scaling, limiting)
    m_servo.setPosition(position);
  }

  public void controlServo(double joystickValue){
    // Scale joystick value (optional)
    double scaledValue = (joystickValue * speedMultiplier) +1.5; // Adjust speedMultiplier
    scaledValue = Math.max(1.0, Math.min (scaledValue, 2.0));
    System.out.println (scaledValue);
    m_servo.setSpeed(scaledValue); // Replace with appropriate speed value based on joystickValue
  
  }
}