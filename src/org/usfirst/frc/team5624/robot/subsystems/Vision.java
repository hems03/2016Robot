package org.usfirst.frc.team5624.robot.subsystems;

import org.usfirst.frc.team5624.robot.Robot;
import org.usfirst.frc.team5624.robot.RobotMap;
import org.usfirst.frc.team5624.robot.commands.CameraSet;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Vision extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	NetworkTable visionTable;
	Double visionAngle;
	Servo tiltServo,panServo;
	private final int panAngle,tiltAngle;
	public Vision(){
		visionTable=NetworkTable.getTable("SmartDashboard");
		tiltServo= new Servo(RobotMap.tiltIn);
		panServo=new Servo(RobotMap.panIn);
		panAngle=40;
		tiltAngle=90;
		
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new CameraSet());
    }
    public double getDistanceToTarget(){
    	
    	//corrects for fluctuation
    	if(getBlobs()>0){
    	if(visionTable.getNumber("distancein")<1000){
    		return(visionTable.getNumber("distancein"));
    		
    	}else{
    		return 0;
    	}
    	}else{
    		return -1;
    	}
    	
    }
    public void stayInPlace(){
    	panServo.setAngle(40);
    	tiltServo.setAngle(140);
    	
    	
    }
   
    public int getBlobs(){
    	return (int) (visionTable.getNumber("BLOB_COUNT"));
    }
    public void log(){
    	
    	
    }
}

