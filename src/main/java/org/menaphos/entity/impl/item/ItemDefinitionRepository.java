package org.menaphos.entity.impl.item;

import org.phantasye.AbstractJsonRepository;

public class ItemDefinitionRepository extends AbstractJsonRepository<ItemDefinition> {

    @Override
    public void create(ItemDefinition itemDefinition) {
        entries.put(String.valueOf(itemDefinition.getId()),itemDefinition);
    }

    @Override
    public ItemDefinition read(ItemDefinition itemDefinition) {
        return entries.get(String.valueOf(itemDefinition.getId()));
    }

    @Override
    public void delete(ItemDefinition itemDefinition) {
        entries.remove(String.valueOf(itemDefinition.getId()));
    }
}
