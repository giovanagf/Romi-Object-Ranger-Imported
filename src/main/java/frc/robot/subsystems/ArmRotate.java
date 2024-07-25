package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmRotate extends SubsystemBase {

  private final Servo m_servo;

  public ArmRotate(int servoPort) {
    m_servo = new Servo(8);
  }

  public void setPosition(double position) {
    // Implement logic to handle position (e.g., scaling, limiting)
    m_servo.setPosition(position);
  }

  public void armrotate(Double double1) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'armrotate'");
  }// (Optional) Add methods for sensor data processing (if limit switches are added later)

  public void controlServo(double joystickValue){
    // Scale joystick value (optional)
    double scaledValue = joystickValue * speedMultiplier; // Adjust speedMultiplier

    m_servo.setSpeed(scaledValue); // Replace with appropriate speed value based on joystickValue
  }
}