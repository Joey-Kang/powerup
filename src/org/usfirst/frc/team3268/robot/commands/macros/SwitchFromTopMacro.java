package org.usfirst.frc.team3268.robot.commands.macros;

import org.usfirst.frc.team3268.robot.commands.pneumatic.LowerShooterCommand;
import org.usfirst.frc.team3268.robot.commands.shooter.SetShooterTopCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class SwitchFromTopMacro extends CommandGroup {
	
	public SwitchFromTopMacro() {
		addParallel(new SetShooterTopCommand(0.65));
//		addSequential(new WaitCommand(0.5));
		addParallel(new LowerShooterCommand());
		addSequential(new WaitCommand(0.65));
		addSequential(new FireShooterMacro());
	}

}
