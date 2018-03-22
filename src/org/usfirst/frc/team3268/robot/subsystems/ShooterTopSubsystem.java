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
public class ShooterTopSubsystem extends Subsystem {
	
	public static final double FIRING_TIME = 0.5;
	
	Talon Talon_shooterTopLeft;
	Talon Talon_shooterTopRight;
	SpeedControllerGroup ControllerGroup_shooterTop;
	
	public ShooterTopSubsystem() {
		// all declaration of actual stuff
		Talon_shooterTopLeft 	= new Talon(RobotMap.PWM_shooterTopLeft);
		Talon_shooterTopRight 	= new Talon(RobotMap.PWM_shooterTopRight);
		Talon_shooterTopRight.setInverted(true);
		ControllerGroup_shooterTop	= new SpeedControllerGroup(Talon_shooterTopLeft, Talon_shooterTopRight);
	}
	
	public void setSpeed(double speed) {
		ControllerGroup_shooterTop.set(speed);
	}
	
	public void initDefaultCommand() {
		setDefaultCommand(null);
	}
}
