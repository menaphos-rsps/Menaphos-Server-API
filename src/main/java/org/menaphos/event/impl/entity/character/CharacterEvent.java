package org.menaphos.event.impl.entity.character;

import org.menaphos.event.impl.entity.EntityEvent;
import org.menaphos.model.entity.impl.character.Character;

public abstract class CharacterEvent extends EntityEvent<Character> {

    protected CharacterEvent(Character entity) {
        super(entity);
    }
}
