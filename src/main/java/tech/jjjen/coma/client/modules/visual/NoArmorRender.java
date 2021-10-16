package tech.jjjen.coma.client.modules.visual;

import tech.jjjen.coma.api.property.Setting;
import tech.jjjen.coma.client.modules.Module;
import tech.jjjen.coma.client.modules.ModuleManifest;

@ModuleManifest(label = "NoArmorRender", listen = false, category = Module.Category.VISUAL, color = 0x009900)
public class NoArmorRender extends Module {

    public final Setting<Boolean> helmet = register(new Setting<>("Helmet", true));
    public final Setting<Boolean> chestplate = register(new Setting<>("Chestplate", true));
    public final Setting<Boolean> thighHighs = register(new Setting<>("Leggings", true));
    public final Setting<Boolean> boots = register(new Setting<>("Boots", true));

    public static NoArmorRender INSTANCE;

    public NoArmorRender() {
        INSTANCE = this;
    }


}
