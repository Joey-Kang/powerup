package org.usfirst.frc.team3268.robot.commands.shooter;

import org.usfirst.frc.team3268.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class StartShooterBottomCommand extends Command {
	
	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.shooterSubsystem.setBottom(1);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.shooterSubsystem.setBottom(0);
	}
}
