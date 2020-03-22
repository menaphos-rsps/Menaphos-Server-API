package org.menaphos.io.fs.repository;

import org.menaphos.Menaphos;
import org.menaphos.model.skill.slayer.task.BossTask;
import org.phantasye.RepositoryManager;

public class BossTaskRepositoryManager extends RepositoryManager<BossTask, BossTaskRepository> {

    private static BossTaskRepositoryManager instance = null;

    public static BossTaskRepositoryManager getInstance() {
        if (instance == null)
            instance = new BossTaskRepositoryManager();
        return instance;
    }

    private BossTaskRepositoryManager() {
        super(Menaphos.getInstance().requestRepository(Menaphos.Repository.BOSS_TASK).getAbsolutePath(), BossTaskRepository.class);
    }
}
