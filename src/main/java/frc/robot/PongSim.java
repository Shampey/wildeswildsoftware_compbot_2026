package frc.robot;

public class PongSim {
    private double leftPaddleHeight = 0;
    private double rightPaddleHeight = 0;

    public void update(
        boolean isLeftPaddleMovingUp,
        boolean isLeftPaddleMovingDown,
        boolean isRightPaddleMovingUp,
        boolean isRightPaddleMovingDown) {

        if (isLeftPaddleMovingUp) {
            leftPaddleHeight += 1;
        } else if (isLeftPaddleMovingDown) {
            leftPaddleHeight -= 1;
        }
        
        if (isRightPaddleMovingUp) {
            rightPaddleHeight += 1;
        } else if (isRightPaddleMovingDown) {
            rightPaddleHeight -= 1;
        }
    }
}
