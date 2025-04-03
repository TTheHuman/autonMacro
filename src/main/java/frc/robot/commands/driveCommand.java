// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.driveSubsystem;

public class driveCommand extends Command {
  public void initialize() {
  }

  private driveSubsystem m_drive;
  private DoubleSupplier x;
  private DoubleSupplier y;
  private DoubleSupplier z;

  public driveCommand(driveSubsystem driveSub, DoubleSupplier y, DoubleSupplier x, DoubleSupplier z) {
    m_drive = driveSub;
    this.z = z;
    this.y = y;
    this.x = x;

    addRequirements(m_drive);
  }

  @Override
  public void execute() {
    driveSubsystem.drive(-y.getAsDouble(), -x.getAsDouble(), -z.getAsDouble());
  }

  @Override
  public boolean isFinished() {
    return false;
  }

  @Override
  public void end(boolean interrupted) {
    driveSubsystem.drive(0.0, 0.0, 0.0);
  }
}
