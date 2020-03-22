package org.menaphos.model.finance.transaction.factory;

import org.menaphos.model.finance.transaction.Transaction;

public class TransactionFactory {

    public static Transaction getTransaction(AbstractTransactionFactory abstractTransactionFactory) {
        return abstractTransactionFactory.createTransaction();
    }
}
