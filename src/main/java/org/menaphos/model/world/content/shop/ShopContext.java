package org.menaphos.model.world.content.shop;

import org.menaphos.model.finance.transaction.currency.Currency;
import org.menaphos.model.world.content.shop.model.ProfitMargin;

public final class ShopContext {

    private final String name;
    private final int id;
    private final boolean premium;
    private final boolean resale;
    private final long refreshRate;
    private final Currency currency;
    private final ProfitMargin profitMargin;

    private ShopContext(ShopContextBuilder bldr) {
        this.name = bldr.name;
        this.id = bldr.id;
        this.premium = bldr.premium;
        this.resale = bldr.resale;
        this.refreshRate = bldr.refreshRate;
        this.currency = bldr.currency;
        this.profitMargin = bldr.profitMargin;
    }

    public ProfitMargin getProfitMargin() {
        return profitMargin;
    }

    public int getId() {
        return id;
    }

    public Currency getCurrency() {
        return currency;
    }

    public boolean isResale() {
        return resale;
    }

    public String getName() {
        return name;
    }

    public boolean isPremium() {
        return premium;
    }

    public long getRefreshRate() {
        return refreshRate;
    }

    public static class ShopContextBuilder {

        private final int id;
        private String name;
        private boolean premium;
        private boolean resale;
        private long refreshRate;
        private Currency currency;
        private ProfitMargin profitMargin;

        public ShopContextBuilder(int id) {
            this.id = id;
        }

        public ShopContextBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ShopContextBuilder isPremium(boolean premium) {
            this.premium = premium;
            return this;
        }

        public ShopContextBuilder doesResale(boolean resale) {
            this.resale = resale;
            return this;
        }

        public ShopContextBuilder withRefreshRate(long ms) {
            this.refreshRate = ms;
            return this;
        }

        public ShopContextBuilder usesCurrency(Currency currency) {
            this.currency = currency;
            return this;
        }

        public ShopContextBuilder withProfitMargin(float margin) {
            this.profitMargin = new ProfitMargin(margin);
            return this;
        }

        public ShopContext build() {
            return new ShopContext(this);
        }
    }
}
