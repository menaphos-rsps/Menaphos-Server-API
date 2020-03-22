package org.menaphos.model.skill.gathering.mining;

import org.menaphos.entity.impl.impl.PlayableCharacter;
import org.menaphos.model.skill.gathering.GatheringSkill;
import org.menaphos.model.skill.gathering.GatheringSkillAbstractFactory;

public class MiningSkillFactory implements GatheringSkillAbstractFactory {

    private final PlayableCharacter player;

    public MiningSkillFactory(PlayableCharacter player) {
        this.player = player;
    }

    @Override
    public GatheringSkill createSkillInstance() {
        return new Mining(player);
    }
}
