package org.usfirst.frc.team3268.robot.commands.macros;

import org.usfirst.frc.team3268.robot.commands.drive.DriveTrainStopCommand;
import org.usfirst.frc.team3268.robot.commands.drive.TimedArcadeDriveCommand;
import org.usfirst.frc.team3268.robot.commands.pneumatic.LowerShooterCommand;
import org.usfirst.frc.team3268.robot.commands.shooter.TimedSpinShooterBottomCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class PickupMacro extends CommandGroup {
	
	public PickupMacro() {
		
		addParallel(new TimedArcadeDriveCommand(-0.4,0,1));
		addSequential(new LowerShooterCommand());
		addSequential(new WaitCommand(0.5));
		
		addSequential(new WaitCommand(0.2));
		addParallel(new TimedSpinShooterBottomCommand(0.65,0.5));
		
		addSequential(new DriveTrainStopCommand());
		
	}
	
}
