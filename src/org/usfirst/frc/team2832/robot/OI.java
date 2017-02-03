package org.usfirst.frc.team2832.robot;

import org.usfirst.frc.team2832.robot.commands.Autonomous;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private Joystick joy = new Joystick(0);

	public OI() {
		

		// Create some buttons
		JoystickButton d_up = new JoystickButton(joy, 3);
		JoystickButton d_right = new JoystickButton(joy, 4);
		JoystickButton d_down = new JoystickButton(joy, 1);
		JoystickButton d_left = new JoystickButton(joy, 3);
		JoystickButton l2 = new JoystickButton(joy, 9);
		JoystickButton r2 = new JoystickButton(joy, 10);
		JoystickButton l1 = new JoystickButton(joy, 11);
		JoystickButton r1 = new JoystickButton(joy, 12);
		
		JoystickButton latchButton = new JoystickButton(joy, 10);

		
		l2.whenPressed(new Autonomous());
	}

	public Joystick getJoystick() {
		return joy;
	}
	
	public boolean getClimberPowerForwardButton(){
		return joy.getRawButton(RobotMap.JOYSTICK_BUTTON8);
	}
	
	public boolean getClimberPowerReversedButton(){
		return joy.getRawButton(RobotMap.JOYSTICK_BUTTON7);
	}
}
