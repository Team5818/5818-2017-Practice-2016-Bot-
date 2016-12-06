package org.usfirst.frc.team5818.robot.subsystems;

import org.usfirst.frc.team5818.constants.BotConstants;
import org.usfirst.frc.team5818.controllers.CoDriver;
import org.usfirst.frc.team5818.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Subsystem;

public class FlyWheel extends Subsystem implements PIDSource, PIDOutput {

	private final CANTalon wheelTal0;
	
	private final double IDEAL_WHEEL_VELOCITY = 1;
	private final double MAX_WHEEL_VELOCITY = 2;
	
	public PIDController wheelController;
	
	public FlyWheel() {
		wheelTal0 = new CANTalon(RobotMap.TALON_WHEEL_0);
		wheelTal0.setInverted(false);
		wheelController = new PIDController(PID_KP, PID_KI, PID_KD, this, this);
	}
	
	@Override
	protected void initDefaultCommand() {
	
	}
	public void initializeWheel() {
		
	}
	public void spinUp() {
		setWheelVelocity(IDEAL_WHEEL_VELOCITY);
	}

	public void operate() {
		CoDriver.checkButtons();
		if(CoDriver.getShootButton()) {
			spinUp();
		}
	}
	
	public void setVelocity(double velocityIn) {
		wheelTal0.set(velocityIn);
	}
	
	public void setWheelVelocity(double target) {
		if(target <= MAX_WHEEL_VELOCITY) {
			wheelController.setSetpoint(target);
			wheelController.enable();
		} else {
			wheelController.setSetpoint(BotConstants.MAX_VELOCITY);
			wheelController.enable();
		}
	}
	
	private static final double PID_KP = 1.0; ///////////////
	private static final double PID_KI = 1.0; // CHANGE ME //
	private static final double PID_KD = 1.0; ///////////////
	
	
	
	@Override
	public void pidWrite(double output) {
		//setVelocity(output);
		setWheelVelocity(output);
	}

	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
	
	}

	@Override
	public PIDSourceType getPIDSourceType() {
		return PIDSourceType.kRate;
	}

	@Override
	public double pidGet() {
		return wheelTal0.getEncVelocity();
	}
}
