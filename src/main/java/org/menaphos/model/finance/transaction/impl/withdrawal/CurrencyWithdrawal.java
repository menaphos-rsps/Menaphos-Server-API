package org.menaphos.model.finance.transaction.impl.withdrawal;

import org.menaphos.model.finance.account.Account;

public class CurrencyWithdrawal extends Withdrawal {

    protected final Account source;

    public CurrencyWithdrawal(Account source, int transactionAmount) {
        super(transactionAmount);
        this.source = source;
    }

    @Override
    public boolean withdraw() {
        if (source.getBalance().contains(transactionAmount)) {
            source.getBalance().subtract(transactionAmount);
            return true;
        }
        return false;
    }
}
