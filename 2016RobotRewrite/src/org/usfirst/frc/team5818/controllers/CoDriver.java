package org.usfirst.frc.team5818.controllers;

import org.usfirst.frc.team5818.constants.BotConstants;

import edu.wpi.first.wpilibj.Joystick;

public class CoDriver {
	private static Joystick CODRIVER_LEFT_JS = null;
	private static Joystick CODRIVER_RIGHT_JS = null;
	
	private static double joyX;
	private static double joyY;
	
	public static void CoDriverInit() {
		
		CODRIVER_LEFT_JS = new Joystick(BotConstants.CODRIVER_LEFT);
		CODRIVER_RIGHT_JS = new Joystick(BotConstants.CODRIVER_RIGHT); 
	}
	
	public static void CoDriverPeriodic() {
		
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