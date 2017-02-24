package org.usfirst.frc2832.Robot2017.subsystems;

import org.usfirst.frc2832.Robot2017.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * Handles gear eating
 */
public class GearIntake extends Subsystem {

	public static DoubleSolenoid gearIntakeRamp;

	public GearIntake() {

		gearIntakeRamp = new DoubleSolenoid(RobotMap.doubleSolenoidForwardChannel,RobotMap.doubleSolenoidReverseChannel);
		LiveWindow.addActuator("GearIntake", "IntakeRamp", gearIntakeRamp);
	}

	public void initDefaultCommand() {

	}
}
