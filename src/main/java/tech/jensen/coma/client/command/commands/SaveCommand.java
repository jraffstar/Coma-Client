package tech.jensen.coma.client.command.commands;

import tech.jensen.coma.TrollGod;
import tech.jensen.coma.client.command.Command;
import tech.jensen.coma.client.command.CommandManifest;

@CommandManifest(label="Save", aliases={"s"})
public class SaveCommand
extends Command {
    @Override
    public void execute(String[] args) {
        TrollGod.INSTANCE.getConfigManager().saveConfig(TrollGod.INSTANCE.getConfigManager().config.replaceFirst("TrollGod/", ""));
    }
}

