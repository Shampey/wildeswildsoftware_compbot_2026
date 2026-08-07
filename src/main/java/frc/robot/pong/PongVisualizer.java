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
    //making new mechanismRoot2d's for the score
    private final MechanismRoot2d lTopRoot = court.getRoot("lTopRoot", 50, 50);
    private final MechanismRoot2d lMidRoot = court.getRoot("lMidRoot", 50, 45);
    private final MechanismRoot2d lBotRoot = court.getRoot("lBotRoot", 50, 40);
    private final MechanismRoot2d lTopRRoot = court.getRoot("lTopRRoot", 54, 46);
    private final MechanismRoot2d lBotRRoot = court.getRoot("lBotRRoot", 54, 41);
    private final MechanismRoot2d lTopLRoot = court.getRoot("lTopLRoot", 49, 46);
    private final MechanismRoot2d lBotLRoot = court.getRoot("lBotLRoot", 49, 41);

    //right side score
    private final MechanismRoot2d rTopRoot = court.getRoot("rTopRoot", 70, 50);
    private final MechanismRoot2d rMidRoot = court.getRoot("rMidRoot", 70, 45);
    private final MechanismRoot2d rBotRoot = court.getRoot("rBotRoot", 70, 40);
    private final MechanismRoot2d rTopRRoot = court.getRoot("rTopRRoot", 74, 46);
    private final MechanismRoot2d rBotRRoot = court.getRoot("rBotRRoot", 74, 41);
    private final MechanismRoot2d rTopLRoot = court.getRoot("rTopLRoot", 69, 46);
    private final MechanismRoot2d rBotLRoot = court.getRoot("rBotLRoot", 69, 41);



    private final MechanismLigament2d leftPaddle;
    private final MechanismLigament2d rightPaddle;
    private final MechanismLigament2d ball;
    //also scores
    private final MechanismLigament2d lTop;
    private final MechanismLigament2d lMid;
    private final MechanismLigament2d lBot;
    private final MechanismLigament2d lTopR;
    private final MechanismLigament2d lBotR;
    private final MechanismLigament2d lTopL;
    private final MechanismLigament2d lBotL; 

    //right side
    private final MechanismLigament2d rTop;
    private final MechanismLigament2d rMid;
    private final MechanismLigament2d rBot;
    private final MechanismLigament2d rTopR;
    private final MechanismLigament2d rBotR;
    private final MechanismLigament2d rTopL;
    private final MechanismLigament2d rBotL; 
    
    public PongVisualizer() {
        this.leftPaddle = leftPaddleRoot.append(new MechanismLigament2d("leftPaddle", PongConstants.PADDLE_SIZE, 90));
        this.rightPaddle = rightPaddleRoot.append(new MechanismLigament2d("rightPaddle", PongConstants.PADDLE_SIZE, 90));
        this.ball = ballRoot.append(new MechanismLigament2d("ball", PongConstants.BALL_SIZE, 90));

        this.lTop = lTopRoot.append(new MechanismLigament2d("lTop", 3, 0));
        this.lMid = lMidRoot.append(new MechanismLigament2d("lMid", 3, 0));
        this.lBot = lBotRoot.append(new MechanismLigament2d("lBot", 3, 0));
        this.lTopR = lTopRRoot.append(new MechanismLigament2d("lTopRRoot", 3, 90));
        this.lBotR = lBotRRoot.append(new MechanismLigament2d("lBotRRoot", 3, 90));
        this.lTopL = lTopLRoot. append(new MechanismLigament2d("lTopLRoot", 3, 90));
        this.lBotL = lBotLRoot. append(new MechanismLigament2d("lBotLRoot", 3, 90));

        this.rTop = rTopRoot.append(new MechanismLigament2d("rTop", 3, 0));
        this.rMid = rMidRoot.append(new MechanismLigament2d("rMid", 3, 0));
        this.rBot = rBotRoot.append(new MechanismLigament2d("rBot", 3, 0));
        this.rTopR = rTopRRoot.append(new MechanismLigament2d("rTopRRoot", 3, 90));
        this.rBotR = rBotRRoot.append(new MechanismLigament2d("rBotRRoot", 3, 90));
        this.rTopL = rTopLRoot. append(new MechanismLigament2d("rTopLRoot", 3, 90));
        this.rBotL = rBotLRoot. append(new MechanismLigament2d("rBotLRoot", 3, 90));
        
        SmartDashboard.putData("PONG", court);       
    }

    public void update(PongVisualizerData data) {
        leftPaddleRoot.setPosition(PongConstants.LEFT_PADDLE_X, PongConstants.COURT_HEIGHT / 2 - PongConstants.PADDLE_SIZE / 2 + data.leftPaddlePosition());
        rightPaddleRoot.setPosition(PongConstants.RIGHT_PADDLE_X, PongConstants.COURT_HEIGHT / 2 - PongConstants.PADDLE_SIZE / 2 + data.rightPaddlePosition());
        ballRoot.setPosition(data.ballX(), data.ballY());
        lTopRoot.setPosition(PongGame.checkForScoreShow("lTop"), 50);
        lMidRoot.setPosition(PongGame.checkForScoreShow("lMid"), 45);
        lBotRoot.setPosition(PongGame.checkForScoreShow("lBot"), 40);
        lTopRRoot.setPosition(PongGame.checkForScoreShow("lTopR"), 46);
        lBotRRoot.setPosition(PongGame.checkForScoreShow("lBotR"), 41);
        lTopLRoot.setPosition(PongGame.checkForScoreShow("lTopL"), 46);
        lBotLRoot.setPosition(PongGame.checkForScoreShow("lBotL"), 41);
    }
}