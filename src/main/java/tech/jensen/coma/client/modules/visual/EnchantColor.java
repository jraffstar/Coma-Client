package tech.jensen.coma.client.modules.visual;

import tech.jensen.coma.api.property.Setting;
import tech.jensen.coma.client.modules.Module;
import tech.jensen.coma.client.modules.ModuleManifest;

import java.awt.*;

@ModuleManifest(label="EnchantColor", listen=false, category=Module.Category.VISUAL, color=0xFF9933)
public class EnchantColor
extends Module {
    private final Setting<Integer> red = this.register( new Setting <> ( "Red" , 255 , 0 , 255 ));
    private final Setting<Integer> green = this.register( new Setting <> ( "Green" , 255 , 0 , 255 ));
    private final Setting<Integer> blue = this.register( new Setting <> ( "Blue" , 255 , 0 , 255 ));
    public static EnchantColor INSTANCE;

    public EnchantColor() {
        INSTANCE = this;
    }

    @Override
    public int getColor() {
        return new Color(this.red.getValue(), this.green.getValue(), this.blue.getValue()).getRGB();
    }
}

