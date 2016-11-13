package org.usfirst.frc.team5818.controllers;

import org.usfirst.frc.team5818.constants.BotConstants;
import org.usfirst.frc.team5818.robot.commands.ArmControlCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

public class CoDriver {
	private static Joystick CODRIVER_LEFT_JS = null;
	private static Joystick CODRIVER_RIGHT_JS = null;
	
	private static double joyX;
	private static double joyY;
	
	private static Command shootCommand;
	public static void CoDriverInit() {
		shootCommand = new ArmControlCommand();
		
		CODRIVER_LEFT_JS = new Joystick(BotConstants.CODRIVER_LEFT);
		CODRIVER_RIGHT_JS = new Joystick(BotConstants.CODRIVER_RIGHT); 
	}
	
	public static void CoDriverPeriodic() {
		Scheduler.getInstance().add(shootCommand);
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
}