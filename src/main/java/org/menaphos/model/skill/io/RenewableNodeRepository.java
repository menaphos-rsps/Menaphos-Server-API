package org.menaphos.model.skill.io;

import org.menaphos.model.skill.nodes.context.impl.RenewableGatheringNodeContext;
import org.phantasye.AbstractJsonRepository;

public class RenewableNodeRepository extends AbstractJsonRepository<RenewableGatheringNodeContext> {
    @Override
    public void create(RenewableGatheringNodeContext context) {
        entries.put(String.valueOf(context.getObjectId()),context);
    }

    @Override
    public RenewableGatheringNodeContext read(RenewableGatheringNodeContext context) {
        return entries.get(String.valueOf(context.getObjectId()));
    }

    @Override
    public void delete(RenewableGatheringNodeContext context) {
        entries.remove(String.valueOf(context.getObjectId()));
    }
}
