package org.menaphos.model.skill.io;

import org.menaphos.model.skill.nodes.context.SkillNodeContext;
import org.phantasye.AbstractJsonRepository;

public class SkillNodeContextRepository extends AbstractJsonRepository<SkillNodeContext> {
    @Override
    public void create(SkillNodeContext skillNodeContext) {
        entries.put(String.valueOf(skillNodeContext.getObjectId()),skillNodeContext);
    }

    @Override
    public SkillNodeContext read(SkillNodeContext skillNodeContext) {
        return entries.get(String.valueOf(skillNodeContext.getObjectId()));
    }

    @Override
    public void delete(SkillNodeContext skillNodeContext) {
        entries.remove(String.valueOf(skillNodeContext.getObjectId()));
    }
}
