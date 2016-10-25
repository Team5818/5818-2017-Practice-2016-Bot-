package org.usfirst.frc.team5818.robot.subsystems;

import org.usfirst.frc.team5818.constants.BotConstants;
import org.usfirst.frc.team5818.controllers.Driver;
import org.usfirst.frc.team5818.robot.Robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
	
	private static CANTalon TALON_MOTOR_FR;
	private static CANTalon TALON_MOTOR_BR;
	private static CANTalon TALON_MOTOR_MR;
	private static CANTalon TALON_MOTOR_FL;
	private static CANTalon TALON_MOTOR_BL;
	private static CANTalon TALON_MOTOR_ML;
	
	public static void initializeDriveTrain() {
		TALON_MOTOR_FR = new CANTalon(BotConstants.TALON_FR);
		TALON_MOTOR_BR = new CANTalon(BotConstants.TALON_BR);
		TALON_MOTOR_MR = new CANTalon(BotConstants.TALON_MR);
		TALON_MOTOR_FL = new CANTalon(BotConstants.TALON_FL);
		TALON_MOTOR_BL = new CANTalon(BotConstants.TALON_BL);
		TALON_MOTOR_ML = new CANTalon(BotConstants.TALON_MR);
		
		TALON_MOTOR_FR.setInverted(true);
		TALON_MOTOR_BR.setInverted(true);
		TALON_MOTOR_MR.setInverted(true);
	}
	
	public static void drive() {
		
		Driver.updateOnTick();
    	Driver.checkButtons();
        
		double x = Driver.getJoyX();
		double y = Driver.getJoyY();
		double df = Driver.getDampingFactor();
		double xAbs = Math.abs(x);
		double yAbs = Math.abs(y);
		if (xAbs <= 0.05 && y != 0) {
        	//drive straight
        	setRightVelocity(y);
        	setLeftVelocity(y);
        } else if(yAbs <= 0.05 && x != 0) {
        	//Pivot in place
        	setRightVelocity(-1 * x);
        	setLeftVelocity(x);
        } else if(x != 0 && y != 0) {
        	//drive and turn
        	if (x > 0) {
        		setLeftVelocity(y);
        		setRightVelocity(df * y);
        	} else {
        		setLeftVelocity(df * y);
        		setRightVelocity(y);
        	}
        } else {
        	//stop
        	setRightVelocity(0);
        	setLeftVelocity(0);
        }
	}
	
	public static void dance() {
		
	}
	
	public static void setRightVelocity(double numIn) {
    	TALON_MOTOR_FR.set(numIn*BotConstants.VEL_MULTIPLIER);
    	TALON_MOTOR_BR.set(numIn*BotConstants.VEL_MULTIPLIER);
    	TALON_MOTOR_MR.set(numIn*BotConstants.VEL_MULTIPLIER);
    }
    
    public static void setLeftVelocity(double numIn) {
    	TALON_MOTOR_FL.set(numIn*BotConstants.VEL_MULTIPLIER);
    	TALON_MOTOR_BL.set(numIn*BotConstants.VEL_MULTIPLIER);
    	TALON_MOTOR_ML.set(numIn*BotConstants.VEL_MULTIPLIER);
    }
	
	public void initDefaultCommand() {
		
		
	}
}
