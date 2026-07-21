// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.pong.PaddleSubsystem;
import frc.robot.pong.PongGame;
import frc.robot.pong.PongVisualizer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  private final PongGame game;
  private final PaddleSubsystem leftPaddle;
  private final PaddleSubsystem rightPaddle;
  private final PongVisualizer visualizer;

  private final CommandXboxController controller =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  public RobotContainer() {
    leftPaddle = new PaddleSubsystem(0);
    rightPaddle = new PaddleSubsystem(1);
    game = new PongGame(leftPaddle, rightPaddle);
    visualizer = new PongVisualizer();

    leftPaddle.setDefaultCommand(leftPaddle.moveCommand(controller::getLeftY));
    rightPaddle.setDefaultCommand(rightPaddle.moveCommand(controller::getLeftX));
  }

  public void robotPeriodic() {
    game.update();
    visualizer.update(game.getVisualizerData());
  }
}
