package tech.jensen.coma.client.events;

import tech.jensen.coma.api.property.Setting;
import tech.jensen.coma.client.modules.Module;
import tcb.bces.event.Event;

public class ClientEvent
extends Event {
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
        return this.module;
    }

    public Setting getSetting() {
        return this.setting;
    }

    public int getStage() {
        return this.stage;
    }
}

