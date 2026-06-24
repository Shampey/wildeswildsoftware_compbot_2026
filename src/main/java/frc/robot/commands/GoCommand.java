package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.JuneVibesSubsystem;

public class GoCommand extends Command {
    JuneVibesSubsystem juneVibes;

    public GoCommand(JuneVibesSubsystem juneVibes) {
        this.juneVibes = juneVibes;
        addRequirements(juneVibes);
    }

    @Override
    public void execute() {
        juneVibes.go();
    }
}
