package org.usfirst.frc.team5624.robot.subsystems;

import org.usfirst.frc.team5624.robot.BangBangController;

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
	double inchesPerPulse=Math.PI*4*2/20; //(circumference/pulses per revolution
	private BangBangController shooterControl;
	private double gain = .001; //essentially p value
	private double switchPWM=.85; //random number to get motor going
	private double switchError=1; //motor will always start below the setpoint
	public Shooter(){
		shooterMotor= new Victor(RobotMap.shooterIn);
		
		//encoder configuration stuff
		shooterEncoder = new Encoder(RobotMap.ShooterEncoderPow,RobotMap.ShooterEncoderSignal);
		shooterEncoder.setDistancePerPulse(inchesPerPulse);
		shooterEncoder.setSamplesToAverage(6);
		shooterEncoder.setPIDSourceType(PIDSourceType.kRate);
		shooterControl = new BangBangController(shooterEncoder, shooterMotor);
		
		
		
		
		
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new Idle());
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void setSpeed(double targetSpeed){
    	/* Take Back Half Control to regulate motor speed. 
    	 * 
    	 */
    	double error = -(-targetSpeed - getSpeed()); //since motor setpoint value is negative, error must be flipped to be postive.
    	if(error>0!=switchError>0){ //If error switches signs, PWM value of last error and of this error will be averaged and output
    		shooterMotor.set((switchPWM+shooterMotor.get())/2);
    		switchPWM=shooterMotor.get();
    		switchError=error; //the new error that switched signs is this one
    	}{
    		shooterMotor.set(shooterMotor.get() + gain * error); //normal gain to setpoint
    	}
    	SmartDashboard.putNumber("Error",error );
        
    	}
    public void stop(){
    	shooterMotor.set(0);
    }
    public double getSpeed(){
    	return(shooterEncoder.getRate());
    }
    public double getPower(){
    	return(shooterMotor.get());
    }
    
    public void updatePID(){
    	double P=Robot.prefs.getDouble("P", 0);
    	double I=Robot.prefs.getDouble("I", 0);
    	double D=Robot.prefs.getDouble("D", 0);
    	double F=Robot.prefs.getDouble("F", 0);
    	
    	
    	
    }
    public void setVoltage(){ //insurance if PID doesnt work
    	shooterMotor.set(Robot.prefs.getDouble("ShooterSpeed", .2));
    }
    
    /*public void clearPID(){
    	shooterControl.setConstants(0, 0, 0,0);
    }
    */
    public void log(){
    	SmartDashboard.putData(getCurrentCommand());
    	SmartDashboard.putNumber("ShooterSpeed", shooterEncoder.getRate());
    	SmartDashboard.putNumber("Shooter Power", shooterMotor.get());
    	SmartDashboard.putNumber("Distance Traveled", shooterEncoder.getDistance());
    	System.out.println(shooterEncoder.getRate());

    	
    	
    	
    }

	
   

	
	
		
		
	}


	

	
	
    


