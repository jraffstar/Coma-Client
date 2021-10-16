package tech.jjjen.coma.client.modules.client;

import tech.jjjen.coma.client.modules.Module;
import tech.jjjen.coma.client.modules.ModuleManifest;
import tech.jjjen.coma.RPC;

@ModuleManifest(label = "DiscordRPC", category = Module.Category.CLIENT)
public class DiscordRpc extends Module {

    public void onEnable(){RPC.startRPC();}

    public void onDisable(){RPC.stopRPC();}
}
