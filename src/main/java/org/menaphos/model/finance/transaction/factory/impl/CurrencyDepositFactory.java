package org.menaphos.model.finance.transaction.factory.impl;

import org.menaphos.model.finance.account.Account;
import org.menaphos.model.finance.transaction.Transaction;
import org.menaphos.model.finance.transaction.factory.AbstractTransactionFactory;
import org.menaphos.model.finance.transaction.impl.deposit.CurrencyDeposit;

public final class CurrencyDepositFactory implements AbstractTransactionFactory {

    private final Account source;
    private final int amount;

    public CurrencyDepositFactory(Account source,int amount) {
        this.source = source;
        this.amount = amount;
    }


    @Override
    public Transaction createTransaction() {
        return new CurrencyDeposit(source,amount);
    }
}
