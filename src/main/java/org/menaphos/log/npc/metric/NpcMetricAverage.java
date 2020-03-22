package org.menaphos.log.npc.metric;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public final class NpcMetricAverage {

    private final int npcId;
    private final Map<LocalDateTime,Double> averages;


    public NpcMetricAverage() {
        this.npcId = -1;
        this.averages = new HashMap<>();
    }

    public NpcMetricAverage(NpcMetric metric) {
        this.npcId = metric.getNpcId();
        this.averages = new HashMap<>();
    }

    public int getNpcId() {
        return npcId;
    }

    public Map<LocalDateTime, Double> getAverages() {
        return averages;
    }
}
