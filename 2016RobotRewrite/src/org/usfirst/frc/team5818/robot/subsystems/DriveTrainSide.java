package org.usfirst.frc.team5818.robot.subsystems;

import org.usfirst.frc.team5818.constants.BotConstants;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrainSide extends Subsystem implements PIDOutput {
	
	private static CANTalon fTal, mTal, bTal;
	
	enum Side {
        RIGHT, LEFT;
    }
	
	public DriveTrainSide (CANTalon frontTalon, CANTalon middleTalon, CANTalon backTalon, boolean isInverted, Side side) {
		setInversion(frontTalon, middleTalon, backTalon, isInverted);
	}
	
	private static final double PID_KP = 1.0; ///////////////
	private static final double PID_KI = 1.0; // CHANGE ME //
	private static final double PID_KD = 1.0; ///////////////
	
	public PIDController velController = new PIDController(PID_KP, PID_KI, PID_KD, mTal, this);
	
    public static void setVelocity(double numIn) {
    	fTal.set(numIn*BotConstants.VEL_MULTIPLIER);
    	mTal.set(numIn*BotConstants.VEL_MULTIPLIER);
    	bTal.set(numIn*BotConstants.VEL_MULTIPLIER);
    }
    
    public static void setInversion(CANTalon fTalon, CANTalon mTalon, CANTalon bTalon,boolean inverted) {
		fTalon.setInverted(inverted);
		fTalon.reverseOutput(inverted);
		mTalon.setInverted(inverted);
		mTalon.reverseOutput(inverted);
		bTalon.setInverted(inverted);
		bTalon.reverseOutput(inverted);
	}
	
	public void initDefaultCommand() {
		
		
	}

	@Override
	public void pidWrite(double output) {
		setVelocity(output);
	}
	
	public void setSideVelocity(double target) {
		//velController.set
		velController.enable();
	}

	
}
