package org.menaphos.log.npc.metric;

import org.phantasye.AbstractJsonRepository;

public final class NpcMetricAverageRepository extends AbstractJsonRepository<NpcMetricAverage> {
    @Override
    public void create(NpcMetricAverage npcMetricAverage) {
        entries.put(String.valueOf(npcMetricAverage.getNpcId()), npcMetricAverage);
    }

    @Override
    public NpcMetricAverage read(NpcMetricAverage npcMetricAverage) {
        return entries.get(String.valueOf(npcMetricAverage.getNpcId()));
    }

    @Override
    public void delete(NpcMetricAverage npcMetricAverage) {
        entries.remove(String.valueOf(npcMetricAverage.getNpcId()));
    }
}
