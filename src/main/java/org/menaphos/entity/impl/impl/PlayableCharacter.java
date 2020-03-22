package org.menaphos.entity.impl.impl;

import org.menaphos.Menaphos;
import org.menaphos.action.impl.item.container.impl.AddItemToInventoryAction;
import org.menaphos.action.impl.item.container.impl.RemoveItemFromInventoryAction;
import org.menaphos.entity.impl.CharacterEntity;
import org.menaphos.model.loot.Loot;
import org.menaphos.model.loot.LootableContainer;
import org.menaphos.model.loot.LootableItem;
import org.menaphos.model.loot.LootableObject;
import org.menaphos.model.world.location.Location;

public interface PlayableCharacter extends CharacterEntity {

    int getRights();

    double getMagicFind();

    default void loot(LootableContainer lootable) {
        final Loot loot = lootable.open(getMagicFind());
        if (lootable instanceof LootableObject) {
            lootObject((LootableObject) lootable,loot);
        } else if(lootable instanceof LootableItem) {
            lootItem((LootableItem) lootable,loot);
        }
    }

    default void lootItem(LootableItem lootable, Loot loot) {
        Menaphos.getInstance().getActionInvoker().perform(new AddItemToInventoryAction(this,loot.getItem().getId(),loot.getItem().getAmount().value()));
        this.removeItemFromInventory(lootable.getId(), 1);
    }

    default void lootObject(LootableObject lootable, Loot loot) {
        if (this.hasItem(lootable.getKeyId(), lootable.getKeyQty())) {
            Menaphos.getInstance().getActionInvoker().perform(new RemoveItemFromInventoryAction(this, lootable.getKeyId(), lootable.getKeyQty()));
            this.performAnimation(lootable.getAnimationId());
            Menaphos.getInstance().getActionInvoker().perform(new AddItemToInventoryAction(this,loot.getItem().getId(), loot.getItem().getAmount().value()));
        } else if (lootable.getAttemptMessage() == null) {
            this.receiveMessage("You can't open this.");
        } else {
            this.receiveMessage(lootable.getAttemptMessage());
        }
    }

    int getLevelFor(int skill);

    void receiveDropFrom(NonPlayableCharacter npc, Loot loot, Location dropLocation);



    void register();

    void deregister();
}
