package org.usfirst.frc.team5818.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // Drive Wheels
	public static final int TALON_FR = 1;
	public static final int TALON_BR = 2;
	public static final int TALON_MR = 3;
	public static final int TALON_FL = 4;
	public static final int TALON_BL = 5;
	public static final int TALON_ML = 6;
		
	// Arm Actuation
	public static final int TALON_ARM_0 = 12;
	public static final int TALON_ARM_1 = 7;
	
	// Gyro in
	public static final int GYRO_CHANNEL = 0;
}