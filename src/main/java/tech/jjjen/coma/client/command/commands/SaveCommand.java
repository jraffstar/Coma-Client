package tech.jjjen.coma.client.command.commands;

import tech.jjjen.coma.Main;
import tech.jjjen.coma.client.command.Command;
import tech.jjjen.coma.client.command.CommandManifest;

@CommandManifest(label = "Save", aliases = "s")
public class SaveCommand extends Command {

    @Override
    public void execute(String[] args) {
        Main.INSTANCE.getConfigManager().saveConfig(Main.INSTANCE.getConfigManager().config.replaceFirst("TrollGod/", ""));
    }
}
