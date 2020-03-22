package org.menaphos.model.world.content.shop.model;

public final class PurchaseRequest  {

    private final int id;
    private final int amount;
    private final int cost;

    public PurchaseRequest(int id, int amount, int cost) {
        this.id = id;
        this.amount = amount;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }
}
