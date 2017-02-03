package org.usfirst.frc.team2832.robot.subsystems;

import org.usfirst.frc.team2832.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

	private CANTalon winchMotor;
    private DoubleSolenoid latch;
    private static Climber _climber;
    
    public static Climber getClimber(){
    	if (_climber==null){
    		_climber= new Climber();
    		return _climber;
    	}
    	return _climber;
    	
    }
    
    public Climber(){
    	winchMotor =  new CANTalon(RobotMap.climberMotorChannel);
    	winchMotor.changeControlMode(TalonControlMode.PercentVbus);
    	setPower(0);
    	latch = new DoubleSolenoid(RobotMap.CLIMBER_LATCH_FORWARD, RobotMap.CLIMBER_LATCH_REVERSE);
    	closeLatch();
    }
    

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setPower(double power) {
    	winchMotor.set(power);
    }
    
    
    
    public double getSpeed() {
    	return winchMotor.get();
    }
    
    public void openLatch() {    	
    		latch.set(Value.kForward);
    	
    }
    
    public void closeLatch() {
    	latch.set(Value.kReverse);
    }
}

