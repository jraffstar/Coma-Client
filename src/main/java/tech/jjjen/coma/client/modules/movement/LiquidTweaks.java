package tech.jjjen.coma.client.modules.movement;

import tech.jjjen.coma.api.property.Setting;
import tech.jjjen.coma.client.modules.Module;
import tech.jjjen.coma.client.modules.ModuleManifest;

@ModuleManifest(label = "LiquidTweaks", listen = false, category = Module.Category.MOVEMENT)
public class LiquidTweaks extends Module { //thank you proby for Isnaen idea

    private final Setting<Boolean> vertical = register(new Setting<>("Vertical", true));
    private final Setting<Boolean> horizontal = register(new Setting<>("Horizontal", true));

    @Override
    public void onUpdate() {
        if (mc.player.isInLava()) {
            if (vertical.getValue() && !mc.player.collidedVertically) {
                if (mc.gameSettings.keyBindSneak.isKeyDown())
                    mc.player.motionY -= 0.06553;
            }
            if ((!mc.player.collidedHorizontally && horizontal.getValue() && mc.gameSettings.keyBindForward.isKeyDown()) || mc.gameSettings.keyBindLeft.isKeyDown() || mc.gameSettings.keyBindRight.isKeyDown() || mc.gameSettings.keyBindBack.isKeyDown()) {
                mc.player.jumpMovementFactor = 0.068f;
            } else {
                mc.player.jumpMovementFactor = 0.0f;
            }
        }
    }

}
