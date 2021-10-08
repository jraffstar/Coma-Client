package tech.jensen.coma.client.modules.movement;

import tech.jensen.coma.api.property.Setting;
import tech.jensen.coma.client.modules.Module;
import tech.jensen.coma.client.modules.ModuleManifest;

@ModuleManifest(label="Step", listen=false, category=Module.Category.MOVEMENT, color=-256)
public class Step
extends Module {
    private final Setting<Boolean> placeHolder = this.register( new Setting <> ( "PlaceHolder" , true ));

    @Override
    public void onEnable() {
        if (! this.placeHolder.getValue ( ) ) {
            this.mc.player.stepHeight = 2.0f;
        }
    }

    @Override
    public void onDisable() {
        if (! this.placeHolder.getValue ( ) ) {
            this.mc.player.stepHeight = 0.6f;
        }
    }
}

