package org.menaphos.action.impl.item.container;

import org.menaphos.action.impl.AbstractAction;
import org.menaphos.entity.impl.CharacterEntity;

public abstract class InventoryAction extends AbstractAction {

    private final int itemId;
    private final int amount;

    protected InventoryAction(CharacterEntity characterEntity, int itemId, int amount) {
        super(characterEntity);
        this.itemId = itemId;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public int getItemId() {
        return itemId;
    }
}
