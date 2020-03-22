package org.menaphos.model.finance.transaction.impl.withdrawal;

import org.menaphos.entity.impl.item.container.ItemContainer;

public class ItemWithdrawal extends Withdrawal {

    private final ItemContainer itemContainer;
    private final int itemId;

    public ItemWithdrawal(ItemContainer itemContainer,int itemId, int transactionAmount) {
        super(transactionAmount);
        this.itemContainer = itemContainer;
        this.itemId = itemId;
    }

    @Override
    public boolean withdraw() {
       return itemContainer.remove(itemId,transactionAmount);
    }
}
