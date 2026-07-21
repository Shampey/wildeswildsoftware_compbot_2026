// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.pong.PaddleSubsystem;
import frc.robot.pong.PongGame;
import frc.robot.pong.PongVisualizer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {
  private final PongGame game;
  private final PaddleSubsystem leftPaddle;
  private final PaddleSubsystem rightPaddle;  
  private final PongVisualizer visualizer;

  private final CommandXboxController controller = new CommandXboxController(0);

  public RobotContainer() {
    // TODO #4: construct the paddles with whatever IDs you want! 0 and 1 work well

    // wiring up the paddles into the game manager class
    game = new PongGame(leftPaddle, rightPaddle);
    // class to visualize--don't worry about this right now unless you're curious.
    visualizer = new PongVisualizer();

    // TODO #5: bind each paddle's default command to a joystick axis using the moveCommand.
    // left paddle -> controller.getLeftY
    // right paddle -> controller.getLeftX
    // the specific axes don't matter too much, just values for testing two players with one controller/keyboard
  }

  public void robotPeriodic() {
    game.update();
    visualizer.update(game.getVisualizerData());
  }

  // dont worry about this it does nothing for us right now
  public Command getAutonomousCommand() {
    return Commands.none();
  }
}
