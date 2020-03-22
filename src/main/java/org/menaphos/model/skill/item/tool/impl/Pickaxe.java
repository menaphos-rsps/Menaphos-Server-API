package org.menaphos.model.skill.item.tool.impl;

import org.menaphos.model.skill.Skill;
import org.menaphos.model.skill.item.tool.GatheringTool;

public class Pickaxe extends GatheringTool {

    public Pickaxe(int itemId, int levelRequirement, int efficiency, int animation) {
        super(Skill.MINING, itemId, levelRequirement, efficiency, animation);
    }
}
