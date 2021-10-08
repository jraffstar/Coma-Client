package tech.jensen.coma.client.modules.visual;

import tech.jensen.coma.api.property.Setting;
import tech.jensen.coma.client.modules.Module;
import tech.jensen.coma.client.modules.ModuleManifest;

@ModuleManifest(label="NoRender", listen=false, category=Module.Category.VISUAL, color=26112)
public class NoRender
extends Module {
    public final Setting<Boolean> noBossOverlay = this.register( new Setting <> ( "NoBoss" , true ));
    public static NoRender INSTANCE;

    public NoRender() {
        INSTANCE = this;
    }
}

