package tech.jensen.coma.client.modules.client;

import tech.jensen.coma.TrollGod;
import tech.jensen.coma.api.property.Setting;
import tech.jensen.coma.client.events.ClientEvent;
import tech.jensen.coma.client.modules.Module;
import tech.jensen.coma.client.modules.ModuleManifest;
import tcb.bces.listener.Subscribe;

@ModuleManifest(label="Font", category=Module.Category.CLIENT)
public class FontModule
extends Module {
    public final Setting<String> font = this.register( new Setting <> ( "Font" , "Verdana" ));
    public final Setting<Integer> size = this.register( new Setting <> ( "Size" , 18 , 12 , 24 ));
    public final Setting<Boolean> antiAlias = this.register( new Setting <> ( "Anti Alias" , true ));
    public static FontModule INSTANCE = new FontModule();

    public FontModule() {
        INSTANCE = this;
    }

    @Override
    public void onLoad() {
        TrollGod.fontManager.updateFont();
    }

    @Subscribe
    public void onSetting(ClientEvent event) {
        if (this.mc.player == null || this.mc.world == null) {
            return;
        }
        if (event.getSetting() == this.size || event.getSetting() == this.font || event.getSetting() == null || event.getSetting() == this.antiAlias) {
            TrollGod.fontManager.updateFont();
        }
    }

    @Override
    public void onEnable() {
        TrollGod.fontManager.customFont = true;
    }

    @Override
    public void onDisable() {
        TrollGod.fontManager.customFont = false;
    }
}

