package org.menaphos.io.fs.repository;

import org.menaphos.model.skill.slayer.npc.SlayerMaster;
import org.phantasye.AbstractJsonRepository;

public class SlayerMasterRepository extends AbstractJsonRepository<SlayerMaster> {
    @Override
    public void create(SlayerMaster slayerMaster) {
        entries.put(String.valueOf(slayerMaster.getId()),slayerMaster);
    }

    @Override
    public SlayerMaster read(SlayerMaster slayerMaster) {
        return entries.get(String.valueOf(slayerMaster.getId()));
    }

    @Override
    public void delete(SlayerMaster slayerMaster) {
        entries.remove(String.valueOf(slayerMaster.getId()));
    }
}
