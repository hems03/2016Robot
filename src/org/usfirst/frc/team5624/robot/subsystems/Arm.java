package org.usfirst.frc.team5624.robot.subsystems;

import org.usfirst.frc.team5624.robot.Robot;
import org.usfirst.frc.team5624.robot.RobotMap;
import org.usfirst.frc.team5624.robot.commands.IdleArm;
import org.usfirst.frc.team5624.robot.commands.SmackDown;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Arm extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Victor armMotor;
	public Arm(){
		armMotor= new Victor(RobotMap.armIn);
		
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new SmackDown());
    	
    }
    public void set(double val){
    	armMotor.set(val);
    }
    public void log(){
    	SmartDashboard.putData(getCurrentCommand());;
    }
}

