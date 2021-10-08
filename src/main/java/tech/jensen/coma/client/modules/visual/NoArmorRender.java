package tech.jensen.coma.client.modules.visual;

import tech.jensen.coma.api.property.Setting;
import tech.jensen.coma.client.modules.Module;
import tech.jensen.coma.client.modules.ModuleManifest;

@ModuleManifest(label="NoArmorRender", listen=false, category=Module.Category.VISUAL, color=39168)
public class NoArmorRender
extends Module {
    public final Setting<Boolean> helmet = this.register( new Setting <> ( "Helmet" , true ));
    public final Setting<Boolean> chestplate = this.register( new Setting <> ( "Chestplate" , true ));
    public final Setting<Boolean> thighHighs = this.register( new Setting <> ( "Leggings" , true ));
    public final Setting<Boolean> boots = this.register( new Setting <> ( "Boots" , true ));
    public static NoArmorRender INSTANCE;

    public NoArmorRender() {
        INSTANCE = this;
    }
}

