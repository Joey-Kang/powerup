/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3268.robot;

import org.usfirst.frc.team3268.robot.commands.macros.FireShooterMacro;
import org.usfirst.frc.team3268.robot.commands.macros.PickupMacro;
import org.usfirst.frc.team3268.robot.commands.macros.SlamFireMacro;
import org.usfirst.frc.team3268.robot.commands.macros.SwitchFromBottomMacro;
import org.usfirst.frc.team3268.robot.commands.macros.SwitchFromTopMacro;
import org.usfirst.frc.team3268.robot.commands.shooter.SetShooterTopCommand;
import org.usfirst.frc.team3268.robot.commands.shooter.SpinShooterBottomCommand;
import org.usfirst.frc.team3268.robot.commands.shooter.SpinShooterTopCommand;

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
	
	public static Joystick prototype = new Joystick(0);
	public static Joystick stick = new Joystick(1);
	public static Joystick controller = new Joystick(2);
	
	Button scaleButton = new JoystickButton(controller, 5);
	Button switchButton = new JoystickButton(controller, 6);
	
	Button boostButton = new JoystickButton(stick, 11);
	Button fireButton = new JoystickButton(stick, 12);

//	Button switchFireFromTopButton = new JoystickButton(controller, 4);
	
	
	Button bottomUpButton = new JoystickButton(controller, 1);
	Button bottomDownButton = new JoystickButton(controller, 2);
	Button topDownButton = new JoystickButton(controller, 3);
	
//	Button switchFromBottomButton = new JoystickButton(stick, 11);
	Button switchFromTopButton = new JoystickButton(controller, 4);
	Button slamFireButton = new JoystickButton(stick, 10);
	Button pickupButton = new JoystickButton(stick, 2);
	
	public OI() {
		
		scaleButton.whenPressed(new SetShooterTopCommand(1));
		scaleButton.whenReleased(new FireShooterMacro());
		
		switchButton.whenPressed(new SetShooterTopCommand(0.65));
		switchButton.whenReleased(new FireShooterMacro());
		
//		switchFireFromTopButton.whenPressed(new SwitchFromTopMacro());
		
		bottomUpButton.whileHeld(new SpinShooterBottomCommand(0.6));
		bottomDownButton.whileHeld(new SpinShooterBottomCommand(-0.6));
		slamFireButton.whenPressed(new SlamFireMacro());
		topDownButton.whileHeld(new SpinShooterTopCommand(-0.6));
		
		
//		// prototype
//		switchFromBottomButton.whenPressed(new SwitchFromBottomMacro());
		switchFromTopButton.whenPressed(new SwitchFromTopMacro());
		pickupButton.whenPressed(new PickupMacro());
//		
	}
	
}
