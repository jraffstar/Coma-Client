package tech.jjjen.coma.client.command.commands;

import tech.jjjen.coma.Main;
import tech.jjjen.coma.api.util.MessageUtil;
import tech.jjjen.coma.client.command.Command;
import tech.jjjen.coma.client.command.CommandManifest;
import tech.jjjen.coma.client.modules.Module;

@CommandManifest(label = "Drawn", aliases = {"Hide", "d"})
public class DrawnCommand extends Command {

    @Override
    public void execute(String[] args) {
        if (args.length < 2) return;
        final Module module = Main.INSTANCE.getModuleManager().getModuleByLabel(args[1]);
        if (module != null) {
            module.setDrawn(!module.isHidden());
            MessageUtil.sendClientMessage(module.getLabel() + " has been " + (module.isHidden() ? "hidden" : "unhidden"), false);
        }
    }

}
