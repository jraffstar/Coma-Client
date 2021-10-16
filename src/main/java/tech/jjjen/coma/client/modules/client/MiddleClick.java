package tech.jjjen.coma.client.modules.client;

import tech.jjjen.coma.Main;
import tech.jjjen.coma.api.property.Setting;
import tech.jjjen.coma.client.modules.Module;
import tech.jjjen.coma.client.modules.ModuleManifest;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

@ModuleManifest(label = "MiddleClick", listen = false, category = Module.Category.CLIENT)
public class MiddleClick extends Module {

    private static MiddleClick INSTANCE;

    private final Setting<Boolean> friends = register(new Setting<>("Friends", true));

    public MiddleClick() {
        INSTANCE = this;
    }

    public static MiddleClick getInstance() {
        return INSTANCE;
    }

    public void run(int mouse) {
        if (mouse == 2 && friends.getValue()) {
            if (mc.objectMouseOver.entityHit != null) {
                final Entity entity = mc.objectMouseOver.entityHit;

                if (!(entity instanceof EntityPlayer)) {
                    return;
                }

                if (Main.INSTANCE.getFriendManager().isFriend(entity.getName())) {
                    Main.INSTANCE.getFriendManager().removeFriend(entity.getName());
                } else {
                    Main.INSTANCE.getFriendManager().addFriend(entity.getName());
                }
            }
        }
    }

}
