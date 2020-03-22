package org.menaphos.action;

import org.menaphos.entity.impl.CharacterEntity;

public class ActionContext {

    private final CharacterEntity entity;

    public ActionContext(CharacterEntity entity) {
        this.entity = entity;
    }

    public CharacterEntity getActor() {
        return entity;
    }
}
