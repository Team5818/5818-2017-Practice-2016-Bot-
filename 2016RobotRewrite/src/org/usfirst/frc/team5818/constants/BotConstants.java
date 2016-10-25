package org.usfirst.frc.team5818.constants;

import edu.wpi.first.wpilibj.Joystick;

public class BotConstants {
	//Driving Constants
	public static double VEL_MULTIPLIER = 4;
	
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
	
	//CoDriving Constants
	//  TO DO: MOVE JOYSTICK INIT TO CO-DRIVER INIT //
	//  CONVERT NUMS TO CONSTANTS //
	public static final Joystick CODRIVER_LEFT = new Joystick(2);
	public static final Joystick CODRIVER_RIGHT = new Joystick(3);
	
	//Drive Wheels
	public static final int TALON_FR = 1;
	public static final int TALON_BR = 2;
	public static final int TALON_MR = 3;
	public static final int TALON_FL = 4;
	public static final int TALON_BL = 5;
	public static final int TALON_ML = 6;
	
	//Arm Actuation
	public static final int TALON_ARM_0 = 12;
	public static final int TALON_ARM_1 = 7;
	
	public static final double ARM_POWER_MULTIPLIER = 1;
	//Shooters
}
