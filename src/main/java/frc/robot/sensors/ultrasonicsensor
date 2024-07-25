package frc.robot.sensors.ultrasonicsensor;

import com.typesafe.config.Config;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Config4905;
import frc.robot.sensors.RealSensorBase;

public class RealUltrasonicSensor extends RealSensorBase implements UltrasonicSensor {
  private Ultrasonic m_ultrasonic;
  private String m_sensorName;

  /**
   * Creates the ultrasonic with the ping and echo ports passed in
   * 
   * @param ping Port for the ping
   * @param echo Port for the echo
   */
  public RealUltrasonicSensor(String confString) {
    Config conf = Config4905.getConfig4905().getSensorConfig();
    int ping = conf.getInt("sensors." + confString + ".ping");
    int echo = conf.getInt("sensors." + confString + ".echo");
    m_ultrasonic = new Ultrasonic(ping, echo);
    m_ultrasonic.setEnabled(true);
    Ultrasonic.setAutomaticMode(true);
    m_sensorName = confString;
  }

  @Override
  public double getDistanceInches() {
    return m_ultrasonic.getRangeInches();
  }

  @Override
  protected void updateSmartDashboard() {
    SmartDashboard.putNumber(m_sensorName, getDistanceInches());
  }
}