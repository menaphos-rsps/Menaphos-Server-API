package org.menaphos.model.world.content.shop.model.merchandise;

import org.menaphos.entity.impl.item.Item;
import org.menaphos.entity.impl.item.ItemDefinitionFactory;
import org.menaphos.model.world.content.shop.model.ProfitMargin;

public final class Merchandise extends Item {

    private final Stock stock;
    private final boolean premium;
    private final int basePrice;
    private final ProfitMargin markup;
    private final long refreshRate;

    public Merchandise(Stock stock, boolean premium, int basePrice, ProfitMargin markup, long refreshRate) {
        super(stock.getItem().getId());
        this.stock = stock;
        this.premium = premium;
        this.basePrice = basePrice;
        this.markup = markup;
        this.refreshRate = refreshRate;
    }

    public Merchandise(Stock stock, boolean premium, ProfitMargin markup, long refreshRate) {
        super(stock.getItem().getId());
        this.stock = stock;
        this.premium = premium;
        this.basePrice = ItemDefinitionFactory.getDefinition(stock.getItem().getId()).getGeneralPrice();
        this.markup = markup;
        this.refreshRate = refreshRate;
    }

    public Merchandise(Stock stock, boolean premium, long refreshRate) {
        super(stock.getItem().getId());
        this.stock = stock;
        this.premium = premium;
        this.basePrice = ItemDefinitionFactory.getDefinition(stock.getItem().getId()).getGeneralPrice();
        this.markup = new ProfitMargin(0);
        this.refreshRate = refreshRate;
    }

    public Merchandise(Stock stock) {
        super(stock.getItem().getId());
        this.stock = stock;
        this.premium = false;
        this.basePrice = ItemDefinitionFactory.getDefinition(stock.getItem().getId()).getGeneralPrice();
        this.markup = new ProfitMargin(0);
        this.refreshRate = 1;
    }

    public Stock getStock() {
        return stock;
    }

    public boolean isPremium() {
        return premium;
    }

    public ProfitMargin getMarkup() {
        return markup;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public long getRefreshRate() {
        return refreshRate;
    }

    public boolean isBasicMerchandise() {
        return basePrice == ItemDefinitionFactory.getDefinition(stock.getItem().getId()).getGeneralPrice() && markup.getMarkup() == 1;
    }

    public boolean isMarkedUp() {
        return markup.getMarkup() != 1;
    }

    public boolean isPriced() {
        return basePrice != ItemDefinitionFactory.getDefinition(stock.getItem().getId()).getGeneralPrice();
    }

}
