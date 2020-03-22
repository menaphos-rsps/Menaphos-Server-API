package org.menaphos.event.listener;

import org.menaphos.event.MenaphosEvent;

public interface MenaphosEventListener<E extends MenaphosEvent> {

    default boolean handle(E event) {
        return event.execute();
    }
}
