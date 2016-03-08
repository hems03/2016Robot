package org.usfirst.frc.team5624.robot.commands.Autonomous;

import org.usfirst.frc.team5624.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SpyReachHighGoal extends Command {
	static double distanceToSpot=60;
	static double gain=.0025;
    public SpyReachHighGoal() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double error = Robot.vision.getDistanceToTarget()-distanceToSpot;
    	Robot.drive.drive(-.5-error*gain, -.5-error*gain);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(Robot.vision.getDistanceToTarget()-distanceToSpot)<5;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
