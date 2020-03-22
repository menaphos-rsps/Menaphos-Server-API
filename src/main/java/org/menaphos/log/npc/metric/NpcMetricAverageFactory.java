package org.menaphos.log.npc.metric;

import org.menaphos.Menaphos;

import java.time.LocalDateTime;
import java.util.HashMap;

public final class NpcMetricAverageFactory {

    private static final HashMap<Integer, NpcMetricAverage> DATA_MAP = new HashMap<>();

    public static NpcMetricAverage getMetric(int npcId) {
        NpcMetricAverage metric = DATA_MAP.get(npcId);

        if (metric == null) {
            metric = Menaphos.getMetricAverageRepositoryManager().getRepository().readByKey(String.valueOf(npcId));
            if (metric == null) {
                if (NpcMetricFactory.getMetricForNpc(npcId) != null)
                    metric = new NpcMetricAverage(NpcMetricFactory.getMetricForNpc(npcId));
                if (metric == null)
                    throw new NullPointerException("Missing Metric Average for: " + npcId);
            }
            DATA_MAP.put(npcId, metric);
        }
        return metric;
    }

    public static void updateMetricAverage(NpcMetric metric) {
        try {
            final int id = metric.getNpcId();
            final NpcMetricAverage average = getMetric(id);
            average.getAverages().put(LocalDateTime.now(),metric.getAverage());
            Menaphos.getMetricAverageRepositoryManager().getRepository().create(average);
            Menaphos.getMetricAverageRepositoryManager().updateRepository();
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
        }
    }
}
