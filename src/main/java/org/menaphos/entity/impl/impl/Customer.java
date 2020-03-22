package org.menaphos.entity.impl.impl;

import org.menaphos.model.finance.transaction.currency.CurrencyRequest;
import org.menaphos.model.world.content.shop.Shop;
import org.menaphos.model.world.content.shop.model.PurchaseRequest;

import java.util.Optional;

public interface Customer extends PlayableCharacter {

    Optional<Integer> inquire(int slot);

    Optional<Integer> appraise(int slot);

    Optional<PurchaseRequest> purchase(int id, int amount);

    Optional<CurrencyRequest> sell(int id, int amount);

    void createShoppingSession(Shop shop);

}
