package org.menaphos.entity.impl.item.container.impl;

import org.menaphos.entity.impl.item.ItemDefinitionFactory;
import org.menaphos.entity.impl.item.container.ItemContainerImpl;
import org.menaphos.entity.impl.item.container.ItemSlot;

public class DefaultItemContainerImpl extends ItemContainerImpl {

    public DefaultItemContainerImpl(int capacity) {
        super(capacity);
    }

    @Override
    public boolean add(int id, int amount) {
        if (canAdd(id,amount)) {
            final boolean stackable = ItemDefinitionFactory.getDefinition(id).isStackable();
            if (stackable && this.contains(id)) {
                return this.getItemById(id).getAmount().add(amount) < Integer.MAX_VALUE;
            } else if (stackable && !this.contains(id)) {
                return contents.add(new ItemSlot(id,amount));
            } else if (!stackable && amount > 1) {
                return (contents.add(new ItemSlot(id, 1)) && add(id,--amount));
            } else {
                return contents.add(new ItemSlot(id));
            }
        }
        return false;
    }
}
