package org.usfirst.frc.team5624.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    
	
	public static int front_left=6;
	public static int back_left=7;
	public static int front_right=4;
	public static int back_right=5;
	public static int intakeF=3;
	public static int shooterIn=2;
	public static int armIn=9;
	public static int intakeSensorLeft=0;
	public static int intakeSensorRight=1;
	public static int ShooterEncoderPow=0;
	public static int ShooterEncoderSignal=1;
	public static int tiltIn=0;
	public static int panIn=1;
	
	public static enum positions{
		ONE,TWO,THREE,FOUR,FIVE
	}
	public static enum defense{
		Porticullis,LowBar,ChevalDeFrise,RockWall,Moat,Drawbridge,Ramparts,Sallyport,RoughTerrain
	}
	
}
