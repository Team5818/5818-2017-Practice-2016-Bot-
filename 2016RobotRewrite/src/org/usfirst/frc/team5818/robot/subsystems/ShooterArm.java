package org.usfirst.frc.team5818.robot.subsystems;

import org.usfirst.frc.team5818.constants.BotConstants;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CANTalon;

public class ShooterArm extends Subsystem {
    
	private static CANTalon ARM_MOTOR_0;
	private static CANTalon ARM_MOTOR_1;

	public static void initializeShooterArm() {
		ARM_MOTOR_0 = new CANTalon(BotConstants.TALON_ARM_0);
		ARM_MOTOR_1 = new CANTalon(BotConstants.TALON_ARM_1);
		
		ARM_MOTOR_1.setInverted(true);
	}

	public static void setArmPower(double numIn) {
		ARM_MOTOR_0.set(numIn * BotConstants.ARM_POWER_MULTIPLIER);
		ARM_MOTOR_1.set(numIn * BotConstants.ARM_POWER_MULTIPLIER);
	}
    public void initDefaultCommand() {
    	
    }
}