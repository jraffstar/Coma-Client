package tech.jjjen.coma.client.modules.visual;

import tech.jjjen.coma.api.mixin.mixins.render.AccessorRenderManager;
import tech.jjjen.coma.client.modules.Module;
import tech.jjjen.coma.client.modules.ModuleManifest;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.culling.ICamera;

@ModuleManifest(label = "NoHurtCam", listen = false, category = Module.Category.VISUAL, color = 0x006600)
public class NoHurtCam extends Module {
    public static NoHurtCam INSTANCE;

    private final ICamera camera = new Frustum();
    private final AccessorRenderManager renderManager = (AccessorRenderManager) mc.getRenderManager();

    public NoHurtCam() {
        INSTANCE = this;
    }


}
