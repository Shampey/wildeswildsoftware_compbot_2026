package frc.robot.pong;

public class PongGame {
    private final PaddleSubsystem leftPaddle;
    private final PaddleSubsystemRight rightPaddle;

    public PongGame(PaddleSubsystem leftPaddle, PaddleSubsystemRight rightPaddle) {
        this.leftPaddle = leftPaddle;
        this.rightPaddle = rightPaddle;
    }

    // called once per frame. will be the home of collision logic and most of the ball behavior later
    public void update() {}

    // transmit relevant game data to the visualizer. don't worry about this yet
    public PongVisualizerData getVisualizerData() {
        return new PongVisualizerData(
            leftPaddle.getPosition(),
            rightPaddle.getPosition(), 0.0, 0.0, 0, 0
        );
    }
}