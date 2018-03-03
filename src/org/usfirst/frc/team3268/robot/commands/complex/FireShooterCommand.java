/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3268.robot.commands.complex;

import org.usfirst.frc.team3268.robot.commands.shooter.BoostCubeCommand;
import org.usfirst.frc.team3268.robot.commands.shooter.ChargeShooterTopCommand;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * An example command.  You can replace me with your own command.
 */
public class FireShooterCommand extends CommandGroup {
	
	public FireShooterCommand() {
		addSequential(new ChargeShooterTopCommand());
		Timer.delay(1.0);
		addSequential(new BoostCubeCommand());
	}
}
