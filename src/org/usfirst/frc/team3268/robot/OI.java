/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3268.robot;

import org.usfirst.frc.team3268.robot.commands.complex.FireUpCommandGroup;
import org.usfirst.frc.team3268.robot.commands.complex.SlamFireCommandGroup;
import org.usfirst.frc.team3268.robot.commands.pneumatic.LowerShooterCommand;
import org.usfirst.frc.team3268.robot.commands.pneumatic.RaiseShooterCommand;
import org.usfirst.frc.team3268.robot.commands.shooter.FireShooterCommand;

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
	
	public static Joystick leftStick 	= new Joystick(0);
	public static Joystick rightStick	= new Joystick(1);
	public static Joystick controller	= new Joystick(2);
	 
	public static Button buttonLowerShooter 	= new JoystickButton(leftStick, 3);
	public static Button buttonRaiseShooter 	= new JoystickButton(leftStick, 2);
	
//	public static Button buttonChargeShooterTop 	= new JoystickButton(rightStick, OIMap.buttonChargeShooterTop);
//	public static Button buttonChargeShooterBottom 	= new JoystickButton(rightStick, OIMap.buttonChargeShooterBottom);
	public static Button buttonFireShooter 			= new JoystickButton(controller, 6);
	
	public static Button buttonFireUp = new JoystickButton(rightStick, 11);
	public static Button buttonSlamFire = new JoystickButton(rightStick, 12);
	
//	public static Button buttonOpenWings = new JoystickButton(controller,5);
//	public static Button buttonCloseWings = new JoystickButton(controller,6);
	
	public OI() {
		
		buttonLowerShooter.whenPressed(new LowerShooterCommand());
		buttonRaiseShooter.whenPressed(new RaiseShooterCommand());
		
//		buttonChargeShooterTop.whenPressed(new ChargeShooterTopCommand());
//		buttonChargeShooterTop.whenReleased(new StopShooterTopCommand());
//		buttonChargeShooterBottom.whenPressed(new ChargeShooterBottomCommand());
//		buttonChargeShooterBottom.whenReleased(new StopShooterBottomCommand());
		 
		buttonFireShooter.whenPressed(new FireShooterCommand());
		
		buttonFireUp.whenPressed(new FireUpCommandGroup());
		buttonSlamFire.whenPressed(new SlamFireCommandGroup());
		
//		buttonOpenWings.whenPressed(new OpenWingsCommand());
//		buttonCloseWings.whenPressed(new CloseWingsCommand());
		
	}
}
