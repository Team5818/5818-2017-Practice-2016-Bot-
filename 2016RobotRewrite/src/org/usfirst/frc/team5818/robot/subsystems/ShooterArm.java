package org.usfirst.frc.team5818.robot.subsystems;

import org.usfirst.frc.team5818.constants.BotConstants;
import org.usfirst.frc.team5818.controllers.CoDriver;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;

public class ShooterArm extends Subsystem implements PIDOutput{
    
	private static CANTalon ARM_MOTOR_0;
	private static CANTalon ARM_MOTOR_1;

	public ShooterArm() {
		ARM_MOTOR_0 = new CANTalon(BotConstants.TALON_ARM_0);
		ARM_MOTOR_1 = new CANTalon(BotConstants.TALON_ARM_1);
		
		ARM_MOTOR_1.setInverted(true);
		ARM_MOTOR_1.reverseOutput(true);
	}

	public void setArmPower(double numIn) {
		ARM_MOTOR_0.set(numIn * BotConstants.ARM_POWER_MULTIPLIER);
		ARM_MOTOR_1.set(numIn * BotConstants.ARM_POWER_MULTIPLIER);
	}
	private static final double PID_KP = 1.0; ///////////////
	private static final double PID_KI = 1.0; // CHANGE ME //
	private static final double PID_KD = 1.0; ///////////////
	
	public PIDController armController = new PIDController(PID_KP, PID_KI, PID_KD, ARM_MOTOR_0, this);
	
    public void initDefaultCommand() {
    	
    }

	@Override
	public void pidWrite(double output) {
		setArmPower(output);
	}
	public void setArmPosition(double target) {
		armController.setSetpoint(target);
		armController.enable();
	}
	public void operate() {
		CoDriver.updateOnTick();
		setArmPower(CoDriver.getJoyY());
	}
}