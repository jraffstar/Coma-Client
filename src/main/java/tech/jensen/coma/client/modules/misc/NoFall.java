package tech.jensen.coma.client.modules.misc;

import tech.jensen.coma.client.modules.Module;
import tech.jensen.coma.client.modules.ModuleManifest;

@ModuleManifest(label="NoFall", listen=false, category=Module.Category.PLAYER)
public class NoFall
extends Module {
    public static NoFall INSTANCE;

    public NoFall() {
        INSTANCE = this;
        this.setSuffix("Packet");
    }
}

