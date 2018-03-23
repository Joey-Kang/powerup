/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3268.robot.commands.auto;

import org.usfirst.frc.team3268.robot.commands.macros.SwitchFromTopMacro;
import org.usfirst.frc.team3268.robot.field.Field;
import org.usfirst.frc.team3268.robot.field.Side;

/**
 * An example command.  You can replace me with your own command.
 */
public class SwitchDumpAuto extends TimedMovementAuto {
	
	public SwitchDumpAuto(Side position) {
		
		super();
		
		if (position == Field.OUR_NEAR_SWITCH_SIDE)
			addSequential(new SwitchFromTopMacro());
		
	}
}
