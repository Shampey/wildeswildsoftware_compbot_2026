package frc.robot.commands;

import java.util.Set;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.JuneVibesSubsystem;

public class JuneVibesCommand extends Command {
    JuneVibesSubsystem juneVibes;

    public JuneVibesCommand(JuneVibesSubsystem subsystem) {
        this.juneVibes = subsystem;
        addRequirements(juneVibes);
    }

    @Override
    public void execute() {
        juneVibes.changeMessage("JUNE VIBES COMMAND WAS HERE********************************");
        System.out.println("EXECUTING COMMAND");
    }
}
