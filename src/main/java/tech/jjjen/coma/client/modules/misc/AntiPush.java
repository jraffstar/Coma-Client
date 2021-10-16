package tech.jjjen.coma.client.modules.misc;

import tech.jjjen.coma.api.property.Setting;
import tech.jjjen.coma.client.modules.Module;
import tech.jjjen.coma.client.modules.ModuleManifest;

@ModuleManifest(label = "AntiPush", category = Module.Category.MISC, color = 0x336600)
public class AntiPush extends Module {

    public Setting<Boolean> nearbyShulkers = register(new Setting<>("Only Shulker", true));

    public static AntiPush INSTANCE;

    public AntiPush() {
        INSTANCE = this;
    }

}
