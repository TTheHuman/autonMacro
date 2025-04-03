// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import frc.robot.*;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class driveSubsystem extends SubsystemBase {
  private SparkMax frontRight;
  private SparkMax backRight;
  private SparkMax backLeft;
  private SparkMax frontLeft;

  private static MecanumDrive mecDrive;
  
    public driveSubsystem() {
      frontRight = new SparkMax(constants.frontRight, MotorType.kBrushless);
      backRight = new SparkMax(constants.backRight, MotorType.kBrushless);
      backLeft = new SparkMax(constants.backLeft, MotorType.kBrushless);
      frontLeft = new SparkMax(constants.frontLeft, MotorType.kBrushless);
  
      mecDrive = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);
      mecDrive.setSafetyEnabled(false);
    }
  
    public static void drive(double ySpeed, double xSpeed, double zRotation){
      mecDrive.driveCartesian(ySpeed, xSpeed, zRotation);
  }

  @Override
  public void periodic() {
  }
}
