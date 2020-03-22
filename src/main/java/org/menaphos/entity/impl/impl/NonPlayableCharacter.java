package org.menaphos.entity.impl.impl;

import org.menaphos.entity.impl.CharacterEntity;

public interface NonPlayableCharacter extends CharacterEntity {

    void dropLootFor(PlayableCharacter player);
}
