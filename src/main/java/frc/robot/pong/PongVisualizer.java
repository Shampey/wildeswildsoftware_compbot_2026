package frc.robot.pong;

import edu.wpi.first.wpilibj.smartdashboard.Mechanism2d;
import edu.wpi.first.wpilibj.smartdashboard.MechanismLigament2d;
import edu.wpi.first.wpilibj.smartdashboard.MechanismRoot2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PongVisualizer {
    private final Mechanism2d court = new Mechanism2d(PongConstants.COURT_WIDTH, PongConstants.COURT_HEIGHT);

    private final MechanismRoot2d leftPaddleRoot = court.getRoot("leftPaddleRoot", 0, PongConstants.COURT_HEIGHT / 2);
    private final MechanismRoot2d rightPaddleRoot = court.getRoot("rightPaddleRoot", PongConstants.COURT_WIDTH, PongConstants.COURT_HEIGHT / 2);
    private final MechanismRoot2d ballRoot = court.getRoot("ballRoot", PongConstants.COURT_WIDTH / 2, PongConstants.COURT_HEIGHT / 2);

    private final MechanismLigament2d leftPaddle;
    private final MechanismLigament2d rightPaddle;
    private final MechanismLigament2d ball;
    
    public PongVisualizer() {
        this.leftPaddle = leftPaddleRoot.append(new MechanismLigament2d("leftPaddle", PongConstants.PADDLE_SIZE, 90));
        this.rightPaddle = rightPaddleRoot.append(new MechanismLigament2d("rightPaddle", PongConstants.PADDLE_SIZE, 90));
        this.ball = ballRoot.append(new MechanismLigament2d("ball", PongConstants.BALL_SIZE, 90));

        SmartDashboard.putData("PONG", court);
    }

    public void update(PongVisualizerData data) {
        leftPaddleRoot.setPosition(PongConstants.LEFT_PADDLE_X, PongConstants.COURT_HEIGHT / 2 - PongConstants.PADDLE_SIZE / 2 + data.leftPaddlePosition());
        rightPaddleRoot.setPosition(PongConstants.RIGHT_PADDLE_X, PongConstants.COURT_HEIGHT / 2 - PongConstants.PADDLE_SIZE / 2 + data.rightPaddlePosition());
        ballRoot.setPosition(data.ballX(), data.ballY());
    }
}