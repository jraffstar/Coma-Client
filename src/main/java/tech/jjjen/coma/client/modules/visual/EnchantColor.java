package tech.jjjen.coma.client.modules.visual;

import tech.jjjen.coma.api.property.Setting;
import tech.jjjen.coma.client.modules.Module;
import tech.jjjen.coma.client.modules.ModuleManifest;

import java.awt.*;

@ModuleManifest(label = "EnchantColor", listen = false, category = Module.Category.VISUAL, color = 0xff9933)
public class EnchantColor extends Module {

    private final Setting<Integer> red = register(new Setting<>("Red", 255, 0, 255));
    private final Setting<Integer> green = register(new Setting<>("Green", 255, 0, 255));
    private final Setting<Integer> blue = register(new Setting<>("Blue", 255, 0, 255));

    public static EnchantColor INSTANCE;

    public EnchantColor() {
        INSTANCE = this;
    }

    public int getColor() {
        return new Color(red.getValue(), green.getValue(), blue.getValue()).getRGB();
    }

}
