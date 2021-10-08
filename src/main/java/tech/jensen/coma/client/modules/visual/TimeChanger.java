package tech.jensen.coma.client.modules.visual;

import tech.jensen.coma.api.property.Setting;
import tech.jensen.coma.client.modules.Module;
import tech.jensen.coma.client.modules.ModuleManifest;

@ModuleManifest(label="TimeChanger", category=Module.Category.VISUAL, listen=false, color=0x9966FF)
public final class TimeChanger
extends Module {
    public final Setting<Integer> timeSetting = this.register( new Setting <> ( "Time" , 12000 , 0 , 23000 ));
    public static TimeChanger INSTANCE;

    public TimeChanger() {
        INSTANCE = this;
    }
}

