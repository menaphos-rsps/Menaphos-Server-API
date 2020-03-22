package org.menaphos.model.world.content.shop.model;

import org.menaphos.entity.impl.item.ItemDefinitionFactory;

public final class ProfitMargin {

    private final float markup;

    public ProfitMargin(final float markup) {
        this.markup = markup != 0 ? markup : 1;
    }

    public int markdownItem(int id) {
        final int base = ItemDefinitionFactory.getDefinition(id).getGeneralPrice();
        return (int) (base - (base * markup));
    }

    public int markupItem(int id) {
        final int base = ItemDefinitionFactory.getDefinition(id).getGeneralPrice();
        return (int) (base + (base * markup));
    }

    public int markup(int value) {
        return (int) (value + (value * markup));
    }

    public int markdown(int value) {
        return (int) (value - (value * markup));
    }

    public float getMarkup() {
        return markup;
    }
}
