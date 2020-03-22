package org.menaphos.model.finance.transaction.impl.deposit;

import org.menaphos.model.finance.transaction.Transaction;

public abstract class Deposit extends Transaction {

    protected Deposit(int transactionAmount) {
        super(transactionAmount);
    }

    public abstract boolean deposit();

    @Override
    public boolean transact() {
        return deposit();
    }

}
