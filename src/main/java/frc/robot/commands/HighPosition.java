package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;

public class HighPosition extends CommandBase {
  ElevatorSubsystem elevSub;
  double setPoint;
  public HighPosition(ElevatorSubsystem elevSubystem) {
    elevSub = elevSubystem;
    setPoint = 180;
    addRequirements(elevSub);
  }

  @Override
  public void initialize() {
    elevSub.init();
   // SmartDashboard.putString("High Position", "Starting");
  }

  @Override
  public void execute(){
   // SmartDashboard.putString("High Position", "Moving");
    elevSub.changeSetpoint(setPoint);
  }

  @Override
  public void end(boolean interrupted){
   // SmartDashboard.putString("High Position", "Ending");
  }

  @Override
  public boolean isFinished() {
   // SmartDashboard.putBoolean("AtSetpoint", elevSub.isAtSetpoint());
   // SmartDashboard.putBoolean("TopPressed", elevSub.topPressed());
    return elevSub.isAtSetpoint() || elevSub.topPressed();
  }
}