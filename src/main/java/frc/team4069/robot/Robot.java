package frc.team4069.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.team4069.robot.commands.DriveStraightCommand;
import frc.team4069.robot.subsystems.Drivebase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {


  TalonSRX slide = new TalonSRX (10);
  Joystick stick = new Joystick(1);
  public Drivebase base;
  Scheduler scheduler;


  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
      System.out.println("Init");

      base = new Drivebase ();

      slide.setInverted(true);
      slide.config_kP(0, 1.7);
      slide.config_kD(0, 0.5);

      scheduler = Scheduler.getInstance();
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
//    slide.set(ControlMode.Position, 5000);
      scheduler.add(new DriveStraightCommand(this, 21));
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    SmartDashboard.putNumber("Slide Position", slide.getSelectedSensorPosition());
    scheduler.run();
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    //slide.set(ControlMode.PercentOutput, stick.getX(GenericHID.Hand.kRight));
    double difference = stick.getX(GenericHID.Hand.kRight);
    double averageSpeed = -stick.getY(GenericHID.Hand.kRight);
    base.curvaturedrive(averageSpeed, difference);

  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }

  @Override
  public void disabledInit() {
 base.stop ();
  }
}
