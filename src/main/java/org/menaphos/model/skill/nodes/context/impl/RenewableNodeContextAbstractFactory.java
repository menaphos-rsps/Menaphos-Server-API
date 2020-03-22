package org.menaphos.model.skill.nodes.context.impl;

import org.menaphos.model.skill.nodes.context.GatheringNodeContextAbstractFactory;

public interface RenewableNodeContextAbstractFactory extends GatheringNodeContextAbstractFactory {

    @Override
    RenewableGatheringNodeContext getContext();
}
