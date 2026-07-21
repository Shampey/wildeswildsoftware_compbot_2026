package frc.robot.pong;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PaddleSubsystem extends SubsystemBase {
    private double position = PongConstants.COURT_HEIGHT / 2; // paddle starts at center

    public double getPosition() {
        return position;
    }

    /**
     * A method to move the paddle up and down! 
     *
     * The input variable will be coming from a joystick axis, where
     * positive = up and negative = down, ranging from [-1, 1]
     *
     * TODO: update position based on input scalar, then clamp so the 
     * paddle stays inside the court
     */
    public void move(double input) {

    }
}
