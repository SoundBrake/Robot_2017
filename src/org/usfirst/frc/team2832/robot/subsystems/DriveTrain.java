package org.usfirst.frc.team2832.robot.subsystems;

import org.usfirst.frc.team2832.robot.Robot;
import org.usfirst.frc.team2832.robot.RobotMap;
import org.usfirst.frc.team2832.robot.commands.TankDriveWithJoystick;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {

	private SpeedController frontLeftMotor = new CANTalon(RobotMap.driveTrainLeftFrontChannel);
	private SpeedController rearLeftMotor = new CANTalon(RobotMap.driveTrainLeftRearChannel);
	private SpeedController frontRightMotor = new CANTalon(RobotMap.driveTrainRightFrontChannel);
	private SpeedController rearRightMotor = new CANTalon(RobotMap.driveTrainRightRearChannel);

	private Encoder leftEncoder = new Encoder(RobotMap.leftEncoderChannelA, RobotMap.leftEncoderChannelB);
	private Encoder rightEncoder = new Encoder(RobotMap.rightEncoderChannelA, RobotMap.rightEncoderChannelB);
	
	private AnalogInput rangefinder = new AnalogInput(RobotMap.rangefinderChannel);
	private AnalogGyro gyro = new AnalogGyro(RobotMap.analogGyroChannel);

	private RobotDrive drive;	

    public DriveTrain() {
		super();
		drive = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
		drive.setExpiration(0.1);
		drive.setSafetyEnabled(true);
		drive.setSensitivity(0.5);
		drive.setMaxOutput(1.0);

		// Encoders may measure differently in the real world and in
		// simulation. In this example the robot moves 0.042 barleycorns
		// per tick in the real world, but the simulated encoders
		// simulate 360 tick encoders. This if statement allows for the
		// real robot to handle this difference in devices.
		if (Robot.isReal()) {
			leftEncoder.setDistancePerPulse(0.042);
			rightEncoder.setDistancePerPulse(0.042);
		} else {
			// Circumference in ft = 4in/12(in/ft)*PI
			leftEncoder.setDistancePerPulse((4.0 / 12.0 * Math.PI) / 360.0);
			rightEncoder.setDistancePerPulse((4.0 / 12.0 * Math.PI) / 360.0);
		}
	}




	public void initDefaultCommand() {        
        setDefaultCommand(new TankDriveWithJoystick());
    }
	
	
   public void drive(double leftSpeed, double rightSpeed){
	   drive.tankDrive(leftSpeed, rightSpeed);
   }
   
   public void drive(Joystick joy){
	   drive(joy.getRawAxis(RobotMap.leftSpeedStickNumber), joy.getRawAxis(RobotMap.rightSpeedStickNumber));
   }
   
   /**
	 * @return The robots heading in degrees.
	 */
	public double getHeading() {
		return gyro.getAngle();
	}

	/**
	 * Reset the robots sensors to the zero states.
	 */
	public void reset() {
		gyro.reset();
		leftEncoder.reset();
		rightEncoder.reset();
	}

	/**
	 * @return The distance driven (average of left and right encoders).
	 */
	public double getDistance() {
		return (leftEncoder.getDistance() + rightEncoder.getDistance()) / 2;
	}

	/**
	 * @return The distance to the obstacle detected by the rangefinder.
	 */
	public double getDistanceToObstacle() {
		// Really meters in simulation since it's a rangefinder...
		return rangefinder.getAverageVoltage();
	}
   
}

