package tech.jensen.coma.client.modules.misc;

import tech.jensen.coma.api.mixin.mixins.network.AccessorSPacketPlayerPosLook;
import tech.jensen.coma.client.events.PacketEvent;
import tech.jensen.coma.client.modules.Module;
import tech.jensen.coma.client.modules.ModuleManifest;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import tcb.bces.listener.Subscribe;

@ModuleManifest(label="NoRotate", category=Module.Category.MISC, color=-11870034)
public class NoRotate
extends Module {
    @Subscribe
    public void onPacket(PacketEvent.Receive event) {
        if (this.isNull()) {
            return;
        }
        if (event.getPacket() instanceof SPacketPlayerPosLook) {
            AccessorSPacketPlayerPosLook packet = (AccessorSPacketPlayerPosLook)event.getPacket();
            packet.setPitch(this.mc.player.rotationPitch);
            packet.setYaw(this.mc.player.rotationYaw);
        }
    }
}

