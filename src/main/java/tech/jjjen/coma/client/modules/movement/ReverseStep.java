package tech.jjjen.coma.client.modules.movement;

import tech.jjjen.coma.api.property.Setting;
import tech.jjjen.coma.client.modules.Module;
import tech.jjjen.coma.client.modules.ModuleManifest;

@ModuleManifest(label = "ReverseStep", category = Module.Category.MOVEMENT, color = 0xAE85DE)
public class ReverseStep extends Module {

    private final Setting<Integer> speed = register(new Setting<>("Speed", 10, 1, 20));

    @Override
    public void onUpdate() {
        if (mc.player.isInWater() || mc.player.isInLava() || mc.player.isOnLadder()) {
            return;
        }
        if (mc.player.onGround) {
            mc.player.motionY -= (float)speed.getValue() / 10;
        }
    }

}
