package tech.jjjen.coma.client.modules.visual;

import tech.jjjen.coma.api.property.Setting;
import tech.jjjen.coma.client.modules.Module;
import tech.jjjen.coma.client.modules.ModuleManifest;

@ModuleManifest(label = "HeadRotations", listen = false, category = Module.Category.VISUAL, color = 0x22AAAA /* do you get it ??*/)
public class HeadRotations extends Module {

    public Setting<Float> fakePitch = register(new Setting<>("Pitch", -90F, -180F, 180F));
    public Setting<Float> fakeYaw = register(new Setting<>("Yaw", -90F, -180F, 180F));

    public static HeadRotations INSTANCE;

    public HeadRotations() {
        INSTANCE = this;
    }

}
