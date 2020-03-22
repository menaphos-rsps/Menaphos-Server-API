package org.menaphos.log.npc.metric;

import org.menaphos.Menaphos;
import org.phantasye.RepositoryManager;

public final class NpcMetricAverageRepositoryManager extends RepositoryManager<NpcMetricAverage,NpcMetricAverageRepository> {

    public NpcMetricAverageRepositoryManager() {
        super(Menaphos.getInstance().requestRepository(Menaphos.Repository.NPC_METRIC_AVERAGES).getAbsolutePath(), NpcMetricAverageRepository.class);
    }
}
