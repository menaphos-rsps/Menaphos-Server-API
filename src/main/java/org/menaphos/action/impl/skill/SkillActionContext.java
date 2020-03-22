package org.menaphos.action.impl.skill;

import org.menaphos.action.ActionContext;
import org.menaphos.entity.impl.impl.PlayableCharacter;

public class SkillActionContext extends ActionContext {

    public SkillActionContext(PlayableCharacter entity) {
        super(entity);
    }

    @Override
    public PlayableCharacter getActor() {
        return (PlayableCharacter) super.getActor();
    }
}
