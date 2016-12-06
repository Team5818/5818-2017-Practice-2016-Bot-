package org.usfirst.frc.team5818.controllers;

import org.usfirst.frc.team5818.constants.BotConstants;
import org.usfirst.frc.team5818.robot.commands.ArmControlCommand;
import org.usfirst.frc.team5818.robot.commands.FlyWheelControlCommand;
import org.usfirst.frc.team5818.robot.subsystems.FlyWheel;
import org.usfirst.frc.team5818.robot.subsystems.ShooterArm;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

public class CoDriver {
	private static Joystick CODRIVER_LEFT_JS = null;
	private static Joystick CODRIVER_RIGHT_JS = null;
	
	private static double joyX;
	private static double joyY;
	
	private static boolean SHOOT_BUTTON_DOWN;
	
	private static Command shootCommand;
	private static Command flyWheelCommand;
	public static void CoDriverInit(ShooterArm armIn, FlyWheel wheelIn) {
		shootCommand = new ArmControlCommand(armIn);
		flyWheelCommand = new FlyWheelControlCommand(wheelIn);
		CODRIVER_LEFT_JS = new Joystick(BotConstants.CODRIVER_LEFT);
		CODRIVER_RIGHT_JS = new Joystick(BotConstants.CODRIVER_RIGHT); 
	}
	
	public static void CoDriverPeriodic() {
		Scheduler.getInstance().add(shootCommand);
		Scheduler.getInstance().add(flyWheelCommand);
	}
	
	public static void checkButtons() {
		SHOOT_BUTTON_DOWN = CODRIVER_RIGHT_JS.getRawButton(BotConstants.SHOOT_BUTTON);
	}
	
	public static void updateOnTick() {
		joyX = CODRIVER_LEFT_JS.getX();
		joyY = CODRIVER_RIGHT_JS.getY();
	}

	public static double getJoyX() {
		return joyX;
	}

	public static double getJoyY() {
		return joyY;
	}
	
	public static boolean getShootButton() {
		return SHOOT_BUTTON_DOWN;
	}
}