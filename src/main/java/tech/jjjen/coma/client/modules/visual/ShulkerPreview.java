package tech.jjjen.coma.client.modules.visual;

import tech.jjjen.coma.client.modules.Module;
import tech.jjjen.coma.client.modules.ModuleManifest;

@ModuleManifest(label = "ShulkerPreview", listen = false, category = Module.Category.VISUAL, color = 0xcc9900)
public class ShulkerPreview extends Module {

    private static ShulkerPreview INSTANCE;

    public ShulkerPreview() {
        INSTANCE = this;
    }

    public static ShulkerPreview getInstance() {
        return INSTANCE;
    }

}
