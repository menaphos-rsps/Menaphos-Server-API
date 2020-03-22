package org.menaphos.event.impl.entity;

import org.menaphos.event.MenaphosEvent;
import org.menaphos.model.entity.Entity;

public abstract class EntityEvent<E extends Entity> extends MenaphosEvent {

    private final E entity;

    protected EntityEvent(E entity) {
        this.entity = entity;
    }

    public E getEntity() {
        return entity;
    }
}
