package frc.team4069.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivebase extends Subsystem {
    TalonSRX L1 = new TalonSRX(8);
    TalonSRX L2 = new TalonSRX(9);
    TalonSRX R1 = new TalonSRX(6);
    TalonSRX R2 = new TalonSRX(7);

    @Override
    protected void initDefaultCommand() {}

    public Drivebase () {
        L2.follow(L1);
        R2.follow(R1);
    }

    public void curvaturedrive (double averageSpeed, double difference) {
        double leftSpeed = averageSpeed + difference;
        double rightSpeed = averageSpeed - difference;
        L1.set(ControlMode.PercentOutput, leftSpeed);
        R1.set(ControlMode.PercentOutput, -rightSpeed);
    }

    public void stop () {
        L1.set(ControlMode.PercentOutput, 0);
        R1.set(ControlMode.PercentOutput, 0);
    }
}