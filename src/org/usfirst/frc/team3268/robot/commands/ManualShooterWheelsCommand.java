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
public class ManualShooterWheelsCommand extends Command {
	public ManualShooterWheelsCommand() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.shooterWheelsSubsystem);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		
		double topVal = 0, bottomVal = 0;
		
//		topVal = OI.controller.getRawAxis(3);
		
		// A = slow up bottom (1)
		if (OI.controller.getRawButton(1)) bottomVal = 0.75;
		
		// B = slow down bottom (2)
		if (OI.controller.getRawButton(2)) bottomVal = -0.75;
		
		// X = slow down top (3)
		if (OI.controller.getRawButton(3)) topVal = -0.75;
		
		// Y = slow up top (4)
		if (OI.controller.getRawButton(4)) topVal = 0.75;
		
		Robot.shooterWheelsSubsystem.setTop(topVal);
		Robot.shooterWheelsSubsystem.setBottom(bottomVal);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
