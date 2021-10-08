package tech.jensen.coma.api.mixin.mixins.client;

import tech.jensen.coma.client.modules.visual.TimeChanger;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={World.class})
public class MixinWorld {
    @Inject(method={"getWorldTime"}, at={@At(value="HEAD")}, cancellable=true)
    public void getWorldTime(CallbackInfoReturnable<Long> cir) {
        if (TimeChanger.INSTANCE.isEnabled()) {
            cir.cancel();
            cir.setReturnValue((long)TimeChanger.INSTANCE.timeSetting.getValue());
        }
    }
}

