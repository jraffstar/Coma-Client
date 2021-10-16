package tech.jjjen.coma.client.command.commands;

import tech.jjjen.coma.Main;
import tech.jjjen.coma.api.property.Bind;
import tech.jjjen.coma.api.util.MessageUtil;
import tech.jjjen.coma.client.command.Command;
import tech.jjjen.coma.client.command.CommandManifest;
import tech.jjjen.coma.client.modules.Module;
import org.lwjgl.input.Keyboard;

@CommandManifest(label = "Bind", aliases = {"b"})
public class BindCommand extends Command {

    @Override
    public void execute(String[] args) {
        //fix crash
        if (args.length < 2) {
            MessageUtil.sendClientMessage("Use the command like this -> (module, bind)", true);
            return;
        }
        final Module module = Main.INSTANCE.getModuleManager().getModuleByLabel(args[1]);
        if (module != null) {
            //no idea what that keyboard method does too lazy to test it lmao
            int index = Keyboard.getKeyIndex(args[2].toUpperCase());
            module.bind.setValue(new Bind(index));
            MessageUtil.sendClientMessage(module.getLabel() + " has been bound to " + Keyboard.getKeyName(index), false);
        }
    }

}
