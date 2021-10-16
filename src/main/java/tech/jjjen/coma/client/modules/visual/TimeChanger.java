package tech.jjjen.coma.client.modules.visual;

import tech.jjjen.coma.api.property.Setting;
import tech.jjjen.coma.client.modules.Module;
import tech.jjjen.coma.client.modules.ModuleManifest;

@ModuleManifest(label = "TimeChanger", category = Module.Category.VISUAL, listen = false, color = 0x9966ff)
public final class TimeChanger extends Module {

    public final Setting<Integer> timeSetting = register(new Setting<>("Time", 12000, 0, 23000));

    public static TimeChanger INSTANCE; //pasted from Pooloo

    public TimeChanger() {
        INSTANCE = this;
    }

}
