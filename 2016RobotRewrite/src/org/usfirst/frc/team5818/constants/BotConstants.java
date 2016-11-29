package org.usfirst.frc.team5818.constants;

import edu.wpi.first.wpilibj.Joystick;

public class BotConstants {
	//Driving Constants
	
	public static boolean DRIVE_ENABLED = false;
	
	public static double VEL_MULTIPLIER = 4;
	public static double BRAKE_FACTOR = 0.0001;
	public static double MAX_VELOCITY = 5.0;
	
	public static final boolean HANDHELDJOY = false;
	public static final Joystick PS3JOY = new Joystick(2);
	public static final int UP_BUTTON = 4;
	public static final int DOWN_BUTTON = 2;
	public static final int SWAP_BUTTON = 3;
	
	public static final int CONTROLJOYFB_NUM = 0;
	public static final int CONTROLJOYLR_NUM = 1;
	public static final int PS3_UP_BUTTON = 5;
	public static final int PS3_DOWN_BUTTON = 7;
	public static final int PS3_SWAP_BUTTON = 8;
	
	//Arm Actuation
	public static final int CODRIVER_LEFT = 2;
	public static final int CODRIVER_RIGHT = 3;
	public static final double ARM_POWER_MULTIPLIER = 1;
	//Shooters
}
