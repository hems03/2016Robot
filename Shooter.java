package org.usfirst.frc.team5624.robot.subsystems;

import org.usfirst.frc.team5624.robot.PIDSpeedController;
import org.usfirst.frc.team5624.robot.Robot;
import org.usfirst.frc.team5624.robot.RobotMap;
import org.usfirst.frc.team5624.robot.commands.Idle;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Shooter extends Subsystem  {
	Victor shooterMotor;
	public Encoder shooterEncoder;
	public PIDSpeedController shooterControl;
	double inchesPerPulse=Math.PI*2*2/20;
	public Shooter(){
		
		
		shooterMotor= new Victor(RobotMap.shooterIn);
		
		
		shooterEncoder = new Encoder(RobotMap.ShooterEncoderPow,RobotMap.ShooterEncoderSignal);
		shooterEncoder.setDistancePerPulse(inchesPerPulse);
		shooterEncoder.setSamplesToAverage(5);
		shooterEncoder.setPIDSourceType(PIDSourceType.kRate);
		shooterControl=new PIDSpeedController(shooterEncoder,shooterMotor,"Shooter","Wheel");
		
		
		
		
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new Idle());
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void set(double val){
    	shooterControl.set(val);
    	
    	
    	
    }
    public void updatePID(){
    	double P=Robot.prefs.getDouble("P", 0);
    	double I=Robot.prefs.getDouble("I", 0);
    	double D=Robot.prefs.getDouble("D", 0);
    	double F=Robot.prefs.getDouble("F", 0);
    	shooterControl.setConstants(P,I,D,F);
    	
    	
    }
    
    /*public void clearPID(){
    	shooterControl.setConstants(0, 0, 0,0);
    }
    */
    public void log(){
    	SmartDashboard.putData(getCurrentCommand());
    	SmartDashboard.putNumber("ShooterSpeed", shooterEncoder.getRate());
    	SmartDashboard.putNumber("Speed Setpoint", shooterControl.getSetpoint());
    	
    	
    
    	
    	
    	
    }

	
	
		
		
	}


	

	
	
    


