package org.menaphos.model.skill.io;

import org.menaphos.model.skill.nodes.context.impl.GatheringNodeContext;
import org.phantasye.AbstractJsonRepository;

public class GatheringNodeRepository extends AbstractJsonRepository<GatheringNodeContext> {
    @Override
    public void create(GatheringNodeContext context) {
        entries.put(String.valueOf(context.getObjectId()),context);
    }

    @Override
    public GatheringNodeContext read(GatheringNodeContext context) {
        return entries.get(String.valueOf(context.getObjectId()));
    }

    @Override
    public void delete(GatheringNodeContext context) {
        entries.remove(String.valueOf(context.getObjectId()));
    }
}
