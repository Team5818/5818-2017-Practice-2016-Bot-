package org.usfirst.frc.team5818.robot.subsystems;

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
        	Robot.setRightVelocity(y);
        	Robot.setLeftVelocity(y);
        } else if(yAbs <= 0.05 && x != 0) {
        	//Pivot in place
        	Robot.setRightVelocity(-1 * x);
        	Robot.setLeftVelocity(y);
        } else if(x != 0 && y != 0) {
        	//drive and turn
        	if (x > 0) {
        		Robot.setLeftVelocity(y);
        		Robot.setRightVelocity(df * y);
        	} else {
        		Robot.setLeftVelocity(df * y);
        		Robot.setRightVelocity(y);
        	}
        } else {
        	//stop
        	Robot.setRightVelocity(0);
        	Robot.setLeftVelocity(0);
        }
	}
	
	public static void dance() {
		
	}
	
	public void initDefaultCommand() {
		
		
	}
}
