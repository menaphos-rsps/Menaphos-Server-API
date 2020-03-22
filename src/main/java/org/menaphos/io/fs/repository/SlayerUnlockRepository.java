package org.menaphos.io.fs.repository;

import org.menaphos.model.skill.slayer.SlayerUnlock;
import org.phantasye.AbstractJsonRepository;

public class SlayerUnlockRepository extends AbstractJsonRepository<SlayerUnlock> {
    @Override
    public void create(SlayerUnlock slayerUnlock) {
        entries.put(String.valueOf(slayerUnlock.getId()), slayerUnlock);
    }

    @Override
    public SlayerUnlock read(SlayerUnlock slayerUnlock) {
        return entries.get(String.valueOf(slayerUnlock.getId()));
    }

    @Override
    public void delete(SlayerUnlock slayerUnlock) {
        entries.remove(String.valueOf(slayerUnlock.getId()));
    }
}
