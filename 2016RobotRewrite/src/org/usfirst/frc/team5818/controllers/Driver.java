package org.usfirst.frc.team5818.controllers;

import org.usfirst.frc.team5818.constants.BotConstants;
import org.usfirst.frc.team5818.robot.commands.DriveControlCommand;
import org.usfirst.frc.team5818.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Driver {
    private static boolean DownButtonDown;
    private static boolean UpButtonDown;
    
    private static double joyXAbs;
    private static double dampingFactor;
    private static double dfMultiplier = 1;
    
    private static double joyX;
    private static double joyY;
    
    private static Joystick CONTROLJOYFB;
    private static Joystick CONTROLJOYLR;
    
    static Command driveControl;

    public static void driverInit(DriveTrain train) {
        driveControl = new DriveControlCommand(train);
        CONTROLJOYFB = new Joystick(BotConstants.DRIVERJOYFB_NUM);
        CONTROLJOYLR = new Joystick(BotConstants.DRIVERJOYLR_NUM);
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
            UpButtonDown = BotConstants.PS3JOY.getRawButton(BotConstants.PS3_DOWN_BUTTON);
            DownButtonDown = BotConstants.PS3JOY.getRawButton(BotConstants.PS3_UP_BUTTON);
        } else {
            joyX = CONTROLJOYLR.getX();
            joyY = CONTROLJOYFB.getY();
            UpButtonDown = CONTROLJOYLR.getRawButton(BotConstants.DOWN_BUTTON);
            DownButtonDown = CONTROLJOYLR.getRawButton(BotConstants.UP_BUTTON);
        }
        setDampingFactor();
    }
    public static void checkButtons() {
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
        return -1*joyY;
    }
    public static double getJoyXAbs() {
        return joyXAbs;
    }
    public static double getDampingFactor() {
        return dampingFactor;
    }
}
