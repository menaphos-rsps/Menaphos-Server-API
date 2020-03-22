package org.menaphos.model.loot;

import org.phantasye.AbstractJsonRepository;

public class LootableNpcRepository extends AbstractJsonRepository<LootableNpc> {
    @Override
    public void create(LootableNpc lootableNpc) {
        entries.put(String.valueOf(lootableNpc.getId()),lootableNpc);
    }

    @Override
    public LootableNpc read(LootableNpc lootableNpc) {
        return entries.get(String.valueOf(lootableNpc.getId()));
    }

    @Override
    public void delete(LootableNpc lootableNpc) {
        entries.remove(String.valueOf(lootableNpc.getId()));
    }
}
