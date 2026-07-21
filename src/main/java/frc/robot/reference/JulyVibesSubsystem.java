package frc.robot.subsystems;

import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.Mechanism2d;
import edu.wpi.first.wpilibj.smartdashboard.MechanismLigament2d;
import edu.wpi.first.wpilibj.smartdashboard.MechanismRoot2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class JulyVibesSubsystem extends SubsystemBase {
    TalonFX motor = new TalonFX(3);   
    JulyVibesSubsystemSim sim = new JulyVibesSubsystemSim();
    Mechanism2d canvas = new Mechanism2d(20, 20);
    MechanismRoot2d root = canvas.getRoot("root", 10, 10);
    MechanismLigament2d line = root.append(new MechanismLigament2d("line", 5, 0));
    
    public JulyVibesSubsystem() {
        SmartDashboard.putData("julyVibes Sim", canvas);
    }

    @Override
    public void periodic() {
        // System.out.println("July Vibes Printing");

        var simState = motor.getSimState();
        sim.update(simState.getMotorVoltage());
        
        // line.setAngle(sim.getMotorPosition());
        root.setPosition(0, sim.getMotorPosition());

        // System.out.println("July Velocity: " + sim.getMotorVelocity());
        // System.out.println("July Position: " + sim.getMotorPosition());
    }

    public void go() {
        this.motor.setControl(new DutyCycleOut(1));
    }

    public void stop() {
        this.motor.setControl(new DutyCycleOut(0));
    }
}
