package tech.jjjen.coma.client.events;

import tech.jjjen.coma.api.property.Setting;
import tech.jjjen.coma.client.modules.Module;
import tcb.bces.event.Event;

public class ClientEvent extends Event {

    private Module module;
    private Setting setting;
    private int stage;

    public ClientEvent(Setting setting) {
        this.setting = setting;
    }

    public ClientEvent(int stage) {
        this.stage = stage;
    }

    public Module getModule() {
        return module;
    }

    public Setting getSetting() {
        return setting;
    }

    public int getStage() {
        return stage;
    }

}
