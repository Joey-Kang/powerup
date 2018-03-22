/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3268.robot;

import org.usfirst.frc.team3268.robot.commands.auto.SwitchDumpAuto;
import org.usfirst.frc.team3268.robot.commands.auto.TimedMovementAuto;
import org.usfirst.frc.team3268.robot.commands.shooter.ChargeShooterCommand;
import org.usfirst.frc.team3268.robot.field.Field;
import org.usfirst.frc.team3268.robot.field.Side;
import org.usfirst.frc.team3268.robot.subsystems.ButterflyWingsSubsystem;
import org.usfirst.frc.team3268.robot.subsystems.DriveTrainSubsystem;
import org.usfirst.frc.team3268.robot.subsystems.ShooterBottomSubsystem;
import org.usfirst.frc.team3268.robot.subsystems.ShooterPneumaticsSubsystem;
import org.usfirst.frc.team3268.robot.subsystems.ShooterTopSubsystem;

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
	public static final DriveTrainSubsystem driveTrain = new DriveTrainSubsystem();
	public static final ShooterTopSubsystem shooterTop = new ShooterTopSubsystem();
	public static final ShooterBottomSubsystem shooterBottom = new ShooterBottomSubsystem();
	public static final ShooterPneumaticsSubsystem shooterPneumatics = new ShooterPneumaticsSubsystem();
	public static final ButterflyWingsSubsystem butterflyWings = new ButterflyWingsSubsystem();
	public static OI oi;

	// smartDashboard & other chooser stuff
	Command autoCommand;
	SendableChooser<Command> autoChooser = new SendableChooser<>();

	
	public void robotInit() {
		
		cameraInit();
		
		oi = new OI();
		
		/* Autonomous Initiation & Declaration */
		
		autoChooser.addDefault("No Auto", null);
		autoChooser.addObject("Timed Movement", new TimedMovementAuto());
		autoChooser.addObject("Conditional Dump (Right)", new SwitchDumpAuto(Side.RIGHT));
		autoChooser.addObject("Conditional Dump (Left)", new SwitchDumpAuto(Side.LEFT));
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Autonomous", autoChooser);
	}
	public void cameraInit() {
		CameraServer.getInstance().startAutomaticCapture(0);
		CameraServer.getInstance().startAutomaticCapture(1);
	}

	public void disabledInit() {

	}
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		
		Field.init();
		
		autoCommand = autoChooser.getSelected();
		autoCommand = new TimedMovementAuto();

		if (autoCommand != null) {
			autoCommand.start();
		}
	}
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {

		if (autoCommand != null) {
			autoCommand.cancel();
		}
	}
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}
	
	public void testInit() {
		new ChargeShooterCommand().start();
//		new BoostCubeCommand().start();
	}
	public void testPeriodic() {
		
	}

}
