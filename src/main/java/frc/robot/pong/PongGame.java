package frc.robot.pong;

public class PongGame {
    private final PaddleSubsystem leftPaddle;
    private final PaddleSubsystem rightPaddle;

    public PongGame(PaddleSubsystem leftPaddle, PaddleSubsystem rightPaddle) {
        this.leftPaddle = leftPaddle;
        this.rightPaddle = rightPaddle;
    }

    /**
     * Called once per frame. This is where ball movement, wall bouncing,
     * and paddle collision will eventually live.
     */
    public void update() {}

    /**
     * A method to transmit game data from this game object to the visualizer.
     * You won't need to touch this for a while.
     * @return the data for the visualizer to visualize
     */
    public PongVisualizerData getVisualizerData() {
        return new PongVisualizerData(
            leftPaddle.getPosition(),
            rightPaddle.getPosition(), 0.0, 0.0, 0, 0
        );
    }
}