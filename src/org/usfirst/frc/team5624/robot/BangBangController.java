package org.usfirst.frc.team5624.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

public class BangBangController {
	
    /**
     * The speed controller used to send output
     */
	private Encoder source;
    private Victor controller;
    /**
     * The target speed, in inches/second
     */
    private volatile double targetSpeed = 0;
    //Control data
    
    /**
     * The ratio (0-1) of motor power that is being applied
     */
    private double motorPower = 0;
    
    /**
     * Gain (G)
     */
    private static final double gain = 1E-2;
    /**
     * The error encountered during the last loop
     */
    private double lastError;
    /**
     * The take-back-half variable (b)
     */
    private double tbh = 0;
    
   
    

    /**
     * Constructor
     *
     * @param source The source to use to get the speed
     * @param controller The speed controller to control
     */
    public BangBangController(Encoder source, Victor controller) {
        this.source = source;
        this.controller = controller;
        lastError=0;
    }

    public void runSpeedControl() {

        double error = targetSpeed - getActualSpeed();
		
        motorPower += gain * error;

        

        //If the error has changed in sign since the last processing
        controller.set(motorPower);

    }

    /**
     * @see ThreadedSpeedController#getActualRpm() 
     */
    public double getActualSpeed() {
        return source.getRate();
    }

   
    public boolean isOnTarget() {
        double difference = getActualSpeed() - targetSpeed;

        return Math.abs(difference) < 100;
    }

    
    public void setTargetSpeed(double newSpeed) {
        
        //Set up values for optimized spinup to the target
        /*if(targetSpeed < newSpeed) {
            lastError = 1;
        }
        else if(targetSpeed > newSpeed) {
            lastError = -1;
        }
        */
       
        
        targetSpeed = newSpeed;
    }

    /**
     * Clamp a value to within +/- 1, for use with speed controllers
     *
     * @param input The value to clamp
     * @return the clamped value
     */
    private static double clamp(double input) {
        if (input > 1) {
            return 1;
        }
        if (input < -1) {
            return -1;
        }
        return input;
    }

    /**
     * Determine if a value is positive
     *
     * @param input
     * @return
     */
    private static boolean isPositive(double input) {
        return input > 0;
    }

    protected void stopMotor() {
        controller.set(0);
    }
	 
}
