
package org.usfirst.frc.team5624.robot;



import org.usfirst.frc.team5624.robot.commands.Autonomous.AutoLowBar;
import org.usfirst.frc.team5624.robot.commands.Straighten;
import org.usfirst.frc.team5624.robot.commands.Autonomous.AutoForward;
import org.usfirst.frc.team5624.robot.commands.Autonomous.AutoLeftTurn;
import org.usfirst.frc.team5624.robot.commands.Autonomous.AutoRightTurn;
import org.usfirst.frc.team5624.robot.commands.Autonomous.AutoSpyLowGoal;

import org.usfirst.frc.team5624.robot.commands.Autonomous.AutoForward;
import org.usfirst.frc.team5624.robot.subsystems.Arm;
import org.usfirst.frc.team5624.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5624.robot.subsystems.Intake;
import org.usfirst.frc.team5624.robot.subsystems.Shooter;
import org.usfirst.frc.team5624.robot.subsystems.Vision;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */

public class Robot extends IterativeRobot {
	//Initializes everything
	
	public static DriveTrain drive;
	public static Intake intake;
	public static Shooter shooter;
	public static Arm arm;
	public static Vision vision;
	public static Preferences prefs;
	public static DriverStation display;
	public static OI oi;
	
	
	
	 
	
	//initializes autonomous chooser
    Command autonomousCommand;
    SendableChooser chooser,autoPosition;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	 display=DriverStation.getInstance();
		chooser = new SendableChooser();
        drive = new DriveTrain();
        intake = new Intake();
        arm = new Arm();
        prefs= Preferences.getInstance();
        shooter = new Shooter();
        
        
        oi = new OI();
       
 
        //Adding autonomous modes
        chooser.addObject("ROCK WALL CROSS", new AutoForward(3,-.7));
        chooser.addObject("ROUGH TERRAIN CROSS", new AutoForward(2.5,-.6));
        chooser.addObject("MOAT CROSS", new AutoForward(3,.85)); //robot will be on its intake side
        chooser.addObject("LOW BAR CROSS", new AutoLowBar());
        chooser.addObject("JUST GO FORWARD", new AutoForward(1,-.6));
        chooser.addObject("SPY LOW GOAL", new AutoSpyLowGoal());
        chooser.addObject("DO NOTHING", new AutoForward(0,0) );
        chooser.addObject("Left Turn", new AutoLeftTurn(-40));
        chooser.addObject("Straighten", new Straighten(0));//ANGLE MUST BE NEGATIVE
        chooser.addObject("Right Turn", new AutoRightTurn(40)); //ANGLE MUST BE POSITIVE
        SmartDashboard.putData("Auto Mode", chooser);
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
    
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
    	//Robot.drive.angleReset();
        autonomousCommand = (Command) chooser.getSelected();
        if (autonomousCommand != null) 
        	autonomousCommand.start();
        SmartDashboard.putData(autonomousCommand);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        log();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
        if(Robot.shooter.getSpeed()>1300&&Robot.intake.isBallIn()){
        	Robot.intake.move(.9);
        }
        
        log();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void log(){
    	intake.log();
    	drive.log();
    	shooter.log();
    	//arm.log();
    	
    	
    	
    	
    }
    public void testPeriodic() {
    
    	
        LiveWindow.run();
        
    }
}
