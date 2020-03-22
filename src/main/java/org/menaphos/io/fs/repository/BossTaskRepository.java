package org.menaphos.io.fs.repository;

import org.menaphos.model.skill.slayer.task.BossTask;
import org.phantasye.AbstractJsonRepository;

public class BossTaskRepository extends AbstractJsonRepository<BossTask> {
    @Override
    public void create(BossTask slayerTask) {
        entries.put(String.valueOf(slayerTask.getTaskId()),slayerTask);
    }

    @Override
    public BossTask read(BossTask slayerTask) {
        return entries.get(String.valueOf(slayerTask.getTaskId()));
    }

    @Override
    public void delete(BossTask slayerTask) {
        entries.remove(String.valueOf(slayerTask.getTaskId()));
    }

}
