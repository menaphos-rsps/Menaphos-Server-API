package org.menaphos.model.finance.transaction.currency;

import org.phantasye.AbstractJsonRepository;

public final class CurrencyRepository extends AbstractJsonRepository<Currency> {
    @Override
    public void create(Currency currency) {
        entries.put(currency.getId(),currency);
    }

    @Override
    public Currency read(Currency currency) {
        return entries.get(currency.getId());
    }

    @Override
    public void delete(Currency currency) {
        entries.remove(currency.getId());
    }
}
