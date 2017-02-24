// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2832.Robot2017.subsystems;

import org.usfirst.frc2832.Robot2017.RobotMap;
import org.usfirst.frc2832.Robot2017.commands.Drive;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;


/**
 *Handles drive train
 */
public class DriveTrain extends Subsystem {
	public CANTalon driveTrainLeftFront; 
	public CANTalon driveTrainRightFront; 
	public CANTalon driveTrainLeftRear; 
	public CANTalon driveTrainRightRear;
	public RobotDrive robotDrive; 
	
	
	
	public DriveTrain() {
		
		driveTrainLeftFront = new CANTalon(RobotMap.driveTrainLeftFrontChannel);
        LiveWindow.addActuator("DriveTrain", "LeftFront", driveTrainLeftFront);
        driveTrainRightFront = new CANTalon(RobotMap.driveTrainRightFrontChannel);
        LiveWindow.addActuator("DriveTrain", "RightFront", driveTrainRightFront);
        driveTrainLeftRear = new CANTalon(RobotMap.driveTrainLeftRearChannel);
        driveTrainLeftRear.changeControlMode(TalonControlMode.Follower);
        driveTrainLeftRear.set(driveTrainLeftFront.getDeviceID());
        LiveWindow.addActuator("DriveTrain", "LeftRear", driveTrainLeftRear);
        driveTrainRightRear = new CANTalon(RobotMap.driveTrainRightRearChannel);
        driveTrainRightRear.changeControlMode(TalonControlMode.Follower);
        driveTrainRightRear.set(driveTrainRightFront.getDeviceID());
        driveTrainRightRear.reverseOutput(false);
        LiveWindow.addActuator("DriveTrain", "RightRear", driveTrainRightRear);
        
        driveTrainLeftFront.setInverted(true);
        driveTrainRightFront.setInverted(true);
        driveTrainLeftRear.setInverted(true);
        driveTrainRightRear.setInverted(true);
        
        robotDrive = new RobotDrive(driveTrainRightFront, driveTrainLeftFront);
        robotDrive.setSafetyEnabled(true);
        robotDrive.setExpiration(0.1);
        robotDrive.setSensitivity(0.5);
        robotDrive.setMaxOutput(1.0);
		
	}
    

    public void initDefaultCommand() {
        
        setDefaultCommand(new Drive());
        
    }
    
    public void arcadeDrive(double speed, double turn)
    {
    	robotDrive.arcadeDrive(speed, turn);
    }
    public void tankDrive(double right, double left)
    {
    	robotDrive.tankDrive(left, right);
    }
    
    public void setBrakeMode(boolean b) {
    	driveTrainLeftFront.enableBrakeMode(b);
    	driveTrainRightFront.enableBrakeMode(b);
    	driveTrainLeftRear.enableBrakeMode(b);
    	driveTrainRightRear.enableBrakeMode(b);
    }
    
    
    public int getLeftEncPosition(){
    	return driveTrainLeftFront.getEncPosition();
    }
    
    
    public int getRightEncPosition(){
    	return driveTrainRightFront.getEncPosition();
    }
    
    
    public void setDriveMotorSpeed(double leftFrontMotorSpeed, double leftRearMotorSpeed, double rightFrontMotorSpeed, double rightRearMotorSpeed){
    
    	driveTrainLeftFront.set(leftFrontMotorSpeed);
    	driveTrainRightFront.set(rightFrontMotorSpeed); 
    	driveTrainLeftRear.set(leftRearMotorSpeed);
    	driveTrainRightRear.set(rightRearMotorSpeed);
    	
    
    }
    
}


