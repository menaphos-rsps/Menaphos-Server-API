package org.menaphos.event.impl.entity.character.impl.inventory;

import org.menaphos.model.entity.impl.character.Character;
import org.menaphos.model.finance.transaction.factory.impl.ItemWithdrawalFactory;

public final class InventoryWithdrawalEvent extends InventoryEvent {

    private final int itemId,amount;

    public InventoryWithdrawalEvent(Character entity,int itemId, int amount) {
        super(entity,new ItemWithdrawalFactory(entity.getInventory(),itemId,amount).createTransaction());
        this.itemId = itemId;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public int getItemId() {
        return itemId;
    }
}
