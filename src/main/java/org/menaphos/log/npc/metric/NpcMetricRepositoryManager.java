package org.menaphos.log.npc.metric;

import org.menaphos.Menaphos;
import org.phantasye.RepositoryManager;

public class NpcMetricRepositoryManager extends RepositoryManager<NpcMetric, NpcMetricRepository> {

    private static NpcMetricRepositoryManager instance = null;

    public static NpcMetricRepositoryManager getInstance() {
        if (instance == null) {
            instance = new NpcMetricRepositoryManager();
        }
        return instance;
    }

    private NpcMetricRepositoryManager() {
        super(Menaphos.getInstance().requestRepository(Menaphos.Repository.NPC_METRICS).getAbsolutePath(), NpcMetricRepository.class);
    }
}
