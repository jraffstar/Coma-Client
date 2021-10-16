package tech.jjjen.coma.client.modules.visual;

import tech.jjjen.coma.api.property.Setting;
import tech.jjjen.coma.client.modules.Module;
import tech.jjjen.coma.client.modules.ModuleManifest;

@ModuleManifest(label = "ModelChanger", listen = false, category = Module.Category.VISUAL, color = 0xff0355ff)
public class ViewmodelChanger extends Module {

    public final Setting<Boolean> pauseOnEat = register(new Setting<>("Pause", true));

    public final Setting<Float> translateX = register(new Setting<>("X", 0F, -5F, 5F));
    public final Setting<Float> translateY = register(new Setting<>("Y", 0F, -5F, 5F));
    public final Setting<Float> translateZ = register(new Setting<>("Z", 0F, -5F, 5F));

    public final Setting<Float> scale = register(new Setting<>("Scale", 10f, 9f, 10f));

    public static ViewmodelChanger INSTANCE;

    public ViewmodelChanger() {
        INSTANCE = this;
    }


}
