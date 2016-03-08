package org.usfirst.frc.team5624.robot.commands.Autonomous;

import org.usfirst.frc.team5624.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoRightTurn extends Command {
	double myAngleChange;
	double gain;
    public AutoRightTurn(double angleChange) { //angle must be positive!
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    	myAngleChange=angleChange;
    	gain=.0005;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double gyroError=myAngleChange-(Robot.drive.getGyroAngle());
    	Robot.drive.drive(-1+gain*gyroError, 1-gain*gyroError);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Math.abs(myAngleChange-Robot.drive.getGyroAngle())<2);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
