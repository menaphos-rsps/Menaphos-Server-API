package org.menaphos.model.finance.transaction.impl.transfer;

import org.menaphos.model.finance.account.Account;
import org.menaphos.model.finance.transaction.Transaction;

public abstract class Transfer extends Transaction {

    private final Account source;
    private final Account target;

    protected Transfer(Account source, Account target,int transactionAmount) {
        super(transactionAmount);
        this.source = source;
        this.target = target;
    }

    public abstract boolean transfer();

    @Override
    public boolean transact() {
        return transfer();
    }

    public Account getSource() {
        return source;
    }

    public Account getTarget() {
        return target;
    }
}
