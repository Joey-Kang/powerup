/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3268.robot.commands.butterfly;

import org.usfirst.frc.team3268.robot.Robot;
import org.usfirst.frc.team3268.robot.subsystems.ButterflyWingsSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 * An example command.  You can replace me with your own command.
 */
public class CloseWingsCommand extends Command {
	
	public CloseWingsCommand() {
		requires(Robot.butterflyWingsSubsystem);
		setTimeout(ButterflyWingsSubsystem.MOVEMENT_TIME);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.butterflyWingsSubsystem.close();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.butterflyWingsSubsystem.freeze();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
	
}
