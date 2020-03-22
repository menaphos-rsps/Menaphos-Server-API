package org.menaphos.model.finance.transaction.factory.impl;

import org.menaphos.model.finance.account.Account;
import org.menaphos.model.finance.transaction.Transaction;
import org.menaphos.model.finance.transaction.factory.AbstractTransactionFactory;
import org.menaphos.model.finance.transaction.impl.withdrawal.CurrencyWithdrawal;

public final class CurrencyWithdrawalFactory implements AbstractTransactionFactory {

    private final Account source;
    private final int amount;

    public CurrencyWithdrawalFactory(Account source, int amount) {
        this.source = source;
        this.amount = amount;
    }

    @Override
    public Transaction createTransaction() {
        return new CurrencyWithdrawal(source,amount);
    }
}
