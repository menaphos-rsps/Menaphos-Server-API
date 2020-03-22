package org.menaphos.log.npc.metric;

public final class NpcMetricContext {

    private final int averageIntervals;
    private final int npcId;

    public NpcMetricContext(final int npcId,final int averageIntervals) {
        this.averageIntervals = averageIntervals;
        this.npcId = npcId;
    }

    public int getNpcId() {
        return npcId;
    }

    public int getAverageIntervals() {
        return averageIntervals;
    }
}
