package org.usfirst.frc.team5624.robot.commands;

import org.usfirst.frc.team5624.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeTransferToShooter extends Command {
	long time;
	double intakeVal;

    public IntakeTransferToShooter() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	time=System.currentTimeMillis();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.intake.isBallIn()&&Robot.shooter.getSpeed()>1300){
    		
    		
    		Robot.intake.move(.9);
    		
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (System.currentTimeMillis()-time>2000);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
