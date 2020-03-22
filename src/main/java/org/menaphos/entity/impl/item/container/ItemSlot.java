package org.menaphos.entity.impl.item.container;

import org.menaphos.entity.impl.item.Item;
import org.menaphos.model.math.impl.AdjustableInteger;

public class ItemSlot {

    private final int id;
    private final AdjustableInteger amount;

    public ItemSlot(int id, int amount) {
        this.id = id;
        this.amount = new AdjustableInteger(amount);
    }

    public ItemSlot(int id) {
        this.id = id;
        this.amount = new AdjustableInteger(1);
    }

    public AdjustableInteger getAmount() {
        return amount;
    }

    public int getId() {
        return id;
    }

    public Item getItem() {
        return new Item(id);
    }

    public int count() {
        return amount.value();
    }
}
