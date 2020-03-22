package org.menaphos.model.skill.io;

import org.menaphos.model.skill.nodes.context.SkillNodeContext;
import org.menaphos.model.skill.nodes.context.impl.GatheringNodeContext;
import org.menaphos.model.skill.nodes.context.impl.RenewableGatheringNodeContext;

import java.util.HashMap;
import java.util.Map;

public final class NodeLoader {

    private final static Map<Integer, SkillNodeContext> SKILL_NODE_CONTEXT_MAP = new HashMap<>();
    private final static Map<Integer, GatheringNodeContext> GATHERING_NODE_CONTEXT_MAP = new HashMap<>();
    private final static Map<Integer, RenewableGatheringNodeContext> RENEWABLE_NODE_CONTEXT_MAP = new HashMap<>();

    public static SkillNodeContext getSkillNodeContext(int id) {
        SkillNodeContext context = SKILL_NODE_CONTEXT_MAP.get(id);

        if (context == null) {
            context = SkillNodeRepositoryManager.getInstance().getRepository().readByKey(String.valueOf(id));
            SKILL_NODE_CONTEXT_MAP.put(id,context);
            if (context == null)
                throw new NullPointerException("No Context Found");
        }
        return context;
    }

    public static GatheringNodeContext getGatheringNodeContext(int id) {
        GatheringNodeContext context = GATHERING_NODE_CONTEXT_MAP.get(id);

        if (context == null) {
            context = GatheringNodeRepositoryManager.getInstance().getRepository().readByKey(String.valueOf(id));
            GATHERING_NODE_CONTEXT_MAP.put(id,context);
            if (context == null)
                throw new NullPointerException("No Context Found");
        }
        return context;
    }

    public static RenewableGatheringNodeContext getRenewableNodeContext(int id) {
        RenewableGatheringNodeContext context = RENEWABLE_NODE_CONTEXT_MAP.get(id);

        if (context == null) {
            context = RenewableNodeRepositoryManager.getInstance().getRepository().readByKey(String.valueOf(id));
            RENEWABLE_NODE_CONTEXT_MAP.put(id,context);
            if (context == null)
                throw new NullPointerException("No Context Found");
        }
        return context;
    }
}
