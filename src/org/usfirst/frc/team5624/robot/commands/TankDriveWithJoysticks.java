package org.usfirst.frc.team5624.robot.commands;

import org.usfirst.frc.team5624.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TankDriveWithJoysticks extends Command {
	double scaleFactor=1;
	
    public TankDriveWithJoysticks() {
    	requires(Robot.drive);
    	
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//if(Robot.display.getBatteryVoltage()>8){
    	Robot.drive.drive(scaleFactor*Robot.oi.getLeftDrive().getY(), -scaleFactor*Robot.oi.getRightDrive().getY());
    	//}else{
    		//Robot.drive.drive(0,0);
    	//}
    	
    }

//  return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
