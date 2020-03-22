package org.menaphos.model.skill.gathering;

import org.menaphos.action.impl.skill.SkillAction;
import org.menaphos.action.impl.skill.gathering.GatheringSkillAction;
import org.menaphos.entity.impl.impl.PlayableCharacter;
import org.menaphos.model.skill.Skill;
import org.menaphos.model.skill.item.SkillItem;
import org.menaphos.model.skill.item.tool.GatheringTool;

import java.util.ArrayList;
import java.util.List;

public abstract class GatheringSkill extends Skill {

    private final List<GatheringTool> toolList;

    protected GatheringSkill(PlayableCharacter player) {
        super(player);
        this.toolList = new ArrayList<>();
    }

    @Override
    public void perform(SkillAction action) {
        perform((GatheringSkillAction) action);
    }

    public abstract void perform(GatheringSkillAction action);

    protected boolean hasTool() {
        return getTool() > 0;
    }

    public int getTool() {
        return toolList.stream().filter(tool -> this.getPlayer().hasItem(tool.getItemId(), 1)).mapToInt(SkillItem::getItemId).findAny().orElse(0);
    }

    public List<GatheringTool> getToolList() {
        return toolList;
    }
}
