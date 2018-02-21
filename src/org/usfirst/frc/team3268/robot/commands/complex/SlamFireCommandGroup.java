/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3268.robot.commands.complex;

import org.usfirst.frc.team3268.robot.OI;
import org.usfirst.frc.team3268.robot.commands.pneumatic.LowerShooterCommand;
import org.usfirst.frc.team3268.robot.commands.pneumatic.RaiseShooterCommand;
import org.usfirst.frc.team3268.robot.commands.shooter.ChargeShooterBottomCommand;
import org.usfirst.frc.team3268.robot.commands.shooter.ChargeShooterTopCommand;
import org.usfirst.frc.team3268.robot.commands.shooter.StopShooterCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * An example command.  You can replace me with your own command.
 */
public class SlamFireCommandGroup extends CommandGroup {
	
	public SlamFireCommandGroup() {
		if (OI.rightStick.getRawButton(2)) addSequential(new RaiseShooterCommand());
		addParallel(new ChargeShooterTopCommand());
		addParallel(new ChargeShooterBottomCommand());
		addSequential(new LowerShooterCommand());
		
		addSequential(new StopShooterCommand());
	}
	
}
