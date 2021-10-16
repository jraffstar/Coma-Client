package tech.jjjen.coma.client.command.commands;

import tech.jjjen.coma.Main;
import tech.jjjen.coma.api.util.MessageUtil;
import tech.jjjen.coma.client.command.Command;
import tech.jjjen.coma.client.command.CommandManifest;
import tech.jjjen.coma.client.modules.Module;

@CommandManifest(label = "Toggle", aliases = {"t"})
public class ToggleCommand extends Command {

    @Override
    public void execute(String[] args) {
        //fix crash
        if (args.length < 2) {
            return;
        }
        final Module module = Main.INSTANCE.getModuleManager().getModuleByLabel(args[1]);
        if (module != null) {
            module.toggle();
            MessageUtil.sendClientMessage(module.getLabel() + " has been toggled " + (module.isEnabled() ? "on" : "off"), false);
        }
    }
}
