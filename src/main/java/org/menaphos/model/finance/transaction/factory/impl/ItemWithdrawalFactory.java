package org.menaphos.model.finance.transaction.factory.impl;

import org.menaphos.entity.impl.item.container.ItemContainer;
import org.menaphos.model.finance.transaction.Transaction;
import org.menaphos.model.finance.transaction.factory.AbstractTransactionFactory;
import org.menaphos.model.finance.transaction.impl.withdrawal.ItemWithdrawal;

public class ItemWithdrawalFactory implements AbstractTransactionFactory {

    private final ItemContainer itemContainer;
    private final int itemId,amount;

    public ItemWithdrawalFactory(ItemContainer itemContainer, int itemId, int amount) {
        this.itemContainer = itemContainer;
        this.itemId = itemId;
        this.amount = amount;
    }

    @Override
    public Transaction createTransaction() {
        return new ItemWithdrawal(itemContainer,itemId,amount);
    }
}
