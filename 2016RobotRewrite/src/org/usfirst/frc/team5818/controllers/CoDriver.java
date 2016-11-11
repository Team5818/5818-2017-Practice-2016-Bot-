package org.usfirst.frc.team5818.controllers;

import edu.wpi.first.wpilibj.Joystick;

public class CoDriver {
	public static void CoDriverInit() {
		final int CODRIVER_LEFT = 2;
		final int CODRIVER_RIGHT = 3;
		
		final Joystick CODRIVER_LEFT_JS = new Joystick(CODRIVER_LEFT);
		final Joystick CODRIVER_RIGHT_JS = new Joystick(CODRIVER_RIGHT); 
	}
	
	public static void CoDriverPeriodic() {
		
	}
}
