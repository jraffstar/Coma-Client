package tech.jjjen.coma.client.managers;

import tech.jjjen.coma.api.interfaces.*;
import tech.jjjen.coma.api.util.font.CFontRenderer;
import tech.jjjen.coma.client.modules.client.FontModule;

import java.awt.*;

public class FontManager implements Minecraftable {

    public CFontRenderer fontRenderer = new CFontRenderer(new Font("Verdana", 0, 18), true, true);

    public boolean customFont;

    public void drawString(String text, float x, float y, int color) {
        if (customFont) {
            fontRenderer.drawStringWithShadow(text, x, y, color);
        } else {
            mc.fontRenderer.drawStringWithShadow(text, x, y, color);
        }
    }

    public int getStringHeight() {
        if (customFont) {
            return mc.fontRenderer.FONT_HEIGHT;
        }

        return fontRenderer.getStringHeight("A");
    }

    public void updateFont() {
        fontRenderer = new CFontRenderer(new Font(FontModule.INSTANCE.font.getValue(), 0, FontModule.INSTANCE.size.getValue()), FontModule.INSTANCE.antiAlias.getValue(), true);
    }

    public int getStringWidth(String text) {
        if (customFont) {
            return (int) fontRenderer.getStringWidth(text);
        }
        return mc.fontRenderer.getStringWidth(text);
    }
}