package org.menaphos.model.skill.nodes.context.impl.test;

import org.menaphos.model.skill.nodes.context.impl.RenewableGatheringNodeContext;

public class DummyOreContext extends RenewableGatheringNodeContext {

    public DummyOreContext(int objectId, int levelRequirement, int depletedId, int respawnTimer, int xp, int difficulty) {
        super(objectId, levelRequirement, depletedId, respawnTimer, xp, difficulty);
    }

}
