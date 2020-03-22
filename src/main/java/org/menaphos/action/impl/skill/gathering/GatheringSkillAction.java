package org.menaphos.action.impl.skill.gathering;

import org.menaphos.action.impl.skill.SkillAction;
import org.menaphos.entity.impl.impl.PlayableCharacter;
import org.menaphos.model.skill.nodes.context.impl.GatheringNodeContext;

public abstract class GatheringSkillAction extends SkillAction {

    private final GatheringNodeContext context;

    public GatheringSkillAction(GatheringSkillActionContext actionContext, GatheringNodeContext context) {
        super(actionContext);
        this.context = context;
    }

    @Override
    public GatheringSkillActionContext getActionContext() {
        return (GatheringSkillActionContext) super.getActionContext();
    }

    public GatheringNodeContext getContext() {
        return context;
    }
}
