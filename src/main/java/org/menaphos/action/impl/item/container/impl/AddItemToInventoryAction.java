package org.menaphos.action.impl.item.container.impl;

import org.menaphos.action.impl.item.container.InventoryAction;
import org.menaphos.entity.impl.CharacterEntity;

public class AddItemToInventoryAction extends InventoryAction {


    public AddItemToInventoryAction(CharacterEntity characterEntity, int itemId, int amount) {
        super(characterEntity,itemId,amount);
    }

    @Override
    public boolean invoke() {
      return this.getActor().addItemToInventory(this.getItemId(),this.getAmount());
    }
}
