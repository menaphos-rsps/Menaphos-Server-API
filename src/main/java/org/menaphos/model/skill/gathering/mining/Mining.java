package org.menaphos.model.skill.gathering.mining;

import com.google.common.base.Preconditions;
import org.menaphos.action.impl.skill.SkillAction;
import org.menaphos.action.impl.skill.gathering.GatheringSkillAction;
import org.menaphos.entity.impl.impl.PlayableCharacter;
import org.menaphos.model.skill.SkillUtils;
import org.menaphos.model.skill.gathering.GatheringSkill;
import org.menaphos.model.skill.item.SkillItemFactory;
import org.menaphos.model.skill.item.tool.impl.GatheringToolFactory;

public class Mining extends GatheringSkill {

    public Mining(PlayableCharacter player) {
        super(player);
        this.getToolList().add(SkillItemFactory.getItem(new GatheringToolFactory(10)));
    }

    @Override
    public void perform(GatheringSkillAction action) {
        try {
            Preconditions.checkArgument(this.hasTool(),"You do not have a Pickaxe that you can use.");
            this.defaultLevelCheckPrecondition(MINING,action.getContext().getLevelRequirement());
            action.invoke();
        } catch (IllegalArgumentException e) {
            this.getPlayer().receiveMessage(e.getMessage());
            System.out.println(e.getMessage());
        }
    }
}
