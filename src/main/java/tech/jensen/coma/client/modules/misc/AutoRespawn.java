package tech.jensen.coma.client.modules.misc;

import tech.jensen.coma.api.property.Setting;
import tech.jensen.coma.api.util.MessageUtil;
import tech.jensen.coma.client.modules.Module;
import tech.jensen.coma.client.modules.ModuleManifest;
import net.minecraft.client.gui.GuiGameOver;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

@ModuleManifest(label="AutoRespawn", listen=false, category=Module.Category.MISC, color=-835840)
public class AutoRespawn
extends Module {
    private final Setting<Boolean> copyToClipboard = this.register( new Setting <> ( "Clipboard" , true ));

    @SubscribeEvent
    public void onGui(GuiOpenEvent event) {
        if (event.getGui() instanceof GuiGameOver) {
            this.mc.player.respawnPlayer();
            String deathCoords = "XYZ : " + (int)this.mc.player.posX + " " + (int)this.mc.player.posY + " " + (int)this.mc.player.posZ;
            MessageUtil.sendClientMessage(deathCoords, 0);
            if ( this.copyToClipboard.getValue ( ) ) {
                try {
                    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                    clipboard.setContents(new StringSelection(deathCoords), null);
                }
                catch (Exception e) {
                    MessageUtil.sendClientMessage(e.getMessage(), 0);
                }
            }
        }
    }

    @Override
    public void onEnable() {
        MinecraftForge.EVENT_BUS.register( this );
    }

    @Override
    public void onDisable() {
        MinecraftForge.EVENT_BUS.unregister( this );
    }
}

