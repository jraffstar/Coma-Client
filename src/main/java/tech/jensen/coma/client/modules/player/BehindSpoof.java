package tech.jensen.coma.client.modules.player;

import tech.jensen.coma.TrollGod;
import tech.jensen.coma.api.property.Setting;
import tech.jensen.coma.client.events.UpdateEvent;
import tech.jensen.coma.client.modules.Module;
import tech.jensen.coma.client.modules.ModuleManifest;
import tcb.bces.listener.Subscribe;

@ModuleManifest(label="BehindSpoof", category=Module.Category.PLAYER)
public class BehindSpoof
extends Module {
    private final Setting<Boolean> onlyOnBackwards = this.register( new Setting <> ( "Require Movement" , true ));

    @Subscribe
    public void onUpdate(UpdateEvent event) {
        if (event.getStage() == 1) {
            return;
        }
        if ( this.onlyOnBackwards.getValue ( ) && !this.mc.gameSettings.keyBindBack.isKeyDown()) {
            return;
        }
        TrollGod.INSTANCE.getRotationManager().setPlayerRotations((this.mc.player.rotationYaw + 180.0f) % 360.0f, this.mc.player.rotationPitch);
    }
}

