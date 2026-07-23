package frc.robot.pong;

public class PongGame {
    private final PaddleSubsystem leftPaddle;
    private final PaddleSubsystem rightPaddle;

    private double ballX = PongConstants.COURT_WIDTH / 2;
    private double ballY = PongConstants.COURT_HEIGHT / 2;
    private boolean ballDirectionX = true;
    private double ballVelocityY = PongConstants.BALL_SPEED;

    private int leftScore = 0;
    private int rightScore = 0;

    public PongGame(PaddleSubsystem leftPaddle, PaddleSubsystem rightPaddle) {
        this.leftPaddle = leftPaddle;
        this.rightPaddle = rightPaddle;
    }

    /**
     * Called once per frame. This is where ball movement, wall bouncing,
     * and paddle collision will eventually live.
     */
    public void update() {
        updateBall();
    }

    private void updateBall() {
        ballX += ballDirectionX ? PongConstants.BALL_SPEED : -PongConstants.BALL_SPEED;
        ballY += ballVelocityY;

        // Court dimension checks
        if (ballY > PongConstants.COURT_HEIGHT || ballY < 0) {
            ballVelocityY *= -1;
        } else if (ballX < 0) {
            leftScore++;
            resetBall();
        } else if (ballX > PongConstants.COURT_WIDTH) {
            rightScore++;
            resetBall();
        }

        // Paddle collision checks
        boolean isAtLeftPaddleHeight = (Math.abs(ballY - leftPaddle.getPosition() - PongConstants.COURT_HEIGHT / 2) < PongConstants.PADDLE_SIZE / 2);
        boolean isAtRightPaddleHeight = (Math.abs(ballY - rightPaddle.getPosition() - PongConstants.COURT_HEIGHT / 2) < PongConstants.PADDLE_SIZE / 2);

        // nice variable names
        boolean isBallInRightSideOfLeftPaddle = ballX < PongConstants.LEFT_PADDLE_X + 0.5 && ballX > PongConstants.LEFT_PADDLE_X - 0.5;
        boolean isBallInLeftSideOfRightPaddle = ballX > PongConstants.RIGHT_PADDLE_X - 0.5 && ballX < PongConstants.RIGHT_PADDLE_X + 0.5;

        if ((isBallInRightSideOfLeftPaddle && isAtLeftPaddleHeight) || (isBallInLeftSideOfRightPaddle && isAtRightPaddleHeight)) {
            ballDirectionX = !ballDirectionX;
        }
    }

    public void resetBall() {
        ballX = PongConstants.COURT_WIDTH / 2;
        ballY = PongConstants.COURT_HEIGHT / 2;
        ballDirectionX = rightScore > leftScore;
        ballVelocityY = PongConstants.BALL_SPEED;
    }

    /**
     * A method to transmit game data from this game object to the visualizer.
     * You won't need to touch this for a while.
     * @return the data for the visualizer to visualize
     */
    public PongVisualizerData getVisualizerData() {
        return new PongVisualizerData(
            leftPaddle.getPosition(),
            rightPaddle.getPosition(), ballX, ballY, 0, 0
        );
    }
}