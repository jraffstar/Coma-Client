package tech.jjjen.coma.client.modules.misc;

import tech.jjjen.coma.api.mixin.mixins.network.AccessorCPacketChatMessage;
import tech.jjjen.coma.client.events.PacketEvent;
import tech.jjjen.coma.client.modules.Module;
import tech.jjjen.coma.client.modules.ModuleManifest;
import net.minecraft.network.play.client.CPacketChatMessage;
import tcb.bces.listener.Subscribe;

@ModuleManifest(label = "ChatSuffix", category = Module.Category.MISC)
public class ChatSuffix extends Module {

    @Subscribe
    public void onPacketSend(PacketEvent.Send event) {
        if (event.getPacket() instanceof CPacketChatMessage) {
            AccessorCPacketChatMessage packet = (AccessorCPacketChatMessage) event.getPacket();
            packet.setMessage(((CPacketChatMessage) event.getPacket()).getMessage() + " | hiassi.su");
        }
    }

}
