package tech.jjjen.coma.client.modules.movement;

import com.mojang.realmsclient.gui.ChatFormatting;
import tech.jjjen.coma.api.util.MessageUtil;
import tech.jjjen.coma.client.modules.Module;
import tech.jjjen.coma.client.modules.ModuleManifest;

@ModuleManifest(label = "ElytraFlight", listen = false, category = Module.Category.MOVEMENT)
public class ElytraFlight extends Module {
    @Override
    public void onEnable() {
        MessageUtil.sendClientMessage(ChatFormatting.RED + "Not done yet", -551);
    }
}
