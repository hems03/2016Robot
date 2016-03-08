
package org.usfirst.frc.team5624.robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/*
 * Implements a SpeedController with an underlying PID controller
 */
public class PIDSpeedController implements SpeedController {

	PIDController controller;

	public PIDSpeedController(PIDSource source, PIDOutput output, String subsystem, String controllerName) {
		controller = new PIDController(0, 0, 0, 0, source, output);
		controller.setContinuous(true);

		LiveWindow.addActuator(subsystem, controllerName, controller);
	}

	public void setConstants(double p, double i, double d, double f) {
		controller.setPID(p, i, d, f);
	}

	public void setConstants(double p, double i, double d) {
		controller.setPID(p, i, d);
	}

	@Override
	public void pidWrite(double output) {
		// Never Used
	}

	public double getSetpoint() {
		return controller.getSetpoint();
	}

	@Override
	public double get() {
		return controller.get();
	}

	
	public void setVal(double setpoint) {
		controller.setSetpoint(setpoint);
		controller.enable();
	}

	@Override
	public void disable() {
		controller.disable();
	}

	public void reset() {
		controller.reset();
	}

	@Override
	public void setInverted(boolean isInverted) {
	}

	@Override
	public boolean getInverted() {
		return false;
	}

	public void stopMotor() {
		controller.disable();
	}

	@Override
	public void set(double speed, byte syncGroup) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void set(double speed) {
		// TODO Auto-generated method stub
		controller.enable();
		controller.setSetpoint(speed);
		
	}
}


