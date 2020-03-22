package org.menaphos.model.skill.item;

import org.menaphos.model.skill.item.tool.GatheringTool;
import org.menaphos.model.skill.item.tool.GatheringToolAbstractFactory;

public final class SkillItemFactory {

    public static SkillItem getItem(SkillItemAbstractFactory factory){
        return factory.getItem();
    }

    public static GatheringTool getItem(GatheringToolAbstractFactory factory) {
        return factory.getItem();
    }
}
