package frc.team4069.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  TalonSRX L1 = new TalonSRX(8);
  TalonSRX L2 = new TalonSRX(9);
  TalonSRX R1 = new TalonSRX(6);
  TalonSRX R2 = new TalonSRX(7);
  Joystick stick = new Joystick(1);

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
      System.out.println("Init");
      L2.follow(L1);
      R2.follow(R1);

  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This function is called when autonomous begins.
   */
  @Override
  public void autonomousInit() {
    L1.set(ControlMode.PercentOutput, 0.5);
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    double difference = stick.getX(GenericHID.Hand.kRight);
    double averageSpeed = -stick.getY(GenericHID.Hand.kRight);
    double leftSpeed = averageSpeed + difference;
    double rightSpeed = averageSpeed - difference;
    L1.set(ControlMode.PercentOutput, leftSpeed);
    R1.set(ControlMode.PercentOutput, -rightSpeed);
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }

  @Override
  public void disabledInit() {
    L1.set(ControlMode.PercentOutput, 0);
    R1.set(ControlMode.PercentOutput, 0);
  }
}
