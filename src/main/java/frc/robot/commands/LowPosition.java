package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;

public class LowPosition extends CommandBase {
  ElevatorSubsystem elevSub;
  double setPoint;
  public LowPosition(ElevatorSubsystem elevSubystem) {
    elevSub = elevSubystem;
    setPoint = -7;
    addRequirements(elevSub);
  }

  @Override
  public void initialize() {
    elevSub.init();
  }

  @Override
  public void execute(){
    elevSub.changeSetpoint(setPoint);
  }

  @Override
  public void end(boolean interrupted){

  }

  @Override
  public boolean isFinished() {
  return elevSub.isAtSetpoint() || elevSub.bottomPressed();
}
}