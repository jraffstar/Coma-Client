package tech.jensen.coma.client.modules.misc;

import tech.jensen.coma.client.modules.Module;
import tech.jensen.coma.client.modules.ModuleManifest;

@ModuleManifest(label="AntiPush", listen=false, category=Module.Category.MISC, color=0x336600)
public class AntiPush
extends Module {
    public static AntiPush INSTANCE;

    public AntiPush() {
        INSTANCE = this;
    }
}

