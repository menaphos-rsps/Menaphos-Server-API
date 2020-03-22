package org.menaphos.io.fs.repository;

import org.menaphos.Menaphos;
import org.menaphos.model.loot.LootableNpc;
import org.menaphos.model.loot.LootableNpcRepository;
import org.phantasye.RepositoryManager;

public final class LootableNpcRepositoryManager extends RepositoryManager<LootableNpc, LootableNpcRepository> {

    private static LootableNpcRepositoryManager instance = null;

    public static LootableNpcRepositoryManager getInstance() {
        if (instance == null)
            instance = new LootableNpcRepositoryManager();
        return instance;
    }

    private LootableNpcRepositoryManager() {
        super(Menaphos.getInstance().requestRepository(Menaphos.Repository.LOOTABLE_NPC).getAbsolutePath(), LootableNpcRepository.class);
    }
}
