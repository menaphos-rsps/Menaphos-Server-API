package org.menaphos.event;

public abstract class MenaphosEvent {

    public static enum EventType {
        CLICK_ITEM
    }

    public abstract boolean execute();
}
