package org.usfirst.frc2832.Robot2017.subsystems;

import org.usfirst.frc2832.Robot2017.RobotMap;
import org.usfirst.frc2832.Robot2017.commands.DefaultClimb;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *Handles Climbing
 */
public class Climber extends Subsystem {

    private CANTalon climbMotor;   
    

    public Climber() {
		super();
		climbMotor = new CANTalon(RobotMap.climberMotorChannel);
        LiveWindow.addActuator("Climbing", "Motor", climbMotor);
	}
	public Climber(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DefaultClimb());
    	
    }
    public void setClimbMotorSpeed(double speed) {
		/* speed is made negative here so that climbing up is positive, down is negative */
    	climbMotor.set(-speed);
    }
}

