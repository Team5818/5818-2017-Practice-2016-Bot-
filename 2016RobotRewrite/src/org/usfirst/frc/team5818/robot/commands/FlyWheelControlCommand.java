package org.usfirst.frc.team5818.robot.commands;

import org.usfirst.frc.team5818.robot.Robot;
import org.usfirst.frc.team5818.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5818.robot.subsystems.FlyWheel;

import edu.wpi.first.wpilibj.command.Command;

public class FlyWheelControlCommand extends Command{
	
	private FlyWheel fWheel;
	public FlyWheelControlCommand(FlyWheel wheel) {
        requires(Robot.flyWheel);
        fWheel = wheel;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	fWheel.initializeWheel();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	fWheel.operate();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }
    
    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
