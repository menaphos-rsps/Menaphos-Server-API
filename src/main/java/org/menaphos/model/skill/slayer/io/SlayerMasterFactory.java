package org.menaphos.model.skill.slayer.io;

import org.menaphos.io.fs.repository.SlayerMasterRepositoryManager;
import org.menaphos.model.skill.slayer.npc.SlayerMaster;

import java.util.HashMap;
import java.util.Map;

public final class SlayerMasterFactory {

    private static final Map<Integer, SlayerMaster> slayerMasterMap = new HashMap<>();

    public static SlayerMaster getSlayerMaster(int npcId) {
        SlayerMaster slayerMaster = slayerMasterMap.get(npcId);

        if (slayerMaster == null)
            slayerMaster = SlayerMasterRepositoryManager.getInstance().getRepository().readByKey(String.valueOf(npcId));
        slayerMasterMap.put(npcId,slayerMaster);
        return slayerMaster;
    }
}
