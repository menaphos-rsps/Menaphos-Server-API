package org.menaphos.model.skill.gathering;

import org.menaphos.model.skill.SkillAbstractFactory;

public interface GatheringSkillAbstractFactory extends SkillAbstractFactory {

    @Override
    GatheringSkill createSkillInstance();

}
