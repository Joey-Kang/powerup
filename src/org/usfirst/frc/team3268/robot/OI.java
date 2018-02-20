/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3268.robot;

import org.usfirst.frc.team3268.robot.commands.pneumatic.LowerShooterCommand;
import org.usfirst.frc.team3268.robot.commands.pneumatic.RaiseShooterCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	
	public static Joystick stickLeft 	= new Joystick(0);
	public static Joystick stickRight	= new Joystick(1);
	public static Joystick controller	= new Joystick(2);
	
	public static Button buttonShooterTop 		= new JoystickButton(controller, OIMap.buttonShooterTop);
	public static Button buttonShooterBottom 	= new JoystickButton(controller, OIMap.buttonShooterBottom);
	public static Button buttonLowerShooter 	= new JoystickButton(controller, OIMap.buttonShooterMoveDown);
	public static Button buttonRaiseShooter 	= new JoystickButton(controller, OIMap.buttonShooterMoveUp);
	
	public OI() {
		buttonLowerShooter.whenPressed(new LowerShooterCommand());
		buttonRaiseShooter.whenPressed(new RaiseShooterCommand());
	}
}
