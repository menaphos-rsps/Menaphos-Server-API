package org.menaphos.model.skill.nodes.context;

import org.menaphos.model.skill.nodes.context.impl.GatheringNodeContext;
import org.menaphos.model.skill.nodes.context.impl.RenewableGatheringNodeContext;
import org.menaphos.model.skill.nodes.context.impl.RenewableNodeContextAbstractFactory;

import java.util.HashMap;
import java.util.Map;

public final class NodeContextFactory {

    public static SkillNodeContext getContext(SkillNodeContextAbstractFactory factory) {
        return factory.getContext();
    }

    public static GatheringNodeContext getContext(GatheringNodeContextAbstractFactory factory) {
        return factory.getContext();
    }

    public static RenewableGatheringNodeContext getContext(RenewableNodeContextAbstractFactory factory) {
        return factory.getContext();
    }

}
