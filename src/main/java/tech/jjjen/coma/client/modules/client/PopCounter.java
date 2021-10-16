package tech.jjjen.coma.client.modules.client;

import tech.jjjen.coma.client.modules.Module;
import tech.jjjen.coma.client.modules.ModuleManifest;

@ModuleManifest(label = "PopCounter", category = Module.Category.CLIENT, listen = false)
public class PopCounter extends Module {
    private static PopCounter INSTANCE;

    public PopCounter() {
        INSTANCE = this;
    }

    public static PopCounter getInstance() {
        return INSTANCE;
    }

}
