package org.menaphos.model.finance.transaction;

public abstract class Transaction {

    protected final int transactionAmount;

    protected Transaction(int transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public abstract boolean transact();

    public int getTransactionAmount() {
        return transactionAmount;
    }
}
