/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3268.robot.commands.macros;

import org.usfirst.frc.team3268.robot.commands.pneumatic.LowerShooterCommand;
import org.usfirst.frc.team3268.robot.commands.shooter.ChargeShooterCommand;
import org.usfirst.frc.team3268.robot.commands.shooter.StopShooterCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * An example command.  You can replace me with your own command.
 */
public class SlamFireMacro extends CommandGroup {
	
	public SlamFireMacro() {
		
		addParallel(new ChargeShooterCommand());
		addSequential(new LowerShooterCommand());
		addSequential(new WaitCommand(2.0));
		
		addSequential(new StopShooterCommand());
		
	}
	
}
