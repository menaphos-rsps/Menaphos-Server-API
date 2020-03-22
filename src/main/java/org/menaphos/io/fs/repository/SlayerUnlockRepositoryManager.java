package org.menaphos.io.fs.repository;

import org.menaphos.Menaphos;
import org.menaphos.model.skill.slayer.SlayerUnlock;
import org.phantasye.RepositoryManager;

public class SlayerUnlockRepositoryManager extends RepositoryManager<SlayerUnlock,SlayerUnlockRepository> {

    private static SlayerUnlockRepositoryManager instance = null;

    public static SlayerUnlockRepositoryManager getInstance() {
        if (instance == null)
            instance = new SlayerUnlockRepositoryManager();
        return instance;
    }

    private SlayerUnlockRepositoryManager() {
        super(Menaphos.getInstance().requestRepository(Menaphos.Repository.SLAYER_UNLOCK).getAbsolutePath(), SlayerUnlockRepository.class);
    }
}
