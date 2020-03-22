package org.menaphos.model.finance.transaction.factory;

import org.menaphos.model.finance.transaction.Transaction;

public interface AbstractTransactionFactory {

    Transaction createTransaction();
}
