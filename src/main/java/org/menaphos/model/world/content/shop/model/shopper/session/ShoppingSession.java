package org.menaphos.model.world.content.shop.model.shopper.session;

import org.menaphos.entity.impl.impl.Customer;
import org.menaphos.model.world.content.shop.Shop;

public final class ShoppingSession {

    private final Customer shopper;
    private final Shop shop;

    public ShoppingSession(Customer shopper, Shop shop) {
        this.shopper = shopper;
        this.shop = shop;
    }

    public Customer getShopper() {
        return shopper;
    }

    public Shop getShop() {
        return shop;
    }
}
