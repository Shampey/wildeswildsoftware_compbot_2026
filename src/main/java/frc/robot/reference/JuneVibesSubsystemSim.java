package frc.robot.subsystems;

public class JuneVibesSubsystemSim {
    private double motorPosition = 0.0;
    private double motorVelocity = 0.0;

    public void update(double voltage) {
        motorVelocity = voltage;
        motorPosition += motorVelocity;
        motorPosition %= 360;
    }

    public double getMotorPosition() {
        return motorPosition;
    }

    public double getMotorVelocity() {
        return motorVelocity;
    }
}
