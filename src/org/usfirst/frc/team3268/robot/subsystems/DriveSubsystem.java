/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3268.robot.subsystems;

import org.usfirst.frc.team3268.robot.RobotMap;
import org.usfirst.frc.team3268.robot.commands.DriveCommand;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveSubsystem extends Subsystem {

	Talon driveLeftFront;
	Talon driveLeftBack;
	Talon driveRightFront;
	Talon driveRightBack;
	SpeedControllerGroup driveLeft;
	SpeedControllerGroup driveRight;
	DifferentialDrive driveTrain;
	
	public DriveSubsystem() {
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
	
	public void tankDrive(double left, double right, boolean reverse) {
		driveTrain.tankDrive(left * (!reverse ? 1 : -1), right * (!reverse ? 1 : -1));
	}
	
	public void arcadeDrive(double speed, double heading, boolean reverse) {
		driveTrain.arcadeDrive(speed * (!reverse ? 1 : -1), heading);
	}
	
	public void initDefaultCommand() {
		setDefaultCommand(new DriveCommand());
	}
}
