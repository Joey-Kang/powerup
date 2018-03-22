/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3268.robot.commands.manual;

import org.usfirst.frc.team3268.robot.OI;
import org.usfirst.frc.team3268.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * An example command.  You can replace me with your own command.
 */
public class ManualDriveCommand extends Command {
	
	public ManualDriveCommand() {
		// subsystem dependencies
		requires(Robot.driveTrain);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		
		double speedScale = 0.3 + (OI.stick.getRawAxis(3) + 1) * 0.6d;
		speedScale *= OI.stick.getRawButton(1) ? -1 : 1;
		
		Robot.driveTrain.driveTrain.arcadeDrive(
				OI.stick.getRawAxis(1) * speedScale, 
				-OI.stick.getRawAxis(0));
		
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}
}
