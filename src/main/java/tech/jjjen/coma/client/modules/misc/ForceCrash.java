package tech.jjjen.coma.client.modules.misc;

import tech.jjjen.coma.client.modules.Module;
import tech.jjjen.coma.client.modules.ModuleManifest;

@ModuleManifest(label = "ForceCrash", category = Module.Category.MISC, color = 0x00FF00)
public class ForceCrash extends Module {
    public void onEnable() {
        mc.player = null;
        this.disable();
    }
}
