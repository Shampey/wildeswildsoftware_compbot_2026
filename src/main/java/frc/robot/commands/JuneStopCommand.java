package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.JuneVibesSubsystem;

public class JuneStopCommand extends Command {
    JuneVibesSubsystem juneVibes;

    public JuneStopCommand(JuneVibesSubsystem juneVibes) {
        this.juneVibes = juneVibes;
        addRequirements(juneVibes);
    }

    @Override
    public void execute() {
        juneVibes.stop();
    }
}
