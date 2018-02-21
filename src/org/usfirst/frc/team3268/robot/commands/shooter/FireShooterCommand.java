/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3268.robot.commands.shooter;

import org.usfirst.frc.team3268.robot.Robot;
import org.usfirst.frc.team3268.robot.subsystems.ShooterWheelsSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 * An example command.  You can replace me with your own command.
 */
public class FireShooterCommand extends Command {
	
	public FireShooterCommand() {
		requires(Robot.shooterWheelsSubsystem);
		setTimeout(ShooterWheelsSubsystem.FIRING_TIME);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.shooterWheelsSubsystem.setBottom(1);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {
		new StopShooterCommand().start();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.shooterWheelsSubsystem.setBottom(0);
	}
	
}
