package frc.robot.subsystems;

public class JulyVibesSubsystemSim {
    private double motorPosition = 0.0;
    private double motorVelocity = 0.0;

    public void update(double voltage) {
        motorVelocity = voltage * 0.05;
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
