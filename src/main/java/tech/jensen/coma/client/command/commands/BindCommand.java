package tech.jensen.coma.client.command.commands;

import tech.jensen.coma.TrollGod;
import tech.jensen.coma.api.property.Bind;
import tech.jensen.coma.api.util.MessageUtil;
import tech.jensen.coma.client.command.Command;
import tech.jensen.coma.client.command.CommandManifest;
import tech.jensen.coma.client.modules.Module;
import org.lwjgl.input.Keyboard;

@CommandManifest(label="Bind", aliases={"b"})
public class BindCommand
extends Command {
    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            MessageUtil.sendClientMessage("Use the command like this -> (module, bind)", true);
            return;
        }
        Module module = TrollGod.INSTANCE.getModuleManager().getModuleByLabel(args[1]);
        if (module != null) {
            int index = Keyboard.getKeyIndex( args[2].toUpperCase() );
            module.bind.setValue(new Bind(index));
            MessageUtil.sendClientMessage(module.getLabel() + " has been bound to " + Keyboard.getKeyName( index ), false);
        }
    }
}

