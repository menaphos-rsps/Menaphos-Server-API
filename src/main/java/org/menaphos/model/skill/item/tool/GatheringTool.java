package org.menaphos.model.skill.item.tool;

import org.menaphos.model.skill.item.SkillItem;

public class GatheringTool extends SkillItem {

    private final int efficiency;
    private final int animation;

    public GatheringTool(int skillId, int itemId, int levelRequirement, int efficiency, int animation) {
        super(skillId, itemId, levelRequirement);
        this.efficiency = efficiency;
        this.animation = animation;
    }

    public int getAnimation() {
        return animation;
    }

    public int getEfficiency() {
        return efficiency;
    }
}
