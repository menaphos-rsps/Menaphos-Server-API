package org.menaphos.model.finance.transaction.currency;

import org.menaphos.io.fs.repository.CurrencyRepositoryManager;
import org.phantasye.RepositoryManager;

import java.util.HashMap;
import java.util.Map;

public final class CurrencyFactory {

    private static final Map<String,Currency> currencyMap = new HashMap<>();

    public static Currency getCurrency(String id) {
        Currency currency = currencyMap.get(id);

        if (currency == null) {
            final RepositoryManager<Currency,CurrencyRepository> rm = new CurrencyRepositoryManager();
            currency = rm.getRepository().readByKey(id);
            if(currency == null) {
                throw new NullPointerException("Currency Not Found: " + id);
            }
            currencyMap.put(id,currency);
        }
        return currency;
    }
}
