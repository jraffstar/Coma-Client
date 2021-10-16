package tech.jjjen.coma.client.modules.player;

import tech.jjjen.coma.api.property.Setting;
import tech.jjjen.coma.client.modules.Module;
import tech.jjjen.coma.client.modules.ModuleManifest;

@ModuleManifest(label = "AntiVoid", listen = false, category = Module.Category.PLAYER)
public class AntiVoid extends Module {

    public final Setting<Integer> height = register(new Setting<>("height", 255, 0, 255));
    public final Setting<Boolean> flag = register(new Setting<>("Flag", false));

    public static AntiVoid INSTANCE;

    public AntiVoid() {
        INSTANCE = this;
    }

}

