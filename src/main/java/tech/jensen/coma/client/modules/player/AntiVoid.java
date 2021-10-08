package tech.jensen.coma.client.modules.player;

import tech.jensen.coma.api.property.Setting;
import tech.jensen.coma.client.modules.Module;
import tech.jensen.coma.client.modules.ModuleManifest;

@ModuleManifest(label="AntiVoid", listen=false, category=Module.Category.PLAYER)
public class AntiVoid
extends Module {
    public final Setting<Integer> height = this.register( new Setting <> ( "height" , 255 , 0 , 255 ));
}

