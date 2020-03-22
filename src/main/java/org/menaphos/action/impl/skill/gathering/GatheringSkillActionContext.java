package org.menaphos.action.impl.skill.gathering;

import org.menaphos.action.impl.skill.SkillActionContext;
import org.menaphos.entity.impl.impl.PlayableCharacter;
import org.menaphos.model.skill.item.tool.GatheringTool;
import org.menaphos.model.world.location.Location;

public class GatheringSkillActionContext extends SkillActionContext {

    private final Location nodeLocation;
    private final GatheringTool gatheringTool;

    public GatheringSkillActionContext(PlayableCharacter entity, Location nodeLocation, GatheringTool gatheringTool) {
        super(entity);
        this.nodeLocation = nodeLocation;
        this.gatheringTool =gatheringTool;
    }

    public GatheringTool getGatheringTool() {
        return gatheringTool;
    }

    public Location getNodeLocation() {
        return nodeLocation;
    }
}
