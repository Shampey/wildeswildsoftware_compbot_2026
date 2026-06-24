package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.JuneVibesSubsystem;

public class JuneVibesCommand extends Command {
    JuneVibesSubsystem juneVibes;

    public JuneVibesCommand(JuneVibesSubsystem subsystem) {
        this.juneVibes = subsystem;
        addRequirements(juneVibes);
    }

    @Override
    public void initialize() {
        System.out.println("INITIALIZE");
    }

    @Override
    public void execute() {
        juneVibes.changeMessage("JUNE VIBES COMMAND WAS HERE********************************");
        System.out.println("EXECUTING COMMAND");
    }
}
