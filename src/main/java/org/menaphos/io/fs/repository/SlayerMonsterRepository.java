package org.menaphos.io.fs.repository;

import org.menaphos.model.skill.slayer.task.SlayerMonster;
import org.phantasye.AbstractJsonRepository;

public class SlayerMonsterRepository extends AbstractJsonRepository<SlayerMonster> {
    @Override
    public void create(SlayerMonster monster) {
        entries.put(String.valueOf(monster.getTaskId()),monster);
    }

    @Override
    public SlayerMonster read(SlayerMonster monster) {
        return entries.get(String.valueOf(monster.getTaskId()));
    }

    @Override
    public void delete(SlayerMonster monster) {
        entries.remove(String.valueOf(monster.getTaskId()));
    }
}
