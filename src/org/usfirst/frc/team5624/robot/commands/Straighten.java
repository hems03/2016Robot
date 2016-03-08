package org.usfirst.frc.team5624.robot.commands;

import org.usfirst.frc.team5624.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Straighten extends Command {
	double gain =.00001;
	double myAngle;
    public Straighten(double angle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    	myAngle=angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	SmartDashboard.putBoolean("OK TO SHOOT?", false);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double error=Robot.drive.getGyroAngle()-myAngle;
    	if(error>0){
    		
        	Robot.drive.drive(1-gain*error, -1+gain*error);
    	}else{
    		Robot.drive.drive(-1+gain*error, 1-gain*error);
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Math.abs(Robot.drive.getGyroAngle()-myAngle)<1);
    }

    // Called once after isFinished returns true
    protected void end() {
    	SmartDashboard.putBoolean("OK TO SHOOT?", true);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
