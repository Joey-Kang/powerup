/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3268.robot.commands;

import org.usfirst.frc.team3268.robot.OI;
import org.usfirst.frc.team3268.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * An example command.  You can replace me with your own command.
 */
public class ManualDriveCommand extends Command {
	
	public ManualDriveCommand() {
		// subsystem dependencies
		requires(Robot.driveSubsystem);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double speedScale = 0.5 + (OI.rightStick.getRawAxis(3) + 1) / 2d;
		speedScale *= OI.rightStick.getRawButton(1) ? -1 : 1;
		
		if (!OI.rightStick.getRawButton(2)) {
			Robot.driveSubsystem.driveTrain.tankDrive(
					OI.leftStick.getRawAxis(1) * speedScale, 
					OI.rightStick.getRawAxis(1) * speedScale); 
		} else {
			Robot.driveSubsystem.driveTrain.arcadeDrive(
					OI.rightStick.getRawAxis(1) * speedScale, 
					-OI.rightStick.getRawAxis(0));
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}
}
