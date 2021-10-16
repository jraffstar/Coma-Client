package tech.jjjen.coma.client.modules.client;

import tech.jjjen.coma.client.modules.Module;
import tech.jjjen.coma.client.modules.ModuleManifest;

//fart


@ModuleManifest(label = "ChatNotify", category = Module.Category.CLIENT, persistent = true)
public class ChatNotifies extends Module {

    private static ChatNotifies INSTANCE;

    public ChatNotifies() {
        INSTANCE = this;
    }

    public static ChatNotifies getInstance() {
        return INSTANCE;
    }
}
