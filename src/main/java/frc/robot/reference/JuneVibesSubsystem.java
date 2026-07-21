package frc.robot.subsystems;

import static edu.wpi.first.units.Units.Degrees;

import com.ctre.phoenix6.BaseStatusSignal;
import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.wpilibj.smartdashboard.Mechanism2d;
import edu.wpi.first.wpilibj.smartdashboard.MechanismLigament2d;
import edu.wpi.first.wpilibj.smartdashboard.MechanismRoot2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class JuneVibesSubsystem extends SubsystemBase {
    TalonFX motor = new TalonFX(0);
    String message = "JUNE VIBES SUBSYSTEM IS PRINTING";
    JuneVibesSubsystemSim sim = new JuneVibesSubsystemSim();

    Mechanism2d canvas = new Mechanism2d(20, 20);
    MechanismRoot2d root = canvas.getRoot("root", 10, 10);
    MechanismLigament2d line = root.append(new MechanismLigament2d("line", 5, 0));

    public JuneVibesSubsystem() {
        SmartDashboard.putData("juneVibes Sim", canvas);
    }


    @Override
    public void periodic() {
        var simState = motor.getSimState();
        sim.update(simState.getMotorVoltage());

        // line.setAngle(sim.getMotorPosition());
        root.setPosition(0, sim.getMotorPosition());

        // System.out.println("June Velocity: " + sim.getMotorVelocity());
        // System.out.println("June Position: " + sim.getMotorPosition());

        // // simState.setRotorVelocity(sim.getMotorVelocity());
        // // simState.setRawRotorPosition(sim.getMotorPosition());
    }

    public void changeMessage(String newMessage) {
        this.message = newMessage;
    }

    /* Motor Control Requests! */
    public void go() {
        this.motor.setControl(new PositionVoltage(Degrees.of(180)));
    }

    public void stop() {
        this.motor.setControl(new DutyCycleOut(0.0));
    }
}
