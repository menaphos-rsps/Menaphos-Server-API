package org.menaphos.model.skill.nodes.context.impl;

import org.menaphos.model.skill.io.NodeLoader;

public class RenewableNodeContextFactory implements RenewableNodeContextAbstractFactory {

    private final int id;

    public RenewableNodeContextFactory(int id) {
        this.id =id;
    }

    @Override
    public RenewableGatheringNodeContext getContext() {
        return NodeLoader.getRenewableNodeContext(id);
    }

    public int getId() {
        return id;
    }
}
