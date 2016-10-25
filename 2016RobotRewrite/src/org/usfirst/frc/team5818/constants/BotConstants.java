package org.usfirst.frc.team5818.constants;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;

public class BotConstants {
	public static double VEL_MULTIPLIER = 1;
	
	public static final boolean HANDHELDJOY = true;
	public static final Joystick PS3JOY = new Joystick(2);
	public static final int UP_BUTTON = 4;
	public static final int DOWN_BUTTON = 2;
	public static final int SWAP_BUTTON = 3;
	
	public static final Joystick CONTROLJOYFB = new Joystick(0);
	public static final Joystick CONTROLJOYLR = new Joystick(1);
	public static final int PS3_UP_BUTTON = 5;
	public static final int PS3_DOWN_BUTTON = 7;
	public static final int PS3_SWAP_BUTTON = 8;
	
	//Drive Wheels
	public static final CANTalon TALON_FR = new CANTalon(1);
	public static final CANTalon TALON_BR = new CANTalon(2);
	public static final CANTalon TALON_MR = new CANTalon(3);
	public static final CANTalon TALON_FL = new CANTalon(4);
	public static final CANTalon TALON_BL = new CANTalon(5);
	public static final CANTalon TALON_ML = new CANTalon(6);
	
	//Arm Actuation
	public static final CANTalon TALON_ARM_0 = new CANTalon(12);
	public static final CANTalon TALON_ARM_1 = new CANTalon(7);
	//Shooters
}
