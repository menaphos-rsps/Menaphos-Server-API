package org.menaphos.event.impl.entity.character.impl.inventory;

import org.menaphos.model.entity.impl.character.Character;
import org.menaphos.model.finance.transaction.factory.impl.ItemDepositFactory;

public class InventoryDepositEvent extends InventoryEvent {

    private final int itemId,amount;

    public InventoryDepositEvent(Character entity, int itemId, int amount) {
        super(entity,new ItemDepositFactory(entity.getInventory(),itemId,amount).createTransaction());
        this.itemId = itemId;
        this.amount = amount;
    }

    public int getItemId() {
        return itemId;
    }

    public int getAmount() {
        return amount;
    }
}
