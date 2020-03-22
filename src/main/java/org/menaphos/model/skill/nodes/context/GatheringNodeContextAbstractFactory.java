package org.menaphos.model.skill.nodes.context;

import org.menaphos.model.skill.nodes.context.impl.GatheringNodeContext;

public interface GatheringNodeContextAbstractFactory extends SkillNodeContextAbstractFactory {

    @Override
    GatheringNodeContext getContext();

}
