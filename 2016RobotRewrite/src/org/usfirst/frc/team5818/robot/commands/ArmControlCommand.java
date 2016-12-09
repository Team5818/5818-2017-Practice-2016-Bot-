package org.usfirst.frc.team5818.robot.commands;

import org.usfirst.frc.team5818.controllers.CoDriver;
import org.usfirst.frc.team5818.robot.Robot;
import org.usfirst.frc.team5818.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5818.robot.subsystems.ShooterArm;

import edu.wpi.first.wpilibj.command.Command;

public class ArmControlCommand extends Command{
	
	private ShooterArm arm;
	
	public ArmControlCommand(ShooterArm armIn) {
		requires(Robot.shootArm);
		arm = armIn;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		arm.operate();
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
