package org.usfirst.frc2832.Robot2017.subsystems;

import org.usfirst.frc2832.Robot2017.Robot;
import org.usfirst.frc2832.Robot2017.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Handles the shooting
 */
public class Shooter extends Subsystem {

	public CANTalon shooterShootMotor;
    public CANTalon shooterFeeder;
    public CANTalon shooterAgitator;
	
	public Shooter() {
		super();

	shooterFeeder = new CANTalon(RobotMap.shooterFeederMotorChannel);
    LiveWindow.addActuator("Shooter", "Feeder", shooterFeeder);
    shooterFeeder.enableBrakeMode(false);
    
    shooterShootMotor = new CANTalon(RobotMap.shooterShooterMotorChannel);
    LiveWindow.addActuator("Shooter", "ShootMotor", shooterShootMotor);
    shooterShootMotor.enableBrakeMode(false);
    
    shooterAgitator = new CANTalon(RobotMap.shooterAgitatorMotorChannel);
    LiveWindow.addActuator("Shooter", "Agitator", shooterAgitator);
    shooterAgitator.enableBrakeMode(false);
	}
	
	public void trigger() {
		double speeed = Math.max(0, Math.min(100, Robot.shootSpeeed));
		shooterAgitator.set(0.2);
		shooterShootMotor.set(speeed / 100);
		SmartDashboard.putNumber("SPEEED", shooterShootMotor.getSpeed() / 1000);
		if(shooterShootMotor.getSpeed() / 1000 > speeed / 150) {
			shooterFeeder.set(0.2);
		}
	}
   

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void shooterAgitatorOff(){
    	shooterAgitator.set(0d);
    }
    
    public void shooterFeederOff(){
    	shooterFeeder.set(0.0);
    }
    
    public void shooterShootMotorOff(){
    	shooterShootMotor.set(0.0);
    }
    
    public void setShooterAgitatorMotorSpeed(double speed){
    	shooterAgitator.set(speed);
    }
    
    public void setShooterShooterMotorSpeed(double speed){
    	shooterShootMotor.set(speed);
    }
    
    public void setShooterFeederMotorSpeed(double speed){
    	shooterFeeder.set(speed);
    }
    
    public CANTalon getShooterShooterMotor(){
    	return shooterShootMotor;
    }
    
}

