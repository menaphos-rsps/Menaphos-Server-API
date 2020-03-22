package org.menaphos.io.fs.repository;

import org.menaphos.Menaphos;
import org.menaphos.model.skill.slayer.task.SlayerMonster;
import org.phantasye.RepositoryManager;

public class SlayerMonsterRepositoryManager extends RepositoryManager<SlayerMonster,SlayerMonsterRepository> {

    private static SlayerMonsterRepositoryManager instance = null;

    public static SlayerMonsterRepositoryManager getInstance() {
        if (instance == null)
            instance = new SlayerMonsterRepositoryManager();
        return instance;
    }

    private SlayerMonsterRepositoryManager() {
        super(Menaphos.getInstance().requestRepository(Menaphos.Repository.SLAYER_MONSTER).getAbsolutePath(), SlayerMonsterRepository.class);
    }
}
