package org.usfirst.frc2832.Robot2017.subsystems;

import org.usfirst.frc2832.Robot2017.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * Handles gear vomiting
 */
public class GearScore extends Subsystem {

	public static DoubleSolenoid gearScorePusher;
    public static DoubleSolenoid gearScoreDoor;
    
    public GearScore() {
    	super();
    	
        gearScorePusher = new DoubleSolenoid(RobotMap.gearScorePusherForwardChannel, RobotMap.gearScorePusherReverseChannel);
        LiveWindow.addActuator("GearScore", "Pusher", gearScorePusher);

        gearScoreDoor = new DoubleSolenoid(RobotMap.gearScoreDoorForwardChannel, RobotMap.gearScoreDoorReverseChannel);
        LiveWindow.addActuator("GearScore", "Door", gearScoreDoor);
    }
    

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

