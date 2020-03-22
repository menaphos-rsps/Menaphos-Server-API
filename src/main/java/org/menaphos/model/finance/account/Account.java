package org.menaphos.model.finance.account;

import org.menaphos.model.finance.transaction.Transactor;
import org.menaphos.model.math.AdjustableNumber;

public final class Account {

    private final AdjustableNumber<Integer> balance;
    private final Transactor holder;

    public Account(AdjustableNumber<Integer> balance, Transactor holder) {
        this.balance = balance;
        this.holder = holder;
    }

    public AdjustableNumber<Integer> getBalance() {
        return balance;
    }

    public Transactor getHolder() {
        return holder;
    }
}
