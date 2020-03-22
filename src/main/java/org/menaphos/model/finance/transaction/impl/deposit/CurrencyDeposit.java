package org.menaphos.model.finance.transaction.impl.deposit;

import org.menaphos.model.finance.account.Account;

public class CurrencyDeposit extends Deposit {

    protected final Account source;

    public CurrencyDeposit(Account source, int transactionAmount) {
        super(transactionAmount);
        this.source = source;
    }

    @Override
    public boolean deposit() {
        if ((source.getBalance().value() + transactionAmount) < Integer.MAX_VALUE){
            source.getBalance().add(transactionAmount);
            return true;
        }
        return false;
    }
}
