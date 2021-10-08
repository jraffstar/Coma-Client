package tech.jensen.coma.client.modules.misc;

import tech.jensen.coma.api.mixin.mixins.network.AccessorCPacketChatMessage;
import tech.jensen.coma.client.events.PacketEvent;
import tech.jensen.coma.client.modules.Module;
import tech.jensen.coma.client.modules.ModuleManifest;
import tech.jensen.coma.client.modules.client.ClickGui;
import net.minecraft.network.play.client.CPacketChatMessage;
import org.apache.commons.lang3.StringUtils;
import tcb.bces.listener.Subscribe;

@ModuleManifest(label="ChatSuffix", category=Module.Category.MISC)
public class ChatSuffix
extends Module {
    @Subscribe
    public void onPacketSend(PacketEvent.Send event) {
        if (event.getPacket() instanceof CPacketChatMessage) {
            AccessorCPacketChatMessage packet = (AccessorCPacketChatMessage)event.getPacket();
            if (StringUtils.startsWith( packet.getMessage() , ClickGui.getInstance().prefix.getValue() ) || StringUtils.startsWith( packet.getMessage() , "/" )) {
                return;
            }
            packet.setMessage(((CPacketChatMessage)event.getPacket()).getMessage() + " | ᴷᵃᵐⁱ⁺²");
        }
    }
}

