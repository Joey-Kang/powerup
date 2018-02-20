/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3268.robot.commands.pneumatic;

import org.usfirst.frc.team3268.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * An example command.  You can replace me with your own command.
 */
public class RaiseShooterCommand extends Command {
	
	public RaiseShooterCommand() {
		requires(Robot.shooterPneumaticsSubsystem);
		this.setTimeout(1.5);
	}

	protected void execute() {
		Robot.shooterPneumaticsSubsystem.retractShooterPiston();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return this.isTimedOut();
	}

	protected void end() {
		Robot.shooterPneumaticsSubsystem.stopShooterPiston();
	}

	protected void interrupted() {
		this.end();
	}
}
