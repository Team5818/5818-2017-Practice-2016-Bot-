package org.usfirst.frc.team5818.robot.subsystems;

import org.usfirst.frc.team5818.constants.BotConstants;
import org.usfirst.frc.team5818.robot.Robot;

import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
	public static void drive() {
		
		Robot.updateOnTick();
    	Robot.checkButtons();
        
		double x = Robot.getJoyX();
		double y = Robot.getJoyY();
		double df = Robot.getDampingFactor();
		double xAbs = Math.abs(x);
		double yAbs = Math.abs(y);
		if (xAbs <= 0.05 && y != 0) {
        	//drive straight
        	setRightVelocity(y);
        	setLeftVelocity(y);
        } else if(yAbs <= 0.05 && x != 0) {
        	//Pivot in place
        	setRightVelocity(-1 * x);
        	setLeftVelocity(y);
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
    	BotConstants.TALON_FR.set(-1*numIn*BotConstants.VEL_MULTIPLIER);
    	BotConstants.TALON_BR.set(-1*numIn*BotConstants.VEL_MULTIPLIER);
    	BotConstants.TALON_MR.set(-1*numIn*BotConstants.VEL_MULTIPLIER);
    }
    
    public static void setLeftVelocity(double numIn) {
    	BotConstants.TALON_FL.set(numIn*BotConstants.VEL_MULTIPLIER);
    	BotConstants.TALON_BL.set(numIn*BotConstants.VEL_MULTIPLIER);
    	BotConstants.TALON_ML.set(numIn*BotConstants.VEL_MULTIPLIER);
    }
	
	public void initDefaultCommand() {
		
		
	}
}
