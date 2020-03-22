package org.menaphos.io.fs.repository;

import org.menaphos.Menaphos;
import org.menaphos.model.loot.LootableObject;
import org.menaphos.model.loot.LootableObjectRepository;
import org.phantasye.RepositoryManager;

public class LootableObjectRepositoryManager extends RepositoryManager<LootableObject, LootableObjectRepository> {

    private static LootableObjectRepositoryManager instance = null;

    public static LootableObjectRepositoryManager getInstance() {
        if (instance == null)
            instance = new LootableObjectRepositoryManager();
        return instance;
    }

    private LootableObjectRepositoryManager() {
        super(Menaphos.getInstance().requestRepository(Menaphos.Repository.LOOTABLE_OBJECT).getAbsolutePath(), LootableObjectRepository.class);
    }
}
