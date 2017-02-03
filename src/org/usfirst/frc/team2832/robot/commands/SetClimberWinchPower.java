package org.usfirst.frc.team2832.robot.commands;



import org.usfirst.frc.team2832.robot.Robot;
import org.usfirst.frc.team2832.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetClimberWinchPower extends Command {

	public SetClimberWinchPower() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.climber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.oi.getClimberPowerReversedButton()){
    		Robot.climber.setPower(RobotMap.CLIMBER_WINCH_POWER*-1);
    	}else if(Robot.oi.getClimberPowerForwardButton()){
    		Robot.climber.setPower(RobotMap.CLIMBER_WINCH_POWER);
    	}else{
    		Robot.climber.setPower(0);
    	}	

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
