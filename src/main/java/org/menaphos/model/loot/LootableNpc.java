package org.menaphos.model.loot;

import java.util.ArrayList;
import java.util.List;

public class LootableNpc extends LootableContainer {

    public LootableNpc(int id, String name, List<Loot> lootList) {
        super(id,name,lootList);
    }

    public LootableNpc(int id, String name) {
        this(id,name,new ArrayList<>());
    }
}
