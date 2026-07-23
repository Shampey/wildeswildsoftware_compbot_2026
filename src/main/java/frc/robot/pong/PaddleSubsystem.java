package frc.robot.pong;

import java.util.function.DoubleSupplier;

import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PaddleSubsystem extends SubsystemBase {
    private double position = 0;
    private final TalonFX paddleMotor;

    public PaddleSubsystem(int id) {
        paddleMotor = new TalonFX(id);
    }

    public double getPosition() {
        return position;
    }

    @Override
    public void periodic() {
        var simState = paddleMotor.getSimState();
        simState.setSupplyVoltage(12.0);

        double voltage = simState.getMotorVoltage();
        double rotorVelocity = voltage * PongConstants.PADDLE_KV;
        simState.addRotorPosition(rotorVelocity * 0.02);

        position = paddleMotor.getPosition().getValueAsDouble() * PongConstants.UNITS_PER_ROTATION;
    }

    public void move(double input) {
        boolean atTop = position + PongConstants.PADDLE_SIZE / 2 >= PongConstants.COURT_HEIGHT / 2;
        boolean atBottom = position - PongConstants.PADDLE_SIZE / 2 <= -PongConstants.COURT_HEIGHT / 2;

        if ((atTop && input > 0) || (atBottom && input < 0)) {
            input = 0;
        }

        paddleMotor.setControl(new VoltageOut(1.5 * input));
    }

    public Command moveCommand(DoubleSupplier input) {
        return this.run(() -> move(input.getAsDouble()));
    }
}
