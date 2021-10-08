package tech.jensen.coma.client.command.commands;

import tech.jensen.coma.TrollGod;
import tech.jensen.coma.api.util.MessageUtil;
import tech.jensen.coma.client.command.Command;
import tech.jensen.coma.client.command.CommandManifest;
import tech.jensen.coma.client.modules.Module;

@CommandManifest(label="Toggle", aliases={"t"})
public class ToggleCommand
extends Command {
    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            return;
        }
        Module module = TrollGod.INSTANCE.getModuleManager().getModuleByLabel(args[1]);
        if (module != null) {
            module.toggle();
            MessageUtil.sendClientMessage(module.getLabel() + " has been toggled " + (module.isEnabled() ? "on" : "off"), false);
        }
    }
}

