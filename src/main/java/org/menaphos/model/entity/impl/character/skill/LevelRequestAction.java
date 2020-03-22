package org.menaphos.model.entity.impl.character.skill;

import org.menaphos.model.Observable;

public interface LevelRequestAction extends Observable {

    int query(int skillId);
}
