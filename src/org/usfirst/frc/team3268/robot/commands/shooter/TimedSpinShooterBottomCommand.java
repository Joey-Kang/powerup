/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3268.robot.commands.shooter;

import org.usfirst.frc.team3268.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * An example command.  You can replace me with your own command.
 */
public class TimedSpinShooterBottomCommand extends Command {
	
	double speed;
	public TimedSpinShooterBottomCommand(double speed, double seconds) {
		requires(Robot.shooterBottom);
		this.speed = speed;
		setTimeout(seconds);
	}
	
	public void execute() {
		Robot.shooterBottom.setSpeed(speed);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isTimedOut();
	}
	
	public void end() {
		Robot.shooterBottom.setSpeed(0);
	}

}
