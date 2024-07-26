package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmRotate; // Assuming ArmRotate is in subsystems package
import frc.robot.subsystems.Drivetrain;

import java.util.function.Supplier;
import edu.wpi.first.wpilibj.Timer; 

public class ArmRotateCommand extends Command  {
    private final ArmRotate m_armRotate;
    private double speed; // Adjust based on desired arm rotation speed
    //private Supplier<Double> m_xaxisSpeedSupplier;
    private Supplier<Double> m_zaxisRotateSupplier;
    private Timer cmdTimer;
    private Supplier<Double> zaxisSpeedSupplier;
    private Supplier<Double> zaxisRotateSupplier;
    /**
     * @param armRotate 
     * @param zaxisSpeedSupplier Lambda supplier of forward/backward speed
     */

public ArmRotateCommand(
        ArmRotate armRotate, 
        double speed,
        //Supplier<Double>xaxisSpeedSupplier
        Supplier<Double> zaxisRotateSupplier) {
    m_armRotate = armRotate;
    m_zaxisRotateSupplier = zaxisRotateSupplier; // created field 'zaxisRotateSupplier'
    //m_xaxisSpeedSupplier = xaxisSpeedSupplier;
    addRequirements(armRotate);
    cmdTimer = new Timer(); 
        }

@Override
public void initialize() {
// Optional: Set initial arm position if needed
}

@Override
public void execute() {
// Get Xbox controller axis value (e.g., -1.0 to 1.0 for full left/right movement)
    double rotationSpeed = m_zaxisRotateSupplier.get() * speed; 
    m_armRotate.controlServo(rotationSpeed);

    // Call ArmRotate subsystem's method to control the servo
    m_armRotate.setPosition(rotationSpeed); // Replace with appropriate control logic
  }

  @Override
  public boolean isFinished() {
    // Optional: Add logic to determine when the arm rotation is complete (e.g., not currently possible without limit switches)
    return false;
  }
}

