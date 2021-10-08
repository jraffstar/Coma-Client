package tech.jensen.coma.api.mixin.mixins.client;

import tech.jensen.coma.TrollGod;
import tech.jensen.coma.api.mixin.accessors.IMinecraft;
import tech.jensen.coma.client.events.KeyEvent;
import tech.jensen.coma.client.modules.Module;
import tech.jensen.coma.client.modules.client.Manage;
import tech.jensen.coma.client.modules.client.MiddleClick;
import tech.jensen.coma.client.modules.misc.MultiTask;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={Minecraft.class}, priority=1001)
public abstract class MixinMinecraft
implements IMinecraft {
    @Override
    @Accessor
    public abstract void setRightClickDelayTimer(int var1);

    @Inject(method={"runTickKeyboard"}, at={@At(value="INVOKE", target="Lorg/lwjgl/input/Keyboard;getEventKey()I", ordinal=0, shift=At.Shift.BEFORE)})
    private void onKeyboard(CallbackInfo callbackInfo) {
        if (Keyboard.getEventKeyState()) {
            for (int i = 0; i < TrollGod.INSTANCE.getModuleManager().getSize(); ++i) {
                Module m = TrollGod.INSTANCE.getModuleManager().getModules().get(i);
                if (m.getKey() != Keyboard.getEventKey()) continue;
                m.toggle();
            }
            TrollGod.INSTANCE.getBus().post(new KeyEvent(Keyboard.getEventKey()));
        }
    }

    @Inject(method={"runTickMouse"}, at={@At(value="INVOKE", target="Lorg/lwjgl/input/Mouse;getEventButton()I", ordinal=0, shift=At.Shift.BEFORE)})
    private void mouseClick(CallbackInfo ci) {
        if (Mouse.getEventButtonState()) {
            MiddleClick.getInstance().run(Mouse.getEventButton());
            MultiTask.getInstance().onMouse(Mouse.getEventButton());
        }
    }

    @Inject(method={"getLimitFramerate"}, at={@At(value="HEAD")}, cancellable=true)
    public void limitFps(CallbackInfoReturnable<Integer> cir) {
        if ( Manage.INSTANCE.unfocusedLimit.getValue ( ) && !Display.isActive()) {
            cir.setReturnValue(Manage.INSTANCE.unfocusedFPS.getValue());
        }
    }

    @Inject(method={"init"}, at={@At(value="RETURN")})
    public void init(CallbackInfo ci) {
        TrollGod.INSTANCE.init();
    }
}

