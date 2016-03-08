package org.usfirst.frc.team5624.robot.subsystems;

import org.usfirst.frc.team5624.robot.Robot;

import org.usfirst.frc.team5624.robot.RobotMap;

import org.usfirst.frc.team5624.robot.commands.WaitForShooter;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Intake extends Subsystem {
	Victor intakeMotor;
	
	
	AnalogInput intakeSensorLeft,intakeSensorRight;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Intake(){
		intakeMotor= new Victor(RobotMap.intakeF);
		intakeSensorLeft= new AnalogInput(RobotMap.intakeSensorLeft);
		intakeSensorRight= new AnalogInput(RobotMap.intakeSensorRight);
	}
	public void move(double val){
		intakeMotor.set(val);
		
		
	}
	
	 public void initDefaultCommand() {
		 setDefaultCommand(new WaitForShooter());
    	
        
    }
	 public void log(){
		 SmartDashboard.putData(getCurrentCommand());
		 SmartDashboard.putBoolean("Is Ball In",isBallIn());
		 SmartDashboard.putNumber("Infrared Left", intakeSensorLeft.getAverageVoltage());
		 SmartDashboard.putNumber("Infrared Right", intakeSensorRight.getAverageVoltage());
	 }
	 public boolean isBallIn(){
		 return(intakeSensorLeft.getAverageVoltage()>2.2||intakeSensorRight.getAverageVoltage()>2.2);
	 }
}

