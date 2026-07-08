package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.JulyVibesSubsystem;
import frc.robot.subsystems.JuneVibesSubsystem;

public class JulyStopCommand extends Command {
    JulyVibesSubsystem julyVibes;

    public JulyStopCommand(JulyVibesSubsystem julyVibes) {
        this.julyVibes = julyVibes;
        addRequirements(julyVibes);
    }

    @Override
    public void execute() {
        julyVibes.stop();
    }
}