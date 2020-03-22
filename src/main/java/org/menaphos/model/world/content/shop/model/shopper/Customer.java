package org.menaphos.model.world.content.shop.model.shopper;

import org.menaphos.model.finance.transaction.currency.CurrencyRequest;
import org.menaphos.model.world.content.shop.model.PurchaseRequest;
import org.menaphos.model.world.content.shop.model.merchandise.Merchandise;

import java.util.Optional;

public interface Customer {

    Optional<Integer> inquire(int slot);
    Optional<Integer> appraise(int slot);

    Optional<PurchaseRequest> purchase(int id, int amount);

    Optional<CurrencyRequest> sell(int id, int amount);
}
