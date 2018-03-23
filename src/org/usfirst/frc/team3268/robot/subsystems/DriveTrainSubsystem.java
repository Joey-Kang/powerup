/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3268.robot.subsystems;

import org.usfirst.frc.team3268.robot.RobotMap;
import org.usfirst.frc.team3268.robot.commands.manual.tankDrive.ManualDriveCommand_v1;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveTrainSubsystem extends Subsystem {

	Talon driveLeftFront;
	Talon driveLeftBack;
	Talon driveRightFront;
	Talon driveRightBack;
	SpeedControllerGroup driveLeft;
	SpeedControllerGroup driveRight;
	public DifferentialDrive driveTrain;
	
	public DriveTrainSubsystem() {
		// all declaration of actual stuff
		driveLeftFront 	= new Talon(RobotMap.PWM_driveLeftFront);
		driveLeftBack 	= new Talon(RobotMap.PWM_driveLeftBack);
		driveRightFront	= new Talon(RobotMap.PWM_driveRightFront);
		driveRightBack 	= new Talon(RobotMap.PWM_driveRightBack);
		driveLeft	= new SpeedControllerGroup(driveLeftFront, driveLeftBack);
		driveRight	= new SpeedControllerGroup(driveRightFront, driveRightBack);
		driveLeft.setInverted(true);
		driveRight.setInverted(true);
		driveTrain = new DifferentialDrive(driveLeft, driveRight);
	}
	
	public void arcadeDrive(double speed, double heading) {
		driveTrain.arcadeDrive(speed, heading);
	}
	
	public void tankDrive(double left, double right) {
		driveTrain.tankDrive(left, right);
	}
	
	public void stop() {
		driveTrain.stopMotor();
	}
	
	public void initDefaultCommand() {
		setDefaultCommand(new ManualDriveCommand_v1());
	}
}
