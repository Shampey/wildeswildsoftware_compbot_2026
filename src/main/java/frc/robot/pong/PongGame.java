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
    public static boolean lTTopShow;
    public static boolean lTMidShow;
    public static boolean lTBotShow;
    public static boolean lTTopRShow;
    public static boolean lTBotRShow;
    public static boolean lTTopLShow;
    public static boolean lTBotLShow;

    public static boolean rTopShow;
    public static boolean rMidShow;
    public static boolean rBotShow;
    public static boolean rTopRShow;
    public static boolean rBotRShow;
    public static boolean rTopLShow;
    public static boolean rBotLShow;
    public static boolean rTTopShow;
    public static boolean rTMidShow;
    public static boolean rTBotShow;
    public static boolean rTTopRShow;
    public static boolean rTBotRShow;
    public static boolean rTTopLShow;
    public static boolean rTBotLShow;

    public int leftScore;
    public int leftTens = leftScore - leftScore % 10;
    public int rightScore;
    public int rightOnes = rightScore - rightScore % 10;

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

        if (leftScore % 10 == 0) {
            lTopShow = true;
            lMidShow = false;    
            lBotShow = true;
            lTopRShow = true;
            lBotRShow = true;
            lTopLShow = true;
            lBotLShow = true;
        } else if(leftScore % 10 == 1) {
            lTopShow = false;
            lMidShow = false;    
            lBotShow = false;
            lTopRShow = true;
            lBotRShow = true;
            lTopLShow = false;
            lBotLShow = false;
        } else if (leftScore % 10 == 2) {
            lTopShow = true;
            lMidShow = true;    
            lBotShow = true;
            lTopRShow = true;
            lBotRShow = false;
            lTopLShow = false;
            lBotLShow = true;
        } else if (leftScore % 10 == 3) {
            lTopShow = true;
            lMidShow = true;    
            lBotShow = true;
            lTopRShow = true;
            lBotRShow = true;
            lTopLShow = false;
            lBotLShow = false;
        } else if (leftScore % 10 == 4) {
            lTopShow = false;
            lMidShow = true;    
            lBotShow = false;
            lTopRShow = true;
            lBotRShow = true;
            lTopLShow = true;
            lBotLShow = false;
        } else if (leftScore % 10 == 5) {
            lTopShow = true;
            lMidShow = true;    
            lBotShow = true;
            lTopRShow = false;
            lBotRShow = true;
            lTopLShow = true;
            lBotLShow = false;
        } else if (leftScore % 10 == 6) {
            lTopShow = true;
            lMidShow = true;    
            lBotShow = true;
            lTopRShow = false;
            lBotRShow = true;
            lTopLShow = true;
            lBotLShow = true;
        } else if (leftScore % 10 == 7) {
            lTopShow = true;
            lMidShow = false;    
            lBotShow = false;
            lTopRShow = true;
            lBotRShow = true;
            lTopLShow = false;
            lBotLShow = false;
        } else if (leftScore % 10 == 8) {
            lTopShow = true;
            lMidShow = true;    
            lBotShow = true;
            lTopRShow = true;
            lBotRShow = true;
            lTopLShow = true;
            lBotLShow = true;
        } else if (leftScore % 10 == 9) {
            lTopShow = true;
            lMidShow = true;    
            lBotShow = true;
            lTopRShow = true;
            lBotRShow = true;
            lTopLShow = true;
            lBotLShow = false;
            
        } 
        //__________________________-
        if (leftScore - leftScore % 10 == 0) {
            lTTopShow = true;
            lTMidShow = false;    
            lTBotShow = true;
            lTTopRShow = true;
            lTBotRShow = true;
            lTTopLShow = true;
            lTBotLShow = true;
        } else if(leftScore - leftScore % 10 == 10) {
            lTTopShow = false;
            lTMidShow = false;    
            lTBotShow = false;
            lTTopRShow = true;
            lTBotRShow = true;
            lTTopLShow = false;
            lTBotLShow = false;
        } else if (leftScore - leftScore % 10 == 20) {
            lTTopShow = true;
            lTMidShow = true;    
            lTBotShow = true;
            lTTopRShow = true;
            lTBotRShow = false;
            lTTopLShow = false;
            lTBotLShow = true;
        } else if (leftScore - leftScore % 10 == 30) {
            lTTopShow = true;
            lTMidShow = true;    
            lTBotShow = true;
            lTTopRShow = true;
            lTBotRShow = true;
            lTTopLShow = false;
            lTBotLShow = false;
        } else if (leftScore - leftScore % 10 == 40) {
            lTTopShow = false;
            lTMidShow = true;    
            lTBotShow = false;
            lTTopRShow = true;
            lTBotRShow = true;
            lTTopLShow = true;
            lTBotLShow = false;
        } else if (leftScore - leftScore % 10 == 50) {
            lTTopShow = true;
            lTMidShow = true;    
            lTBotShow = true;
            lTTopRShow = false;
            lTBotRShow = true;
            lTTopLShow = true;
            lTBotLShow = false;
        } else if (leftScore - leftScore % 10 == 60) {
            lTTopShow = true;
            lTMidShow = true;    
            lTBotShow = true;
            lTTopRShow = false;
            lTBotRShow = true;
            lTTopLShow = true;
            lTBotLShow = true;
        } else if (leftScore - leftScore % 10 == 70) {
            lTTopShow = true;
            lTMidShow = false;    
            lTBotShow = false;
            lTTopRShow = true;
            lTBotRShow = true;
            lTTopLShow = false;
            lTBotLShow = false;
        } else if (leftScore - leftScore % 10 == 80) {
            lTTopShow = true;
            lTMidShow = true;    
            lTBotShow = true;
            lTTopRShow = true;
            lTBotRShow = true;
            lTTopLShow = true;
            lTBotLShow = true;
        } else if (leftScore - leftScore % 10 == 90) {
            lTTopShow = true;
            lTMidShow = true;    
            lTBotShow = true;
            lTTopRShow = true;
            lTBotRShow = true;
            lTTopLShow = true;
            lTBotLShow = false;
        } else if (leftScore - leftScore % 10 == 100) {
            System.out.println("Left wins!");
        }
        //___________________________--

        if (rightScore - rightScore % 10 == 0) {
            rTopShow = true;
            rMidShow = false;    
            rBotShow = true;
            rTopRShow = true;
            rBotRShow = true;
            rTopLShow = true;
            rBotLShow = true;
        } else if(rightScore - rightScore % 10 == 10) {
            rTopShow = false;
            rMidShow = false;    
            rBotShow = false;
            rTopRShow = true;
            rBotRShow = true;
            rTopLShow = false;
            rBotLShow = false;
        } else if (rightScore - rightScore % 10 == 20) {
            rTopShow = true;
            rMidShow = true;    
            rBotShow = true;
            rTopRShow = true;
            rBotRShow = false;
            rTopLShow = false;
            rBotLShow = true;
        } else if (rightScore - rightScore % 10 == 30) {
            rTopShow = true;
            rMidShow = true;    
            rBotShow = true;
            rTopRShow = true;
            rBotRShow = true;
            rTopLShow = false;
            rBotLShow = false;
        } else if (rightScore - rightScore % 10 == 40) {
            rTopShow = false;
            rMidShow = true;    
            rBotShow = false;
            rTopRShow = true;
            rBotRShow = true;
            rTopLShow = true;
            rBotLShow = false;
        } else if (rightScore - rightScore % 10 == 50) {
            rTopShow = true;
            rMidShow = true;    
            rBotShow = true;
            rTopRShow = false;
            rBotRShow = true;
            rTopLShow = true;
            rBotLShow = false;
        } else if (rightScore - rightScore % 10 == 60) {
            rTopShow = true;
            rMidShow = true;    
            rBotShow = true;
            rTopRShow = false;
            rBotRShow = true;
            rTopLShow = true;
            rBotLShow = true;
        } else if (rightScore - rightScore % 10 == 70) {
            rTopShow = true;
            rMidShow = false;    
            rBotShow = false;
            rTopRShow = true;
            rBotRShow = true;
            rTopLShow = false;
            rBotLShow = false;
        } else if (rightScore - rightScore % 10 == 80) {
            rTopShow = true;
            rMidShow = true;    
            rBotShow = true;
            rTopRShow = true;
            rBotRShow = true;
            rTopLShow = true;
            rBotLShow = true;
        } else if (rightScore - rightScore % 10 == 90) {
            rTopShow = true;
            rMidShow = true;    
            rBotShow = true;
            rTopRShow = true;
            rBotRShow = true;
            rTopLShow = true;
            rBotLShow = false;
        } else if (rightScore - rightScore % 10 == 100) {
            System.out.println("Right wins");
        }
        //___________________________-
        if (rightScore % 10 == 0) {
            rTTopShow = true;
            rTMidShow = false;    
            rTBotShow = true;
            rTTopRShow = true;
            rTBotRShow = true;
            rTTopLShow = true;
            rTBotLShow = true;
        } else if(rightScore % 10 == 1) {
            rTTopShow = false;
            rTMidShow = false;    
            rTBotShow = false;
            rTTopRShow = true;
            rTBotRShow = true;
            rTTopLShow = false;
            rTBotLShow = false;
        } else if (rightScore % 10 == 2) {
            rTTopShow = true;
            rTMidShow = true;    
            rTBotShow = true;
            rTTopRShow = true;
            rTBotRShow = false;
            rTTopLShow = false;
            rTBotLShow = true;
        } else if (rightScore % 10 == 3) {
            rTTopShow = true;
            rTMidShow = true;    
            rTBotShow = true;
            rTTopRShow = true;
            rTBotRShow = true;
            rTTopLShow = false;
            rTBotLShow = false;
        } else if (rightScore % 10 == 4) {
            rTTopShow = false;
            rTMidShow = true;    
            rTBotShow = false;
            rTTopRShow = true;
            rTBotRShow = true;
            rTTopLShow = true;
            rTBotLShow = false;
        } else if (rightScore % 10 == 5) {
            rTTopShow = true;
            rTMidShow = true;    
            rTBotShow = true;
            rTTopRShow = false;
            rTBotRShow = true;
            rTTopLShow = true;
            rTBotLShow = false;
        } else if (rightScore % 10 == 6) {
            rTTopShow = true;
            rTMidShow = true;    
            rTBotShow = true;
            rTTopRShow = false;
            rTBotRShow = true;
            rTTopLShow = true;
            rTBotLShow = true;
        } else if (rightScore % 10 == 7) {
            rTTopShow = true;
            rTMidShow = false;    
            rTBotShow = false;
            rTTopRShow = true;
            rTBotRShow = true;
            rTTopLShow = false;
            rTBotLShow = false;
        } else if (rightScore % 10 == 8) {
            rTTopShow = true;
            rTMidShow = true;    
            rTBotShow = true;
            rTTopRShow = true;
            rTBotRShow = true;
            rTTopLShow = true;
            rTBotLShow = true;
        } else if (rightScore % 10 == 9) {
            rTTopShow = true;
            rTMidShow = true;    
            rTBotShow = true;
            rTTopRShow = true;
            rTBotRShow = true;
            rTTopLShow = true;
            rTBotLShow = false;
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
        // ______---

        if (stickName == "lTTop") {
            return (lTTopShow) ? 43 : 1000;
        }
        else if(stickName == "lTMid") {
            return (lTMidShow) ? 43: 1000;
        }
        else if (stickName == "lTBot") {
            return (lTBotShow) ? 43: 1000;
        }
        else if (stickName == "lTTopR") {
            return (lTTopRShow) ? 47: 1000;
        }
        else if (stickName == "lTBotR") {
            return (lTBotRShow) ? 47: 1000;
        }
        else if (stickName == "lTTopL") {
            return (lTTopLShow) ? 42: 1000;
        }
        else if (stickName == "lTBotL") {
            return (lTBotLShow) ? 42: 1000;
        } 
        //____
       
        if (stickName == "rTop") {
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
        //______________-
        if (stickName == "rTTop") {
            return (rTTopShow) ? 77: 1000;
        } 
        else if (stickName == "rTMid") {
            return (rTMidShow) ? 77: 1000;
        } 
        else if (stickName == "rTBot") {
            return (rTBotShow) ? 77: 1000;
        } 
        else if (stickName == "rTTopR") {
            return (rTTopRShow) ? 81: 1000;
        } 
        else if (stickName == "rTBotR") {
            return (rTBotRShow) ? 81: 1000;
        } 
        else if (stickName == "rTTopL") {
            return (rTTopLShow) ? 76: 1000;
        } 
        else if (stickName == "rTBotL") {
            return (rTBotLShow) ? 76: 1000;
        } 
        else {
            // System.out.println("Not working");
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