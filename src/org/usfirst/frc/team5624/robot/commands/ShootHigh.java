package org.usfirst.frc.team5624.robot.commands;

import java.util.Scanner;

import org.usfirst.frc.team5624.robot.Robot;
import org.usfirst.frc.team5624.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ShootHigh extends Command {
	double mySpeed;
	

    public ShootHigh(double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shooter);
    	mySpeed=speed;

    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.shooter.setSpeed(mySpeed);
    
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
