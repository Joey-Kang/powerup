/*----------------------------------------------------------------------------*/
/* CopyBottom (c) 2017-2018 FIRST. All Bottoms Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3268.robot.subsystems;

import org.usfirst.frc.team3268.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Used to declare and manipulate the four wheeled motors on the shooter mechanism.
 */
public class ShooterBottomSubsystem extends Subsystem {
	
	Talon Talon_shooterBottomLeft;
	Talon Talon_shooterBottomRight;
	SpeedControllerGroup ControllerGroup_shooterBottom;
	
	public ShooterBottomSubsystem() {
		Talon_shooterBottomLeft	= new Talon(RobotMap.PWM_shooterBottomLeft);
		Talon_shooterBottomRight 	= new Talon(RobotMap.PWM_shooterBottomRight);
		Talon_shooterBottomLeft.setInverted(true);
		ControllerGroup_shooterBottom	= new SpeedControllerGroup(Talon_shooterBottomLeft, Talon_shooterBottomRight);
	}

	public void setSpeed(double speed) {
		ControllerGroup_shooterBottom.set(speed);
	}
	
	public void initDefaultCommand() {
		setDefaultCommand(null);
	}
}
