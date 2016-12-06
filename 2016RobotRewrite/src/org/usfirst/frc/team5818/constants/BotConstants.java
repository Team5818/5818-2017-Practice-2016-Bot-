package org.usfirst.frc.team5818.constants;

import edu.wpi.first.wpilibj.Joystick;

public class BotConstants {
	//Joystick Constants
	public static final double JOY_DEADZONE = 0.05;
	public static final int UP_BUTTON = 4;
	public static final int DOWN_BUTTON = 2;
	
	public static final int DRIVERJOYFB_NUM = 0;
	public static final int DRIVERJOYLR_NUM = 1;
	
	public static final boolean HANDHELDJOY = false;
	public static final Joystick PS3JOY = new Joystick(2);
	public static final int PS3_UP_BUTTON = 5;
	public static final int PS3_DOWN_BUTTON = 7;
	
	public static final int CODRIVER_LEFT = 2;
	public static final boolean INVERT_DRIVER_Y = true;
	public static final int CODRIVER_RIGHT = 3;
	public static final int SHOOT_BUTTON = 1;
	// V IMPLEMENT THIS! V
	public static final boolean INVERT_CODRIVER_Y = true;
	//Driving Constants
	
	public static boolean DRIVE_ENABLED = true;
	public static boolean DRIVE_PID_ENABLED = false;
	
	public static double VEL_MULTIPLIER = 2;
	public static double BRAKE_FACTOR = 0.0001;
	public static double MAX_VELOCITY = 2.0;
	
	//Arm Actuation Constants
	
	public static final double ARM_POWER_MULTIPLIER = 1;
	
	// V IMPLEMENT THIS! V
	public static final double ARM_MAX_SPEED = 1;
	//Shooters
}
