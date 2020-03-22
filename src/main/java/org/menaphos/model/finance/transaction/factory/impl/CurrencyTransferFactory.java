package org.menaphos.model.finance.transaction.factory.impl;

import org.menaphos.model.finance.account.Account;
import org.menaphos.model.finance.transaction.Transaction;
import org.menaphos.model.finance.transaction.factory.AbstractTransactionFactory;
import org.menaphos.model.finance.transaction.impl.transfer.CurrencyTransfer;

public final class CurrencyTransferFactory implements AbstractTransactionFactory {

    private final Account source;
    private final Account target;
    private final int amount;

    public CurrencyTransferFactory(Account source, Account target, int amount ) {
        this.source = source;
        this.target = target;
        this.amount = amount;
    }

    @Override
    public Transaction createTransaction() {
        return new CurrencyTransfer(source, target, amount);
    }
}
