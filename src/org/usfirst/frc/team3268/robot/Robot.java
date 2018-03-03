/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3268.robot;

import org.usfirst.frc.team3268.robot.commands.auto.ChargeAutoCommand;
import org.usfirst.frc.team3268.robot.subsystems.ButterflyWingsSubsystem;
import org.usfirst.frc.team3268.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team3268.robot.subsystems.ShooterPneumaticsSubsystem;
import org.usfirst.frc.team3268.robot.subsystems.ShooterWheelsSubsystem;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	
	// OI & subsystems
	public static final DriveSubsystem driveSubsystem = new DriveSubsystem();
	public static final ShooterWheelsSubsystem shooterWheelsSubsystem = new ShooterWheelsSubsystem();
	public static final ShooterPneumaticsSubsystem shooterPneumaticsSubsystem = new ShooterPneumaticsSubsystem();
	public static final ButterflyWingsSubsystem butterflyWingsSubsystem = new ButterflyWingsSubsystem();
	public static OI oi;

	// smartDashboard & other chooser stuff
	Command autoCommand;
	SendableChooser<Command> autoChooser = new SendableChooser<>();

	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		
		cameraInit();
		
		oi = new OI();
		
		/* Autonomous Initiation & Declaration */
		
		autoChooser.addDefault("No Auto", null);
		autoChooser.addObject("Forwards Charge", new ChargeAutoCommand(1));
		autoChooser.addObject("Backwards Charge", new ChargeAutoCommand(-1));
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Autonomous", autoChooser);
	}
	public void cameraInit() {
		CameraServer.getInstance().startAutomaticCapture(0);
		CameraServer.getInstance().startAutomaticCapture(1);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	public void disabledInit() {

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	public void autonomousInit() {
		autoCommand = autoChooser.getSelected();


//		 String autoSelected = SmartDashboard.getString("Auto Selector", "Default"); 
//		 switch(autoSelected) { 
//		 case "My Auto": autonomousCommand = new MyAutoCommand(); break;
//		 case "Default Auto": 
//			default: autonomousCommand = new ExampleCommand(); break; }

		// schedule the autonomous command (example)
		if (autoCommand != null) {
			autoCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autoCommand != null) {
			autoCommand.cancel();
		}
		
//		new MoveShooterCommand(Position.UP).start();
//		shooterPneumaticsSubsystem.position = Position.UP;
		
	}

	/**
	 * This function is called periodically during operator control.
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	public void testPeriodic() {
	}

}
