package org.menaphos.model.skill.slayer.io;

import org.menaphos.io.fs.repository.SlayerMonsterRepositoryManager;
import org.menaphos.model.skill.slayer.task.SlayerMonster;

import java.util.HashMap;
import java.util.Map;

public class SlayerMonsterFactory {

    private static final Map<Integer, SlayerMonster> slayerMonsterMap = new HashMap<>();

    public static SlayerMonster getSlayerMonsterForTask(int taskId) {
        SlayerMonster slayerMonster = slayerMonsterMap.get(taskId);

        if (slayerMonster == null) {
            slayerMonster = SlayerMonsterRepositoryManager.getInstance().getRepository().readByKey(String.valueOf(taskId));
        }
        slayerMonsterMap.put(taskId,slayerMonster);
        return slayerMonster;
    }
}
