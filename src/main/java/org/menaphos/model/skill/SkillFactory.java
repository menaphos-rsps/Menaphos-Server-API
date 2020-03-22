package org.menaphos.model.skill;

public final class SkillFactory {

    public static Skill getSkill(SkillAbstractFactory factory){
        return factory.createSkillInstance();
    }
}
