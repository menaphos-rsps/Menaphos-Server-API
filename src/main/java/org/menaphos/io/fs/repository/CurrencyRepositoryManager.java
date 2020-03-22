package org.menaphos.io.fs.repository;

import org.menaphos.Menaphos;
import org.menaphos.model.finance.transaction.currency.Currency;
import org.menaphos.model.finance.transaction.currency.CurrencyRepository;
import org.phantasye.RepositoryManager;

public final class CurrencyRepositoryManager extends RepositoryManager<Currency, CurrencyRepository> {

    public CurrencyRepositoryManager() {
        super(Menaphos.getInstance().requestRepository(Menaphos.Repository.CURRENCY).getAbsolutePath(), CurrencyRepository.class);
    }
}
