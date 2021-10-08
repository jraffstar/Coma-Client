package tech.jensen.coma.client.notification;

import tech.jensen.coma.TrollGod;
import tech.jensen.coma.api.util.Timer;
import tech.jensen.coma.api.util.render.RenderUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;

public class Notification {
    private final String message;
    private final Timer timer = new Timer();
    Minecraft mc = Minecraft.getMinecraft();
    ScaledResolution scaledRes = new ScaledResolution(this.mc);

    public Notification(String message) {
        this.message = message;
        this.timer.reset();
    }

    public void drawNotification(int y) {
        if (this.timer.hasReached(2000L)) {
            TrollGod.INSTANCE.getNotificationManager().getNotifications().remove(this);
        }
        RenderUtil.drawBorderedRect(this.scaledRes.getScaledWidth() - 10 - TrollGod.fontManager.getStringWidth(this.message), y, this.scaledRes.getScaledWidth() - 4, y + 14, 0x75222222, -15658735);
        TrollGod.fontManager.drawString(this.message, this.scaledRes.getScaledWidth() - TrollGod.fontManager.getStringWidth(this.message) - 6, y + 2, 0xFFFFFF);
    }
}

