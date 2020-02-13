/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.RobotMap;
import frc.robot.commands.driveCartesian;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  WPI_TalonSRX leftFrontTalon = null;
  WPI_TalonSRX leftRearTalon = null;
  WPI_TalonSRX rightFrontTalon = null;
  WPI_TalonSRX rightRearTalon = null;
  MecanumDrive mecanumDrive;
public Object Drivetrain;

  public Drivetrain(){
    leftFrontTalon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_LEFT_FRONT_TALON);
    leftRearTalon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_LEFT_REAR_TALON);
    rightFrontTalon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_RIGHT_FRONT_TALON);
    rightRearTalon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_RIGHT_REAR_TALON);

    WPI_TalonSRX leftFrontTalon2 = leftFrontTalon;
    WPI_TalonSRX leftRearTalon2 = leftRearTalon;
    WPI_TalonSRX rightFrontTalon2 = rightFrontTalon;
    WPI_TalonSRX rightRearTalon2 = rightRearTalon;
    
    mecanumDrive = new MecanumDrive(leftFrontTalon2, leftRearTalon2, rightFrontTalon2, rightRearTalon2);
  }

  public void DriveCartesian(double ySpeed,double xSpeed,double zRotation){
    
    mecanumDrive.driveCartesian(-ySpeed, xSpeed, zRotation);
    System.out.println("y axis value is" +ySpeed); // 2-11-20 Opt-In
    System.out.println("x axis value is" +xSpeed); // 2-11-20 Opt-In
    System.out.println("Rotation value is" +zRotation); // 2-11-20 Opt-In
  }



  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new driveCartesian());
  }
}
