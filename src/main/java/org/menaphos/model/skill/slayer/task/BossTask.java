package org.menaphos.model.skill.slayer.task;

import org.menaphos.model.math.Range;

public class BossTask extends SlayerTask {

    private final int combatLevel;

    public BossTask(int taskId, int combatLevel) {
        super(taskId, new Range(3,35), new Range(0,0), 4);
        this.combatLevel = combatLevel;
    }

    public int getCombatLevel() {
        return combatLevel;
    }
}
