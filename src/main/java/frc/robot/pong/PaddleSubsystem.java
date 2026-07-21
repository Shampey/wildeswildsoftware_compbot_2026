package frc.robot.pong;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.controls.VoltageOut;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.Command;
import java.util.function.DoubleSupplier;

public class PaddleSubsystem extends SubsystemBase {
    // Paddle position in arbitrary "court units."
    // Represents the vertical displacement from the center of the
    // paddle's centered starting point. 0 = centered. Ranges from
    // [-COURT_HEIGHT/2 + PADDLE_SIZE/2, +COURT_HEIGHT/2 - PADDLE_SIZE/2] 
    // once clamped correctly. essentially the top and bottom of the paddle 
    // should not exceed the top and bottom of the screen.
    private double position = 0;
    private final TalonFX paddleMotor;

    // TODO #1: construct TalonFX as paddleMotor using the provided ID
    // so the constructor stops erroring!
    public PaddleSubsystem(int id) {
        
    }

    public double getPosition() {
        return position;
    }

    @Override
    // Sim motor "physics." You don't need to necessarily understand this
    // right now, but certainly ask if you're curious! It just makes it so
    // controlling the motor affects the simulation properly
    public void periodic() {
        var simState = paddleMotor.getSimState();
        simState.setSupplyVoltage(12.0);

        double voltage = simState.getMotorVoltage();
        double rotorVelocity = voltage * PongConstants.PADDLE_KV;
        simState.addRotorPosition(rotorVelocity * 0.02);

        position = paddleMotor.getPosition().getValueAsDouble() * PongConstants.UNITS_PER_ROTATION;
    }

    // Moves the paddle. Treat `input` as if it came from a joystick axis:
    // positive = up, negative = down, range roughly [-1, 1].
    // TODO #2:
    //  1. Send input to the motor using a motor control request via paddleMotor.setControl()
    //      I used a VoltageOut, but feel free to use any other control request!
    //  2. Before sending it, check position against the court bounds
    //     (PongConstants.COURT_HEIGHT, mentioned in the very top comment)
    //     and make sure the paddle doesn't move out of bounds!
    public void move(double input) {

    }

    // TODO #3: wrap the move method in a command that we can bind to a joystick.
    // Hint: this.run(() -> ...) turns a Runnable (method) into a Command tied to
    // *this* subsystem.
    public Command moveCommand(DoubleSupplier input) {

    }
}