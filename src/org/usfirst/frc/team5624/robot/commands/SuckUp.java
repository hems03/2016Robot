package org.usfirst.frc.team5624.robot.commands;

import org.usfirst.frc.team5624.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SuckUp extends Command {

    public SuckUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(!Robot.intake.isBallIn()){
        	Robot.intake.move(.345);
        	}else{
        		Robot.intake.move(0);
        	}
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Robot.intake.isBallIn()){
        return (true);
    	}else{
    		return(false);
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    	
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
