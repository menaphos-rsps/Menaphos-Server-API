package org.menaphos.model.task.impl;

import org.menaphos.model.task.Task;
import org.menaphos.model.world.content.shop.Shop;
import org.menaphos.model.world.content.shop.model.merchandise.Stock;

public class RestockTask extends Task {

    private final int itemId;
    private final Shop shop;

    public RestockTask(final long refreshRate, final int itemId, Shop shop) {
        super(refreshRate);
        this.itemId =  itemId;
        this.shop = shop;
    }

    @Override
    public void run() {
        System.out.println("RESTOCKING");
        shop.add(itemId,1);
    }
}
