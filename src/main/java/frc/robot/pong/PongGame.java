package frc.robot.pong;

import edu.wpi.first.wpilibj.smartdashboard.MechanismRoot2d;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;

public class PongGame {
    private final PaddleSubsystem leftPaddle;
    private final PaddleSubsystemRight rightPaddle;
    
    public double ballX;
    public double ballY;
    
    public boolean ballGoingRight = false;
    public boolean ballGoingUp = false;

    public static boolean lTopShow;
    public static boolean lMidShow;
    public static boolean lBotShow;
    public static boolean lTopRShow;
    public static boolean lBotRShow;
    public static boolean lTopLShow;
    public static boolean lBotLShow;

    public static boolean rTopShow;
    public static boolean rMidShow;
    public static boolean rBotShow;
    public static boolean rTopRShow;
    public static boolean rBotRShow;
    public static boolean rTopLShow;
    public static boolean rBotLShow;

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
            lBotLShow = false;
        } else if (leftScore == 4) {
            lTopShow = false;
            lMidShow = true;    
            lBotShow = false;
            lTopRShow = true;
            lBotRShow = true;
            lTopLShow = true;
            lBotLShow = false;
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
            System.out.println("Left wins");
        }

        //___________________________--

        if (rightScore == 0) {
            rTopShow = true;
            rMidShow = false;    
            rBotShow = true;
            rTopRShow = true;
            rBotRShow = true;
            rTopLShow = true;
            rBotLShow = true;
        } else if(rightScore == 1) {
            rTopShow = false;
            rMidShow = false;    
            rBotShow = false;
            rTopRShow = true;
            rBotRShow = true;
            rTopLShow = false;
            rBotLShow = false;
        } else if (rightScore == 2) {
            rTopShow = true;
            rMidShow = true;    
            rBotShow = true;
            rTopRShow = true;
            rBotRShow = false;
            rTopLShow = false;
            rBotLShow = true;
        } else if (rightScore == 3) {
            rTopShow = true;
            rMidShow = true;    
            rBotShow = true;
            rTopRShow = true;
            rBotRShow = true;
            rTopLShow = false;
            rBotLShow = false;
        } else if (rightScore == 4) {
            rTopShow = false;
            rMidShow = true;    
            rBotShow = false;
            rTopRShow = true;
            rBotRShow = true;
            rTopLShow = true;
            rBotLShow = false;
        } else if (rightScore == 5) {
            rTopShow = true;
            rMidShow = true;    
            rBotShow = true;
            rTopRShow = false;
            rBotRShow = true;
            rTopLShow = true;
            rBotLShow = false;
        } else if (rightScore == 6) {
            rTopShow = true;
            rMidShow = true;    
            rBotShow = true;
            rTopRShow = false;
            rBotRShow = true;
            rTopLShow = true;
            rBotLShow = true;
        } else if (rightScore == 7) {
            rTopShow = true;
            rMidShow = false;    
            rBotShow = false;
            rTopRShow = true;
            rBotRShow = true;
            rTopLShow = false;
            rBotLShow = false;
        } else if (rightScore == 8) {
            rTopShow = true;
            rMidShow = true;    
            rBotShow = true;
            rTopRShow = true;
            rBotRShow = true;
            rTopLShow = true;
            rBotLShow = true;
        } else if (rightScore == 9) {
            rTopShow = true;
            rMidShow = true;    
            rBotShow = true;
            rTopRShow = true;
            rBotRShow = true;
            rTopLShow = true;
            rBotLShow = false;
        } else {
            System.out.println("Right wins");
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

    public static  double checkForScoreShow(String stickName) {
        if (stickName == "lTop") {
            return (lTopShow) ? 50 : 1000;
        }
        else if(stickName == "lMid") {
            return (lMidShow) ? 50: 1000;
        }
        else if (stickName == "lBot") {
            return (lBotShow) ? 50: 1000;
        }
        else if (stickName == "lTopR") {
            return (lTopRShow) ? 54: 1000;
        }
        else if (stickName == "lBotR") {
            return (lBotRShow) ? 54: 1000;
        }
        else if (stickName == "lTopL") {
            return (lTopLShow) ? 49: 1000;
        }
        else if (stickName == "lBotL") {
            return (lBotLShow) ? 49: 1000;
        } 
        //____
        //fix X coords
    //     private final MechanismRoot2d rTopRoot = court.getRoot("rTopRoot", 70, 50);
    // private final MechanismRoot2d rMidRoot = court.getRoot("rMidRoot", 70, 45);
    // private final MechanismRoot2d rBotRoot = court.getRoot("rBotRoot", 70, 40);
    // private final MechanismRoot2d rTopRRoot = court.getRoot("rTopRRoot", 74, 46);
    // private final MechanismRoot2d rBotRRoot = court.getRoot("rBotRRoot", 74, 41);
    // private final MechanismRoot2d rTopLRoot = court.getRoot("rTopLRoot", 69, 46);
    // private final MechanismRoot2d rBotLRoot = court.getRoot("rBotLRoot", 69, 41);
        else if (stickName == "rTop") {
            return (rTopShow) ? 70: 1000;
        } 
        else if (stickName == "rMid") {
            return (rMidShow) ? 70: 1000;
        } 
        else if (stickName == "rBot") {
            return (rBotShow) ? 70: 1000;
        } 
        else if (stickName == "rTopR") {
            return (rTopRShow) ? 74: 1000;
        } 
        else if (stickName == "rBotR") {
            return (rBotRShow) ? 74: 1000;
        } 
        else if (stickName == "rTopL") {
            return (rTopLShow) ? 69: 1000;
        } 
        else if (stickName == "rBotL") {
            return (rBotLShow) ? 69: 1000;
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