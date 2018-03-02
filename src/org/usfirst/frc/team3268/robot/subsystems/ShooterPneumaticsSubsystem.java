/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3268.robot.subsystems;

import org.usfirst.frc.team3268.robot.commands.manual.ManualShooterPneumaticsCommand;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class ShooterPneumaticsSubsystem extends Subsystem { // #TODO
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	public static final double TRAVEL_TIME = 2.0;
	
	Compressor compressor = new Compressor();
	DoubleSolenoid shooterPiston = new DoubleSolenoid(2,1);
	
	public ShooterPneumaticsSubsystem() {
		compressor.setClosedLoopControl(true);
	}
	
	public void initDefaultCommand() {
		setDefaultCommand(new ManualShooterPneumaticsCommand());
	}
	
	public void startCompressor() {
		compressor.start();
	}
	public void stopCompressor() {
		compressor.stop();
	}
	
	public void extendShooterPiston() {
		shooterPiston.set(Value.kForward);
	}
	public void retractShooterPiston() {
		shooterPiston.set(Value.kReverse);
	}
	public void stopShooterPiston() {
		shooterPiston.set(Value.kOff);
	}
	
}
