package org.menaphos.model.skill.item.tool;

import org.menaphos.model.skill.item.SkillItemAbstractFactory;

public interface GatheringToolAbstractFactory extends SkillItemAbstractFactory {

    @Override
    GatheringTool getItem();
}
