package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class JuneVibesSubsystem extends SubsystemBase {
    String message = "JUNE VIBES SUBSYSTEM IS PRINTING";

    @Override
    public void periodic() {
        System.out.println(message);
    }

    public void changeMessage(String newMessage) {
        this.message = newMessage;
    }
}
