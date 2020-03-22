package org.menaphos.model.skill.item;

public class SkillItem {

    private final int skillId;
    private final int itemId;
    private final int levelRequirement;

    public SkillItem(int skillId, int itemId, int levelRequirement) {
        this.skillId = skillId;
        this.itemId = itemId;
        this.levelRequirement = levelRequirement;
    }

    public int getLevelRequirement() {
        return levelRequirement;
    }

    public int getItemId() {
        return itemId;
    }

    public int getSkillId() {
        return skillId;
    }
}
