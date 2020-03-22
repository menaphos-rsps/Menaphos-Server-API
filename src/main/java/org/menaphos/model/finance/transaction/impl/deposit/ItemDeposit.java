package org.menaphos.model.finance.transaction.impl.deposit;

import org.menaphos.entity.impl.item.container.ItemContainer;

public class ItemDeposit extends Deposit {

    private final ItemContainer itemContainer;
    private final int itemId;

    public ItemDeposit(ItemContainer itemContainer,int itemId, int transactionAmount) {
        super(transactionAmount);
        this.itemContainer = itemContainer;
        this.itemId = itemId;
    }

    @Override
    public boolean deposit() {
        return itemContainer.add(itemId,transactionAmount);
    }
}
