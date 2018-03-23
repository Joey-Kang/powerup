/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3268.robot.commands.auto;

import org.usfirst.frc.team3268.robot.commands.drive.TimedArcadeDriveCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * An example command.  You can replace me with your own command.
 */
public class TimedMovementAuto extends CommandGroup {
	
	public TimedMovementAuto() {
		addSequential(new TimedArcadeDriveCommand(0.5,0,6.0));
	}
	
}
