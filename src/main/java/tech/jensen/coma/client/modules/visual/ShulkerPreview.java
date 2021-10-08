package tech.jensen.coma.client.modules.visual;

import tech.jensen.coma.client.modules.Module;
import tech.jensen.coma.client.modules.ModuleManifest;

@ModuleManifest(label="ShulkerPreview", listen=false, category=Module.Category.VISUAL, color=0xCC9900)
public class ShulkerPreview
extends Module {
    private static ShulkerPreview INSTANCE;

    public ShulkerPreview() {
        INSTANCE = this;
    }

    public static ShulkerPreview getInstance() {
        return INSTANCE;
    }
}

