
package org.usfirst.frc.team5818.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team5818.constants.BotConstants;
import org.usfirst.frc.team5818.robot.commands.DriveControlCommand;
import org.usfirst.frc.team5818.robot.commands.ExampleCommand;
import org.usfirst.frc.team5818.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5818.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	public static boolean SwapButtonDown;
	public static boolean DownButtonDown;
	public static boolean UpButtonDown;
	
	public static double joyXAbs;
	public static double dampingFactor;
	private static double dfMultiplier = 1;
	
	public static double joyX;
	public static double joyY;
	//private static boolean buttonSwap;
	//private static boolean buttonDown;
	//private static boolean buttonUp;
	
	public static OI oi;

	
	
	//public static Joystick controlJoyFB = new Joystick(0);
	//public static Joystick controlJoyLR = new Joystick(1);
	
	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static final DriveTrain driveTrain = new DriveTrain();
	
    Command autonomousCommand;
    SendableChooser chooser;
    Command driveControl;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", new ExampleCommand());
//        chooser.addObject("My Auto", new MyAutoCommand());
        SmartDashboard.putData("Auto mode", chooser);
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
        autonomousCommand = (Command) chooser.getSelected();
        
		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */
    	
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        //cTalFR.reverseOutput(true);
        //cTalMR.reverseOutput(true);
        //cTalBR.reverseOutput(true);
        driveControl = new DriveControlCommand();
        SmartDashboard.putData(driveTrain);
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        Scheduler.getInstance().add(driveControl);
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
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
    		joyX = BotConstants.CONTROLJOYLR.getX();
            joyY = -1*BotConstants.CONTROLJOYFB.getY();
            SwapButtonDown = BotConstants.CONTROLJOYLR.getRawButton(BotConstants.SWAP_BUTTON);
            UpButtonDown = BotConstants.CONTROLJOYLR.getRawButton(BotConstants.DOWN_BUTTON);
            DownButtonDown = BotConstants.CONTROLJOYLR.getRawButton(BotConstants.UP_BUTTON);
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
