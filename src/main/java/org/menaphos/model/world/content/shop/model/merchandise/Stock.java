package org.menaphos.model.world.content.shop.model.merchandise;

import org.menaphos.entity.impl.item.Item;
import org.menaphos.model.math.impl.AdjustableInteger;

public final class Stock {

    private final Item item;
    private final int cap;
    private final AdjustableInteger onHand;

    public Stock(Item item, int cap, int onHand) {
        this.item = item;
        this.cap = cap;
        this.onHand = new AdjustableInteger(onHand);
    }

    public Item getItem() {
        return item;
    }

    public int getCap() {
        return cap;
    }

    public AdjustableInteger getOnHand() {
        return onHand;
    }
}
