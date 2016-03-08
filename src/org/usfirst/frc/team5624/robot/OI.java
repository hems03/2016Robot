package org.usfirst.frc.team5624.robot;





import org.usfirst.frc.team5624.robot.commands.BringUp;
import org.usfirst.frc.team5624.robot.commands.Eject;


import org.usfirst.frc.team5624.robot.commands.IntakeBack;
import org.usfirst.frc.team5624.robot.commands.IntakeTransferToShooter;
import org.usfirst.frc.team5624.robot.commands.ShootHigh;
import org.usfirst.frc.team5624.robot.commands.ShootThresh;
import org.usfirst.frc.team5624.robot.commands.SmackDown;
import org.usfirst.frc.team5624.robot.commands.SuckUp;
import org.usfirst.frc.team5624.robot.commands.SwitchDirection;
import org.usfirst.frc.team5624.robot.commands.UnstuckShooter;

import Controllers.XboxControllerInputs;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;



/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
	Joystick l,r,xbox;
	public JoystickButton shootButt,intButt,ejectButt,flipButt,transferButt,unstuckButt,voltageButt,smackButt,liftButt;
	XboxControllerInputs xboxMap;
	
	
	public OI(){
		//Assigns Buttons and Joysticks
		xboxMap=new XboxControllerInputs();
		l= new Joystick(0);
		r= new Joystick(1);
		xbox = new Joystick(2);
		
		//instantiates buttons
		ejectButt= new JoystickButton(xbox,xboxMap.kLB_val);
		intButt= new JoystickButton(xbox,xboxMap.kRB_val);
		shootButt= new JoystickButton(xbox,xboxMap.kA_val);
		unstuckButt=new JoystickButton(xbox,xboxMap.kY_val);
		flipButt= new JoystickButton(l,3);
		transferButt=new JoystickButton(xbox,xboxMap.kX_val);
		
		smackButt = new JoystickButton(r,1);
		liftButt= new JoystickButton(l,1);
		
		
		//Defines Button Actions
		flipButt.whenPressed(new SwitchDirection());
		shootButt.whileHeld(new ShootThresh());
		transferButt.whenPressed(new IntakeTransferToShooter());
		unstuckButt.whenPressed(new UnstuckShooter());
		intButt.whileHeld(new SuckUp());
		ejectButt.whileHeld(new Eject());
		
		
		
		}
		
		
		
		
	
		
		
		
	public double getTrigger(){
		return (xbox.getRawAxis(3));
	}
	public Joystick getXBOX(){
		
		return xbox;
		
	}
	public double getXBOXY(){
		return(xbox.getY());
	}
	public Joystick getLeftDrive(){
		return l;
	}
	
	public Joystick getRightDrive(){
		return r;
	}
	
}

