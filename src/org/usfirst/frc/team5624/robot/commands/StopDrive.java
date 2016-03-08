package org.usfirst.frc.team5624.robot.commands;

import org.usfirst.frc.team5624.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StopDrive extends Command {
	double gain =.00001;
	double PWM;
    public StopDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double error=Robot.drive.getGyroRate()-0;
    	
    	Robot.drive.drive(-error*gain, -error*gain);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Math.abs(Robot.drive.getGyroRate())<.5);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
