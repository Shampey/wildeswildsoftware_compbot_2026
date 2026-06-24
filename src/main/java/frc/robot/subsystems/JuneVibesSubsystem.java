package frc.robot.subsystems;

import com.ctre.phoenix6.BaseStatusSignal;
import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class JuneVibesSubsystem extends SubsystemBase {
    TalonFX motor = new TalonFX(0);
    String message = "JUNE VIBES SUBSYSTEM IS PRINTING";
    JuneVibesSubsystemSim sim = new JuneVibesSubsystemSim();

    @Override
    public void periodic() {
        var simState = motor.getSimState();
        sim.update(simState.getMotorVoltage());

        System.out.println("Velocity: " + sim.getMotorVelocity());
        System.out.println("Position: " + sim.getMotorPosition());

        // simState.setRotorVelocity(sim.getMotorVelocity());
        // simState.setRawRotorPosition(sim.getMotorPosition());
    }

    public void changeMessage(String newMessage) {
        this.message = newMessage;
    }

    /* Motor Control Requests! */
    public void go() {
        this.motor.setControl(new DutyCycleOut(1.0));
    }

    public void stop() {
        this.motor.setControl(new DutyCycleOut(0.0));
    }
}
