package org.menaphos.io.fs.repository;

import org.menaphos.Menaphos;
import org.menaphos.model.skill.slayer.npc.SlayerMaster;
import org.phantasye.RepositoryManager;

public class SlayerMasterRepositoryManager extends RepositoryManager<SlayerMaster,SlayerMasterRepository> {

    private static SlayerMasterRepositoryManager instance = null;

    public static SlayerMasterRepositoryManager getInstance() {
        if (instance == null)
            instance = new SlayerMasterRepositoryManager();
        return instance;
    }

    private SlayerMasterRepositoryManager() {
        super(Menaphos.getInstance().requestRepository(Menaphos.Repository.SLAYER_MASTER).getAbsolutePath(), SlayerMasterRepository.class);
    }
}
