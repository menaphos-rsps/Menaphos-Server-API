package org.menaphos.io.fs.repository;

import org.menaphos.Menaphos;
import org.menaphos.entity.impl.item.ItemDefinition;
import org.menaphos.entity.impl.item.ItemDefinitionRepository;
import org.phantasye.RepositoryManager;

public class ItemDefinitionRepositoryManager extends RepositoryManager<ItemDefinition, ItemDefinitionRepository> {

    private static ItemDefinitionRepositoryManager instance = null;

    public static ItemDefinitionRepositoryManager getInstance() {
        if (instance == null)
            instance = new ItemDefinitionRepositoryManager();
        return instance;
    }

    private ItemDefinitionRepositoryManager() {
        super(Menaphos.getInstance().requestRepository(Menaphos.Repository.ITEM_DEFINITION).getAbsolutePath(), ItemDefinitionRepository.class);
    }
}
