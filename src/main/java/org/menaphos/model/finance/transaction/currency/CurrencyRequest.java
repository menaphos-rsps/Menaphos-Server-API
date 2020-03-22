package org.menaphos.model.finance.transaction.currency;

public class CurrencyRequest {

    private final String id;
    private final int amount;

    public CurrencyRequest(String id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }
}
