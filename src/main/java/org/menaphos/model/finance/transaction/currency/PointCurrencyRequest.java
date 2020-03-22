package org.menaphos.model.finance.transaction.currency;

public final class PointCurrencyRequest extends CurrencyRequest {

    public PointCurrencyRequest(String id, int amount) {
        super(id, amount);
    }

    @Override
    public String getId() {
        return (String) super.getId();
    }
}
