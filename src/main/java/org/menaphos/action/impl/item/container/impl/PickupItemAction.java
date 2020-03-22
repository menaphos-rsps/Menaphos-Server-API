package org.menaphos.action.impl.item.container.impl;

import org.menaphos.action.impl.item.container.InventoryAction;
import org.menaphos.entity.impl.CharacterEntity;

public class PickupItemAction extends InventoryAction {

    public PickupItemAction(CharacterEntity characterEntity, int itemId, int amount) {
        super(characterEntity, itemId, amount);
    }

    @Override
    public boolean invoke() {
        return this.getActor().pickupItem(this.getItemId(),this.getAmount());
    }
}
