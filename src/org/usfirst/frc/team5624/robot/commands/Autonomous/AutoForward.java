package org.usfirst.frc.team5624.robot.commands.Autonomous;

import org.usfirst.frc.team5624.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/**
 *
 */
public class AutoForward extends Command {
	long beginTime;
	double length,PWMVelocityL,PWMVelocityR;
	double gain =.00001;
	
	
    public AutoForward(double time,double PWMSpeed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    	length=time*1000;
    	PWMVelocityL=PWMSpeed;
    	PWMVelocityR=PWMSpeed;
    	
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	beginTime =System.currentTimeMillis();
    	
   
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//NEED TO CHANGE
        return(System.currentTimeMillis()-beginTime>length);
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		// NEED TO CHANGE
		
		double error= Robot.drive.getGyroAngle()-0;
		PWMVelocityL=PWMVelocityL+error*gain;
		PWMVelocityR=PWMVelocityR-error*gain;
		Robot.drive.drive(PWMVelocityL,-PWMVelocityR);
		
	}
}
