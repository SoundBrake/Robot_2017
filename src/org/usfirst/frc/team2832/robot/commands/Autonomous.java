package org.usfirst.frc.team2832.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous extends CommandGroup {

    public Autonomous() {
    	addSequential(new MoveForward(0.5));
    }
}
