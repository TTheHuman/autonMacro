// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import frc.robot.commands.driveCommand;
import frc.robot.subsystems.driveSubsystem;

public class RobotContainer {
  private final int autoNumber = 1;
  private final driveSubsystem m_drive = new driveSubsystem();
  private final CommandJoystick stick1 = new CommandJoystick(0);
  private final CommandJoystick stick2 = new CommandJoystick(1);
  public RobotContainer() {
    m_drive.setDefaultCommand(new driveCommand(m_drive,      
    () -> Math.pow(stick1.getRawAxis(1) * .9, 3),       // Translation (Y)
    () -> -Math.pow(stick1.getRawAxis(0) * .9, 3),      // Strafe (X)
    () -> -Math.pow((stick2.getRawAxis(0) * .9), 3)));  // Rotation (Z)
    configureBindings();
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
