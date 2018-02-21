/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3268.robot.commands.pneumatic;

import org.usfirst.frc.team3268.robot.Robot;
import org.usfirst.frc.team3268.robot.subsystems.Position;

import edu.wpi.first.wpilibj.command.Command;

/**
 * An example command.  You can replace me with your own command.
 */
public class MoveShooterCommand extends Command {
	
	Position goalPosition;
	public MoveShooterCommand(Position position) {
		requires(Robot.shooterPneumaticsSubsystem);
		this.setTimeout(1.5);
		goalPosition = position;
	}

	protected void execute() {
		Robot.shooterPneumaticsSubsystem.setShooterPosition(goalPosition);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return this.isTimedOut();
	}

	protected void end() {
		Robot.shooterPneumaticsSubsystem.setShooterPosition(null);
		Robot.shooterPneumaticsSubsystem.position = goalPosition;
	}

	protected void interrupted() {
		this.end();
	}
}
