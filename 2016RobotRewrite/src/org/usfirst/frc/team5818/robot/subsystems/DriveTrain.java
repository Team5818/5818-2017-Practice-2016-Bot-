package org.usfirst.frc.team5818.robot.subsystems;

import org.usfirst.frc.team5818.constants.BotConstants;
import org.usfirst.frc.team5818.controllers.Driver;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team5818.robot.RobotMap;
import org.usfirst.frc.team5818.robot.subsystems.DriveTrainSide;

public class DriveTrain extends Subsystem {
	
	private static CANTalon TALON_MOTOR_FR;
	private static CANTalon TALON_MOTOR_BR;
	private static CANTalon TALON_MOTOR_MR;
	private static CANTalon TALON_MOTOR_FL;
	private static CANTalon TALON_MOTOR_BL;
	private static CANTalon TALON_MOTOR_ML;
	
	private final DriveTrainSide left;
            
    // Right motors are reversed.
    private final DriveTrainSide right;
    
    public DriveTrain() {
    	initializeDriveTrain();
    	left = new DriveTrainSide(TALON_MOTOR_FL, TALON_MOTOR_ML, TALON_MOTOR_BL, false, DriveTrainSide.Side.LEFT);
        right = new DriveTrainSide(TALON_MOTOR_FR, TALON_MOTOR_MR, TALON_MOTOR_BR, true, DriveTrainSide.Side.RIGHT);
    }

	public static void initializeDriveTrain() {
		TALON_MOTOR_FR = new CANTalon(RobotMap.TALON_FR);
		TALON_MOTOR_BR = new CANTalon(RobotMap.TALON_BR);
		TALON_MOTOR_MR = new CANTalon(RobotMap.TALON_MR);
		TALON_MOTOR_FL = new CANTalon(RobotMap.TALON_FL);
		TALON_MOTOR_BL = new CANTalon(RobotMap.TALON_BL);
		TALON_MOTOR_ML = new CANTalon(RobotMap.TALON_MR);
	}
	
	public void drive() {
		
		Driver.updateOnTick();
    	Driver.checkButtons();
        
		double x = Driver.getJoyX();
		double y = Driver.getJoyY();
		if(!BotConstants.DRIVE_ENABLED) {
			x = 0;
			y = 0;
		}
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
        	setRightVelocity(0); //For Non-PID
        	setLeftVelocity(0); //For Non-PID
        	right.brake();
        	left.brake();
        }
	}
	
	public void setRightVelocity(double numIn) {
    	//right.setVelocity(numIn); //For Non-PID
    	right.setSideVelocity(numIn); //For PID
	}
    
    public void setLeftVelocity(double numIn) {
    	//left.setVelocity(numIn); //For Non-PID
    	left.setSideVelocity(numIn); //For PID
	}
	
    public void initDefaultCommand() {
		
		
	}

	
}
