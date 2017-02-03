package org.usfirst.frc.team2832.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {

	DoubleSolenoid piston1 = new DoubleSolenoid(1, 3, 4);
	DoubleSolenoid piston2 = new DoubleSolenoid(1, 5, 6);
	Solenoid latchPiston = new Solenoid(1, 2);
	DigitalInput piston1ReedSwitchFront = new DigitalInput(9);
	DigitalInput piston1ReedSwitchBack = new DigitalInput(11);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
    /**
	 * Extend both solenoids to shoot.
	 */
	public void extendBoth() {
		piston1.set(DoubleSolenoid.Value.kForward);
		piston2.set(DoubleSolenoid.Value.kForward);
	}

	/**
	 * Retract both solenoids to prepare to shoot.
	 */
	public void retractBoth() {
		piston1.set(DoubleSolenoid.Value.kReverse);
		piston2.set(DoubleSolenoid.Value.kReverse);
	}

	/**
	 * Extend solenoid 1 to shoot.
	 */
	public void extend1() {
		piston1.set(DoubleSolenoid.Value.kForward);
	}

	/**
	 * Retract solenoid 1 to prepare to shoot.
	 */
	public void retract1() {
		piston1.set(DoubleSolenoid.Value.kReverse);
	}

	/**
	 * Extend solenoid 2 to shoot.
	 */
	public void extend2() {
		piston2.set(DoubleSolenoid.Value.kReverse);
	}

	/**
	 * Retract solenoid 2 to prepare to shoot.
	 */
	public void retract2() {
		piston2.set(DoubleSolenoid.Value.kForward);
	}

	/**
	 * Turns off the piston1 double solenoid. This won't actuate anything
	 * because double solenoids preserve their state when turned off. This
	 * should be called in order to reduce the amount of time that the coils are
	 * powered.
	 */
	public void off1() {
		piston1.set(DoubleSolenoid.Value.kOff);
	}

	/**
	 * Turns off the piston1 double solenoid. This won't actuate anything
	 * because double solenoids preserve their state when turned off. This
	 * should be called in order to reduce the amount of time that the coils are
	 * powered.
	 */
	public void off2() {
		piston2.set(DoubleSolenoid.Value.kOff);
	}

	/**
	 * Release the latch so that we can shoot
	 */
	public void unlatch() {
		latchPiston.set(true);
	}

	/**
	 * Latch so that pressure can build up and we aren't limited by air flow.
	 */
	public void latch() {
		latchPiston.set(false);
	}

	/**
	 * Toggles the latch postions
	 */
	public void toggleLatchPosition() {
		latchPiston.set(!latchPiston.get());
	}

	/**
	 * @return Whether or not piston 1 is fully extended.
	 */
	public boolean piston1IsExtended() {
		return !piston1ReedSwitchFront.get();
	}

	/**
	 * @return Whether or not piston 1 is fully retracted.
	 */
	public boolean piston1IsRetracted() {
		return !piston1ReedSwitchBack.get();
	}

	/**
	 * Turns off all double solenoids. Double solenoids hold their position when
	 * they are turned off. We should turn them off whenever possible to extend
	 * the life of the coils
	 */
	public void offBoth() {
		piston1.set(DoubleSolenoid.Value.kOff);
		piston2.set(DoubleSolenoid.Value.kOff);
	}

	
    
}

