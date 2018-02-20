package org.usfirst.frc.team3268.robot.commands.shooter;

import org.usfirst.frc.team3268.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShooterTopStopCommand extends Command {
	
	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.shooterSubsystem.setTop(0);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}
	
}
