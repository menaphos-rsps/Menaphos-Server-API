package org.menaphos.action.impl.item.container.impl;

import org.menaphos.action.impl.item.container.InventoryAction;
import org.menaphos.entity.impl.CharacterEntity;

public class RemoveItemFromInventoryAction extends InventoryAction {

    public RemoveItemFromInventoryAction(CharacterEntity characterEntity, int itemId, int amount) {
        super(characterEntity, itemId, amount);
    }

    @Override
    public boolean invoke() {
        return this.getActor().removeItemFromInventory(this.getItemId(),this.getAmount());
    }
}
