package org.menaphos.model.finance.transaction.impl.transfer;

import org.menaphos.model.finance.account.Account;
import org.menaphos.model.finance.transaction.factory.TransactionFactory;
import org.menaphos.model.finance.transaction.factory.impl.CurrencyDepositFactory;
import org.menaphos.model.finance.transaction.factory.impl.CurrencyWithdrawalFactory;

public final class CurrencyTransfer extends Transfer {

    public CurrencyTransfer(Account source, Account target, int transactionAmount ) {
        super(source, target, transactionAmount);
    }

    @Override
    public boolean transfer() {
        return this.getSource().getHolder().transact(
                TransactionFactory.getTransaction(new CurrencyWithdrawalFactory(this.getSource(),transactionAmount))) &&
                this.getTarget().getHolder().transact(
                        TransactionFactory.getTransaction(new CurrencyDepositFactory(this.getTarget(),transactionAmount)));
    }
}
