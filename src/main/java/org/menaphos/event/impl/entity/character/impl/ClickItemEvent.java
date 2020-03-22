package org.menaphos.event.impl.entity.character.impl;

import org.menaphos.event.impl.entity.character.CharacterEvent;
import org.menaphos.model.entity.impl.character.Character;

public final class ClickItemEvent extends CharacterEvent {

    private final int itemId;

    public ClickItemEvent(Character character,int itemId) {
        super(character);
        this.itemId = itemId;
    }

    public int getItemId() {
        return itemId;
    }


    @Override
    public boolean execute() {
        return false;
    }
}
