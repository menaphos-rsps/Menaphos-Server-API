package org.menaphos.model.skill.nodes.context;

public class SkillNodeContext {

    private final int objectId;
    private final int levelRequirement;
    private final int xp;

    public SkillNodeContext(int objectId, int levelRequirement, int xp) {
        this.objectId = objectId;
        this.levelRequirement = levelRequirement;
        this.xp = xp;
    }

    public int getXp() {
        return xp;
    }

    public int getLevelRequirement() {
        return levelRequirement;
    }

    public int getObjectId() {
        return objectId;
    }
}
