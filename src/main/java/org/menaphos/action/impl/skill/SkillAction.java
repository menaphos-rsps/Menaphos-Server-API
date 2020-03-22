package org.menaphos.action.impl.skill;

import org.menaphos.action.impl.AbstractAction;
import org.menaphos.entity.impl.CharacterEntity;
import org.menaphos.entity.impl.impl.PlayableCharacter;

public abstract class SkillAction extends AbstractAction {

    private final SkillActionContext actionContext;

    public SkillAction(SkillActionContext context) {
        super(context.getActor());
        this.actionContext = context;
    }

    public SkillActionContext getActionContext() {
        return actionContext;
    }
}
