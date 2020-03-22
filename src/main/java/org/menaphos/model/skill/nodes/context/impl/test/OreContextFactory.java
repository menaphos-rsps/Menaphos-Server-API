package org.menaphos.model.skill.nodes.context.impl.test;

import org.menaphos.model.skill.io.NodeLoader;

public class OreContextFactory implements OreNodeContextAbstractFactory {

    private final int id;

    public OreContextFactory(int id) {
        this.id = id;
    }

    @Override
    public DummyOreContext getContext() {
        return new DummyOreContext(
                NodeLoader.getRenewableNodeContext(id).getObjectId(),
                NodeLoader.getRenewableNodeContext(id).getLevelRequirement(),
                NodeLoader.getRenewableNodeContext(id).getDepletedId(),
                NodeLoader.getRenewableNodeContext(id).getRespawnTimer(),
                NodeLoader.getRenewableNodeContext(id).getXp(),
                NodeLoader.getRenewableNodeContext(id).getDifficulty()
        );
    }
}
