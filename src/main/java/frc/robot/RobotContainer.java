// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.ZeroPosition;

import frc.robot.commands.LowPosition;
import frc.robot.commands.MidPosition;
import frc.robot.commands.ArmSafteyPosition;
import frc.robot.commands.HighPosition;
import frc.robot.commands.ManualElevatorDrive;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

public class RobotContainer {
  ElevatorSubsystem elevSub; 
  XboxController joystick = new XboxController(OperatorConstants.JOYSTICK);
  ZeroPosition zeroCmd = new ZeroPosition(elevSub);
  ArmSafteyPosition armSafeCmd = new ArmSafteyPosition(elevSub);
  LowPosition lowCmd = new LowPosition(elevSub);
  MidPosition midCmd = new MidPosition(elevSub);
  HighPosition highCmd = new HighPosition(elevSub);
  ManualElevatorDrive manualUp = new ManualElevatorDrive(elevSub, 0.2);
  ManualElevatorDrive manualDown = new ManualElevatorDrive(elevSub, -0.2);
  
  public RobotContainer() {
   

    configureBindings();
  }

  
  private void configureBindings() {
    new JoystickButton(joystick, 2).onTrue(highCmd);
    new JoystickButton(joystick, 1).onTrue(midCmd);
    new JoystickButton(joystick, 0).onTrue(lowCmd);

    new JoystickButton(joystick, 5).whileTrue(manualUp);
    new JoystickButton(joystick, 6).whileTrue(manualDown);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}
