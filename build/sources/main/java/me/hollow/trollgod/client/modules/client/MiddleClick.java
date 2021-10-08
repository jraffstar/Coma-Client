package tech.jensen.coma.client.modules.client;

import tech.jensen.coma.TrollGod;
import tech.jensen.coma.api.property.Setting;
import tech.jensen.coma.client.modules.Module;
import tech.jensen.coma.client.modules.ModuleManifest;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

@ModuleManifest(label="MiddleClick", listen=false, category=Module.Category.CLIENT)
public class MiddleClick
extends Module {
    private static MiddleClick INSTANCE;
    private final Setting<Boolean> friends = this.register( new Setting <> ( "Friends" , true ));

    public MiddleClick() {
        INSTANCE = this;
    }

    public static MiddleClick getInstance() {
        return INSTANCE;
    }

    public void run(int mouse) {
        if (mouse == 2 && this.friends.getValue ( ) && this.mc.objectMouseOver.entityHit != null) {
            Entity entity = this.mc.objectMouseOver.entityHit;
            if (!(entity instanceof EntityPlayer)) {
                return;
            }
            if (TrollGod.INSTANCE.getFriendManager().isFriend(entity.getName())) {
                TrollGod.INSTANCE.getFriendManager().removeFriend(entity.getName());
            } else {
                TrollGod.INSTANCE.getFriendManager().addFriend(entity.getName());
            }
        }
    }
}

