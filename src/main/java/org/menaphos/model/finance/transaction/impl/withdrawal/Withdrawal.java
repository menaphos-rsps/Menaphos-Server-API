package org.menaphos.model.finance.transaction.impl.withdrawal;

import org.menaphos.model.finance.transaction.Transaction;

public abstract class Withdrawal extends Transaction {

    public Withdrawal(int transactionAmount) {
        super(transactionAmount);

    }

    public abstract boolean withdraw();

    @Override
    public boolean transact() {
        return withdraw();
    }

}
