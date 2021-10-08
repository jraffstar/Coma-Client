package tech.jensen.coma.client.modules.client;

import tech.jensen.coma.api.property.Setting;
import tech.jensen.coma.client.modules.Module;
import tech.jensen.coma.client.modules.ModuleManifest;

@ModuleManifest(label="PopCounter", category=Module.Category.CLIENT, listen=false)
public class PopCounter
extends Module {
    public static Setting<Boolean> notify = new Setting <> ( "Notify" , true );
    private static PopCounter INSTANCE;

    public PopCounter() {
        INSTANCE = this;
        this.addSetting(notify);
    }

    public static PopCounter getInstance() {
        return INSTANCE;
    }
}

