package org.menaphos.entity.impl.item;

import org.menaphos.model.math.impl.AdjustableInteger;

public class Item {

    private final int id;
    private final AdjustableInteger amount;

    public Item(int id) {
        this.id = id;
        this.amount = new AdjustableInteger(0);
    }

    public Item(int id, int amount) {
        this.id = id;
        this.amount = new AdjustableInteger(amount);
    }

    public AdjustableInteger getAmount() {
        return amount;
    }

    public int getId() {
        return id;
    }

    public ItemDefinition getDefinition() {
        return ItemDefinitionFactory.getDefinition(id);
    }
}
