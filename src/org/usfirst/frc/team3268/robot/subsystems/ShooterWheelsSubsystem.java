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
public class ShooterWheelsSubsystem extends Subsystem {
	
	Talon Talon_shooterTopLeft;
	Talon Talon_shooterTopRight;
	Talon Talon_shooterBottomLeft;
	Talon Talon_shooterBottomRight;
	SpeedControllerGroup ControllerGroup_shooterTop;
	SpeedControllerGroup ControllerGroup_shooterBottom;
	
	public ShooterWheelsSubsystem() {
		// all declaration of actual stuff
		Talon_shooterTopLeft 	= new Talon(RobotMap.PWM_shooterTopLeft);
		Talon_shooterTopRight 	= new Talon(RobotMap.PWM_shooterTopRight);
		Talon_shooterBottomLeft	= new Talon(RobotMap.PWM_shooterBottomLeft);
		Talon_shooterBottomRight 	= new Talon(RobotMap.PWM_shooterBottomRight);
		ControllerGroup_shooterTop	= new SpeedControllerGroup(Talon_shooterTopLeft, Talon_shooterTopRight);
		ControllerGroup_shooterBottom	= new SpeedControllerGroup(Talon_shooterBottomLeft, Talon_shooterBottomRight);
	}
	
	public void setTop(double speed) {
		ControllerGroup_shooterTop.set(speed);
	}
	public void setBottom(double speed) {
		ControllerGroup_shooterBottom.set(speed);
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
