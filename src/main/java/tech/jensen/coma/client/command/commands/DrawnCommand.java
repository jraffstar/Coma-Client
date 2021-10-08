package tech.jensen.coma.client.command.commands;

import tech.jensen.coma.TrollGod;
import tech.jensen.coma.api.util.MessageUtil;
import tech.jensen.coma.client.command.Command;
import tech.jensen.coma.client.command.CommandManifest;
import tech.jensen.coma.client.modules.Module;

@CommandManifest(label="Drawn", aliases={"Hide", "d"})
public class DrawnCommand
extends Command {
    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            return;
        }
        Module module = TrollGod.INSTANCE.getModuleManager().getModuleByLabel(args[1]);
        if (module != null) {
            module.setDrawn(module.isHidden());
            MessageUtil.sendClientMessage(module.getLabel() + " has been " + (module.isHidden() ? "hidden" : "unhidden"), false);
        }
    }
}

