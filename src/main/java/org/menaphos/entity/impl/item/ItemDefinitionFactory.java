package org.menaphos.entity.impl.item;

import org.menaphos.Menaphos;
import org.phantasye.RepositoryManager;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class ItemDefinitionFactory {

    private static Map<Integer, ItemDefinition> itemDefinitionMap = new HashMap<>();

    public static ItemDefinition getDefinition(int id) {
        ItemDefinition definition = itemDefinitionMap.get(id);

        if(definition == null) {
            RepositoryManager<ItemDefinition, ItemDefinitionRepository> itemRepositoryManager = Menaphos.getItemDefinitionRepositoryManager();
            definition = itemRepositoryManager.getRepository().readByKey(String.valueOf(id));
            if(definition == null) {
                throw new NullPointerException("Missing Definition For: " + id);
            }
            itemDefinitionMap.put(id,definition);
        }
        return definition;
    }

    public static ItemDefinition getDefinition(String name) {
        ItemDefinition definition = itemDefinitionMap.values().stream()
                .filter(itemDefinition -> itemDefinition.getName().equalsIgnoreCase(name))
                .findAny().orElse(null);


        if(definition == null) {
            RepositoryManager<ItemDefinition, ItemDefinitionRepository> itemRepositoryManager = Menaphos.getItemDefinitionRepositoryManager();
            definition = itemRepositoryManager.getRepository().readAll().stream()
                    .filter(itemDefinition -> itemDefinition.getName().equalsIgnoreCase(name))
                    .findAny()
                    .orElse(null);
            if(definition == null) {
                throw new NullPointerException("Missing Definition For: " + name);
            }
            itemDefinitionMap.put(definition.getId(),definition);
        }
        return definition;
    }

}
