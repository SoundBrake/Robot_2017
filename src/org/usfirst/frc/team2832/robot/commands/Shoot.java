package org.usfirst.frc.team2832.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Shoot the ball at the current angle.
 */
public class Shoot extends CommandGroup {
	public Shoot() {
		addSequential(new WaitForPressure());		
		addSequential(new ExtendShooter());
	}
}
