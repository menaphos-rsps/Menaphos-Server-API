package org.menaphos.model.skill.nodes.context.impl;

import org.menaphos.model.skill.nodes.context.SkillNodeContext;

public class GatheringNodeContext extends SkillNodeContext {

    private final int difficulty;

    public GatheringNodeContext(int objectId, int levelRequirement, int difficulty, int xp) {
        super(objectId, levelRequirement,xp);
        this.difficulty = difficulty;
    }

    public void test() {

    }

    public int getDifficulty() {
        return difficulty;
    }
}
