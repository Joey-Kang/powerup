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
public class DriveBaseSubsystem extends Subsystem {

	Talon Talon_driveLeftFront;
	Talon Talon_driveLeftBack;
	Talon Talon_driveRightFront;
	Talon Talon_driveRightBack;
	SpeedControllerGroup ControllerGroup_driveLeft;
	SpeedControllerGroup ControllerGroup_driveRight;
	DifferentialDrive DifferentialDrive_drive;
	
	public DriveBaseSubsystem() {
		// all declaration of actual stuff
		Talon_driveLeftFront 	= new Talon(RobotMap.PWM_driveLeftFront);
		Talon_driveLeftBack 	= new Talon(RobotMap.PWM_driveLeftBack);
		Talon_driveRightFront	= new Talon(RobotMap.PWM_driveRightFront);
		Talon_driveRightBack 	= new Talon(RobotMap.PWM_driveRightBack);
		ControllerGroup_driveLeft	= new SpeedControllerGroup(Talon_driveLeftFront, Talon_driveLeftBack);
		ControllerGroup_driveRight	= new SpeedControllerGroup(Talon_driveRightFront, Talon_driveRightBack);
		DifferentialDrive_drive = new DifferentialDrive(ControllerGroup_driveLeft, ControllerGroup_driveRight);
	}
	
	public void tankDrive(double left, double right) {
		DifferentialDrive_drive.tankDrive(left, right);
	}
	
	public void arcadeDrive(double speed, double heading) {
		DifferentialDrive_drive.arcadeDrive(speed, heading);
	}
	
	public void initDefaultCommand() {
		setDefaultCommand(new DriveCommand());
	}
}
