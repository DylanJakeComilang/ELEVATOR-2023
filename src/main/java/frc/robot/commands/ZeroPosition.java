package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;

public class ZeroPosition extends CommandBase {
  ElevatorSubsystem elevSub;
  double setPoint;
  public ZeroPosition(ElevatorSubsystem elevSubystem) {
    elevSub = elevSubystem;
    setPoint = 0;
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
    if(elevSub.isAtSetpoint()){ // if setpoint is within tolerance return true
      return true;
    }
    else{ // else if not within tolerance return false
      return false;
    }
  }
}