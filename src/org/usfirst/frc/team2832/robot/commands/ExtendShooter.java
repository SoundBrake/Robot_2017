package org.usfirst.frc.team2832.robot.commands;

import org.usfirst.frc.team2832.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class ExtendShooter extends TimedCommand {

	public ExtendShooter() {
		super(1);
		requires(Robot.shooter);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.shooter.extendBoth();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.shooter.retractBoth();
	}

	
}
