package frc.robot.pong;

public class PongGame {
    private final PaddleSubsystem leftPaddle;
    private final PaddleSubsystem rightPaddle;

    /* 
     * TODO #6
     * add fields to keep track of simulated ball position and movement
     * as well as player score!! not sure how to display that yet, but
     * you can print it if you want
     */

    public PongGame(PaddleSubsystem leftPaddle, PaddleSubsystem rightPaddle) {
        this.leftPaddle = leftPaddle;
        this.rightPaddle = rightPaddle;
    }

    // called once per frame. will be the home of collision logic and most of the ball behavior later
    public void update() {
        /*
         * TODO #7
         * 1. update ball position based on velocity
         * 2. court dimension checks--if the ball hits the top of the pong window
         *  (get dimensions from PongConstants), reflect its Y velocity. If it hits
         *  either side of the court, increment the relevant player's score
         * Note: make sure to respawn the ball if it goes off the screen! First to one
         * point Pong doesn't sound as good.
         */

        /*
         * TODO #8
         * Paddle Collision! 
         * 1. For a simpler solution (what I implemented), simply reflect the ball's
         *  X velocity when it hits a paddle.
         * Note: remember that the paddle coordinates are represented by [-25, 25]
         *  If you want, you can represent the ball this way too--I didn't, which
         *  made it a bit more challenging.
         * 2. (OPTIONAL) If you want a more difficult task, you could look into
         *  how Pong actually reflects the ball--it's not as simple. I believe
         *  it takes into account the paddle's velocity and where on the paddle
         *  the ball hits (farther from the center reflects at a different angle)
         */
    }

    // transmit relevant game data to the visualizer. don't worry about this yet
    public PongVisualizerData getVisualizerData() {
        return new PongVisualizerData(
            leftPaddle.getPosition(),
            rightPaddle.getPosition(), 0.0, 0.0, 0, 0
        );
    }
}