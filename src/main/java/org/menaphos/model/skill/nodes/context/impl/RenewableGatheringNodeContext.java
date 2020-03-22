package org.menaphos.model.skill.nodes.context.impl;


public class RenewableGatheringNodeContext extends GatheringNodeContext  {

    private final int depletedId;
    private final int respawnTimer;

    public RenewableGatheringNodeContext(int objectId, int levelRequirement, int depletedId, int respawnTimer, int xp, int difficulty) {
        super(objectId, levelRequirement,difficulty, xp);
        this.depletedId = depletedId;
        this.respawnTimer = respawnTimer;
    }

    public int getRespawnTimer() {
        return respawnTimer;
    }

    public int getDepletedId() {
        return depletedId;
    }
}
