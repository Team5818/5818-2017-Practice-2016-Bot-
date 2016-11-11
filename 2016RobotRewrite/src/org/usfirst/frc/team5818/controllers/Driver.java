package org.usfirst.frc.team5818.controllers;

import org.usfirst.frc.team5818.constants.BotConstants;
import org.usfirst.frc.team5818.robot.commands.DriveControlCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Driver {
	public static boolean SwapButtonDown;
	public static boolean DownButtonDown;
	public static boolean UpButtonDown;
	
	public static double joyXAbs;
	public static double dampingFactor;
	private static double dfMultiplier = 1;
	
	private static double joyX;
	private static double joyY;
	
	private static Joystick CONTROLJOYFB;
	private static Joystick CONTROLJOYLR;
	
	static Command driveControl;

	public static void driverInit() {
		driveControl = new DriveControlCommand();
		CONTROLJOYFB = new Joystick(BotConstants.CONTROLJOYFB_NUM);
		CONTROLJOYLR = new Joystick(BotConstants.CONTROLJOYLR_NUM);
	}
	
	public static void driverPeriodic() {
		Scheduler.getInstance().add(driveControl);
	}
	
	public static void setDampingFactor() {
    	dampingFactor = (1 - joyXAbs) * dfMultiplier;
    	if(dampingFactor > 1) {
    		dampingFactor = 1;
    	} else if(dampingFactor < 0) {
    		dampingFactor = 0;
    	}
    }
	
	public static void updateOnTick() {
    	if(BotConstants.HANDHELDJOY) {
    		joyX = BotConstants.PS3JOY.getX();
    		joyY = BotConstants.PS3JOY.getY();
    		SwapButtonDown = BotConstants.PS3JOY.getRawButton(BotConstants.PS3_SWAP_BUTTON);
            UpButtonDown = BotConstants.PS3JOY.getRawButton(BotConstants.PS3_DOWN_BUTTON);
            DownButtonDown = BotConstants.PS3JOY.getRawButton(BotConstants.PS3_UP_BUTTON);
    	} else {
    		joyX = CONTROLJOYLR.getX();
            joyY = CONTROLJOYFB.getY();
            SwapButtonDown = CONTROLJOYLR.getRawButton(BotConstants.SWAP_BUTTON);
            UpButtonDown = CONTROLJOYLR.getRawButton(BotConstants.DOWN_BUTTON);
            DownButtonDown = CONTROLJOYLR.getRawButton(BotConstants.UP_BUTTON);
        }
        setDampingFactor();
    }
    public static void checkButtons() {
    	if(SwapButtonDown) {
        	joyY = -1 * joyY;
        }
    	if (UpButtonDown) {
        	dfMultiplier += 0.01;
        }
    	if (DownButtonDown) {
        	dfMultiplier -= 0.01;
        }
    }
    public static double getJoyX() {
    	return joyX;
    }
    public static double getJoyY() {
    	return joyY;
    }
    public static double getJoyXAbs() {
    	return joyXAbs;
    }
    public static double getDampingFactor() {
    	return dampingFactor;
    }
}
