package org.menaphos.model.skill.gathering;

public class GatheringSkillFactory {

    public static GatheringSkill getSkill(GatheringSkillAbstractFactory factory) {
        return factory.createSkillInstance();
    }
}
