package frc.team4069.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team4069.robot.Robot;

public class DriveStraightCommand extends Command {

    Robot robot;
    public DriveStraightCommand (Robot r, double distance) {
        robot = r;
    }

    @Override
    protected void initialize() {
        robot.base.curvaturedrive(0.5, 0);
    }

    @Override
    protected void execute() {

    }

    @Override
    protected boolean isFinished() {
        double distanceTraveled = robot.base.getDistanceTraveledMeters();
        return distanceTraveled >= 2;
    }

    @Override
    protected void end() {
        robot.base.stop();
    }
}