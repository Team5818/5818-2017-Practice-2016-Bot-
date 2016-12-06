package org.usfirst.frc.team5818.robot.subsystems;

import org.usfirst.frc.team5818.constants.BotConstants;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrainSide extends Subsystem implements PIDOutput, PIDSource{
	
	private CANTalon fTal, mTal, bTal;
	
	enum Side {
        RIGHT, LEFT;
    }
	
	public DriveTrainSide (CANTalon frontTalon, CANTalon middleTalon, CANTalon backTalon, boolean isInverted, Side side) {
		setInversion(frontTalon, middleTalon, backTalon, isInverted);
		fTal = frontTalon;
		mTal = middleTalon;
		bTal = backTalon;
	}
	
	private static final double PID_KP = 1.0; ///////////////
	private static final double PID_KI = 1.0; // CHANGE ME //
	private static final double PID_KD = 1.0; ///////////////
	
	public PIDController velController = new PIDController(PID_KP, PID_KI, PID_KD, this, this);
	
    public void setVelocity(double numIn) {
    	if(numIn <= BotConstants.MAX_VELOCITY) {
    		fTal.set(numIn*BotConstants.VEL_MULTIPLIER);
    		mTal.set(numIn*BotConstants.VEL_MULTIPLIER);
    		bTal.set(numIn*BotConstants.VEL_MULTIPLIER);
    	} else {
    		fTal.set(BotConstants.MAX_VELOCITY);
    		mTal.set(BotConstants.MAX_VELOCITY);
    		bTal.set(BotConstants.MAX_VELOCITY);
    	}
    }
    
    public void setInversion(CANTalon fTalon, CANTalon mTalon, CANTalon bTalon,boolean inverted) {
		fTalon.setInverted(inverted);
		fTalon.reverseOutput(inverted);
		mTalon.setInverted(inverted);
		mTalon.reverseOutput(inverted);
		bTalon.setInverted(inverted);
		bTalon.reverseOutput(inverted);
	}
	
	public void initDefaultCommand() {
		
		
	}
	
	public void brake() {
		for(double i = this.pidGet(); i >= 0; i = i - BotConstants.BRAKE_FACTOR) {
			this.setSideVelocity(i);
		}
	}
	
	@Override
	public void pidWrite(double output) {
		setVelocity(output);
	}
	
	public void setSideVelocity(double target) {
		if(target <= BotConstants.MAX_VELOCITY) {
			velController.setSetpoint(target);
			velController.enable();
		} else {
			velController.setSetpoint(BotConstants.MAX_VELOCITY);
			velController.enable();
		}
	}

	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
	
	}

	@Override
	public PIDSourceType getPIDSourceType() {
		return PIDSourceType.kRate;
	}

	@Override
	public double pidGet() {
		return mTal.getEncVelocity();
	}
}
