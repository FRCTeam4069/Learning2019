package frc.team4069.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team4069.robot.Robot;

public class DriveStraightCommand extends Command {
    Robot robot;
    public DriveStraightCommand (Robot r) {
        robot = r;

    }

    @Override
    protected void initialize() {
        robot.base.curvaturedrive(0.5, 0);
    }
}