package org.menaphos.io.fs.repository;

import org.menaphos.Menaphos;
import org.menaphos.model.loot.LootableItem;
import org.menaphos.model.loot.LootableItemRepository;
import org.phantasye.RepositoryManager;

public class LootableItemRepositoryManager extends RepositoryManager<LootableItem, LootableItemRepository> {

    private static LootableItemRepositoryManager instance = null;

    public static LootableItemRepositoryManager getInstance() {
        if (instance == null)
            instance = new LootableItemRepositoryManager();
        return instance;
    }

    private LootableItemRepositoryManager() {
        super(Menaphos.getInstance().requestRepository(Menaphos.Repository.LOOTABLE_ITEM).getAbsolutePath(), LootableItemRepository.class);
    }
}
