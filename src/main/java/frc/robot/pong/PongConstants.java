package frc.robot.pong;

public class PongConstants {
    // arbitrary values
    public static double COURT_HEIGHT = 50;
    public static double COURT_WIDTH = 50;

    // arbitrary values as well
    public static double LEFT_PADDLE_X = 5;
    public static double RIGHT_PADDLE_X = 45;
    public static double PADDLE_SIZE = 10.0;

    // the below values are not realistic, but I picked them becase
    // they made the paddles move intuitively. feel free to change
    // and see what happens!!
    public static double PADDLE_KV = 10.0;
    public static double PADDLE_MAX_VOLTAGE = 10.0;

    // ball constants! again, try changing them if you want to
    // see some fun results.
    public static double BALL_SIZE = 1.0;
    public static double BALL_SPEED = 0.25;

    public static double UNITS_PER_ROTATION = 3.0;
}
