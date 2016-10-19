package org.usfirst.frc.team5818.constants;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;

public class BotConstants {
	public static double VEL_MULTIPLIER = 1.5;
	
	public static final Joystick CONTROLJOYFB = new Joystick(0);
	public static final Joystick CONTROLJOYLR = new Joystick(1);
	
	public static final int UP_BUTTON = 4;
	public static final int DOWN_BUTTON = 2;
	public static final int SWAP_BUTTON = 3;
	
	public static final CANTalon TALON_FR = new CANTalon(1);
	public static final CANTalon TALON_BR = new CANTalon(2);
	public static final CANTalon TALON_MR = new CANTalon(3);
	public static final CANTalon TALON_FL = new CANTalon(4);
	public static final CANTalon TALON_BL = new CANTalon(5);
	public static final CANTalon TALON_ML = new CANTalon(6);
}
