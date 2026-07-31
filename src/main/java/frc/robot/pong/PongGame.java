package frc.robot.pong;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;

public class PongGame {
    private final PaddleSubsystem leftPaddle;
    private final PaddleSubsystemRight rightPaddle;
    
    public double ballX;
    public double ballY;
    
    public boolean ballGoingRight = false;
    public boolean ballGoingUp = false;

    public boolean lTopShow;
    public boolean lMidShow;
    public boolean lBotShow;
    public boolean lTopRShow;
    public boolean lBotRShow;
    public boolean lTopLShow;
    public boolean lBotLShow;

    public int leftScore;
    public int rightScore;

    /* 
     * TODO #6
     * add fields to keep track of simulated ball position and movement
     * as well as player score!! not sure how to display that yet, but
     * you can print it if you want
     */

    public PongGame(PaddleSubsystem leftPaddle, PaddleSubsystemRight rightPaddle) {
        this.leftPaddle = leftPaddle;
        this.rightPaddle = rightPaddle;
    }

    // called once per frame. will be the home of collision logic and most of the ball behavior later
    public void update() {
        if (ballGoingRight == true) {
            ballX ++;
        } else {
            ballX --;
        }

        if (ballGoingUp == true) {
            ballY ++;
        } else {
            ballY --;
        }

        if (ballY > PongConstants.COURT_HEIGHT) {
            ballGoingUp = false;
        } else if (ballY < 0) {
            ballGoingUp = true;
        }

        if (ballX > PongConstants.COURT_WIDTH / 2 + 5) {
            //right side
            ballGoingRight = false;
            ballX = 0;
            leftScore ++;
            System.out.println("right score " + rightScore);
            System.out.println(leftScore + " : " + rightScore);
        } else if (ballX < -PongConstants.COURT_WIDTH / 2 - 5) {
            //left side
            ballGoingRight = true;
            ballX = 0;
            rightScore ++;
            System.out.println("left score " + leftScore);
            System.out.println(leftScore + " : " + rightScore);
        }

        //ball bouncing off paddles
        if ((ballX <= -65 + 0.01 && ballX >= -65 - 0.01) && 
        leftPaddle.getPosition() + 25 + PongConstants.PADDLE_SIZE / 2 >= ballY && 
        leftPaddle.getPosition() + 25 - PongConstants.PADDLE_SIZE / 2 <= ballY) {
            ballGoingRight = !ballGoingRight;
        } else if ((ballX <= 65 + 0.01 - 10 && ballX >= 65 - 0.01 - 10) &&
         (rightPaddle.getPosition() + 25 + PongConstants.PADDLE_SIZE / 2 >= ballY &&
          rightPaddle.getPosition() + 25 - PongConstants.PADDLE_SIZE / 2 <= ballY)) {
            ballGoingRight = !ballGoingRight;
        
        }

        if (leftScore == 0) {
            lTopShow = true;
            lMidShow = false;    
            lBotShow = true;
            lTopRShow = true;
            lBotRShow = true;
            lTopLShow = true;
            lBotLShow = true;
        } else if(leftScore == 1) {
            lTopShow = false;
            lMidShow = false;    
            lBotShow = false;
            lTopRShow = true;
            lBotRShow = true;
            lTopLShow = false;
            lBotLShow = false;
        } else if (leftScore == 2) {
            lTopShow = true;
            lMidShow = true;    
            lBotShow = true;
            lTopRShow = true;
            lBotRShow = false;
            lTopLShow = false;
            lBotLShow = true;
        } else if (leftScore == 3) {
            lTopShow = true;
            lMidShow = true;    
            lBotShow = true;
            lTopRShow = true;
            lBotRShow = true;
            lTopLShow = false;
            lBotLShow = true;
        } else if (leftScore == 4) {
            lTopShow = false;
            lMidShow = true;    
            lBotShow = false;
            lTopRShow = true;
            lBotRShow = true;
            lTopLShow = true;
            lBotLShow = true;
        } else if (leftScore == 5) {
            lTopShow = true;
            lMidShow = true;    
            lBotShow = true;
            lTopRShow = false;
            lBotRShow = true;
            lTopLShow = true;
            lBotLShow = false;
        } else if (leftScore == 6) {
            lTopShow = true;
            lMidShow = true;    
            lBotShow = true;
            lTopRShow = false;
            lBotRShow = true;
            lTopLShow = true;
            lBotLShow = true;
        } else if (leftScore == 7) {
            lTopShow = true;
            lMidShow = false;    
            lBotShow = false;
            lTopRShow = true;
            lBotRShow = true;
            lTopLShow = false;
            lBotLShow = false;
        } else if (leftScore == 8) {
            lTopShow = true;
            lMidShow = true;    
            lBotShow = true;
            lTopRShow = true;
            lBotRShow = true;
            lTopLShow = true;
            lBotLShow = true;
        } else if (leftScore == 9) {
            lTopShow = true;
            lMidShow = true;    
            lBotShow = true;
            lTopRShow = true;
            lBotRShow = true;
            lTopLShow = true;
            lBotLShow = false;
        } else {
            
        }


        //  *  (get dimensions from PongConstants), reflect its Y velocity. If it hits
        //  *  either side of the court, increment the relevant player's score
        //  * Note: make sure to respawn the ball if it goes off the screen! First to one
        //  * point Pong doesn't sound as good.
        //  */

//         // /*
        //  * TODO #8
        //  * Paddle Collision! 
        //  * 1. For a simpler solution (what I implemented), simply reflect the ball's
        //  *  X velocity when it hits a paddle.
        //  */
    }

    public double checkForScoreShow(String stickName) {
        if (stickName == "lTop") {
            return (lTopShow) ? 50 : 1000;
        }
        if (stickName == "lMid") {
            return (lMidShow) ? 50: 1000;
        }
        else {
            System.out.println("Not working");
            return 0;
        }
        
    }

    // transmit relevant game data to the visualizer. don't worry about this yet
    public PongVisualizerData getVisualizerData() {
        return new PongVisualizerData(
            leftPaddle.getPosition(),
            rightPaddle.getPosition(),
            ballX + 70, 
            ballY, 
            leftScore,
            rightScore            
        );
    }
}