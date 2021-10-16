package tech.jjjen.coma.client.modules.visual;

import tech.jjjen.coma.api.property.Setting;
import tech.jjjen.coma.client.modules.Module;
import tech.jjjen.coma.client.modules.ModuleManifest;

@ModuleManifest(label = "NoRender", listen = false, category = Module.Category.VISUAL, color = 0x006600)
public class NoRender extends Module {

    public final Setting<Boolean> noBossOverlay = register(new Setting<>("NoBoss", true));
    public final Setting<Boolean> boxedVines = register(new Setting<>("Vines", true));

    private static NoRender INSTANCE;

    public NoRender() {
        INSTANCE = this;
    }

    public static NoRender getInstance() {
        return INSTANCE;
    }

}