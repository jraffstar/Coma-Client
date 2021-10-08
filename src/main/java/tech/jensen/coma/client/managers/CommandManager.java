package tech.jensen.coma.client.managers;

import tech.jensen.coma.TrollGod;
import tech.jensen.coma.api.util.MessageUtil;
import tech.jensen.coma.client.command.Command;
import tech.jensen.coma.client.command.commands.*;
import tech.jensen.coma.client.events.PacketEvent;
import tech.jensen.coma.client.modules.client.ClickGui;
import net.minecraft.network.play.client.CPacketChatMessage;
import org.apache.commons.lang3.StringUtils;
import tcb.bces.listener.IListener;
import tcb.bces.listener.Subscribe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommandManager
implements IListener {
    private final List<Command> commands = new ArrayList <> ( );

    @Subscribe
    public void onSendPacket(PacketEvent.Send event) {
        String message;
        if (event.getPacket() instanceof CPacketChatMessage && StringUtils.startsWith( message = ((CPacketChatMessage)event.getPacket()).getMessage() , ClickGui.getInstance().prefix.getValue() )) {
            String[] args = message.split(" ");
            String input = message.split(" ")[0].substring(1);
            for (Command command : this.commands) {
                if (!input.equalsIgnoreCase(command.getLabel()) && !this.checkAliases(input, command)) continue;
                event.setCancelled();
                command.execute(args);
            }
            if (!event.isCancelled()) {
                MessageUtil.sendClientMessage("Command " + message + " was not found!", true);
                event.setCancelled();
            }
            event.setCancelled();
        }
    }

    private boolean checkAliases(String input, Command command) {
        for (String str : command.getAliases()) {
            if (!input.equalsIgnoreCase(str)) continue;
            return true;
        }
        return false;
    }

    public void init() {
        this.register(new ToggleCommand(), new BindCommand(), new DrawnCommand(), new FriendCommand(), new SaveCommand(), new TutorialCommand());
        TrollGod.INSTANCE.getBus().register(this);
    }

    public void register(Command ... command) {
        Collections.addAll(this.commands, command);
    }

    @Override
    public boolean isListening() {
        return true;
    }
}

