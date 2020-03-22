package org.menaphos.entity.impl.item.container.impl;

import org.menaphos.entity.impl.item.container.ItemContainerImpl;
import org.menaphos.entity.impl.item.container.ItemSlot;

public class MerchandiseItemContainerImpl extends ItemContainerImpl{

    public MerchandiseItemContainerImpl(int capacity) {
        super(capacity);
    }

    @Override
    public boolean add(int id, int amount) {
        if (canAdd(id, amount)) {
            if (this.contains(id)) {
                return this.getItemById(id).getAmount().add(amount) < Integer.MAX_VALUE;
            } else {
                return contents.add(new ItemSlot(id, amount));
            }
        }
        return false;
    }

    @Override
    public boolean remove(int id, int amount) {
        if (canRemove(id, amount)) {
            if (this.contains(id) && this.count(id) - amount > 0) {
                this.getItemById(id).getAmount().subtract(amount);
                return true;
            } else if(this.contains(id) && this.count(id) - amount == 0)
                return contents.remove(this.slot(id)) != null;
        }
        return false;
    }

    @Override
    public int count(int id) {
        if (this.contains(id))
            return this.getItemById(id).getAmount().value();
        return 0;
    }

    @Override
    public boolean canAdd(int id, int amount) {
        if (!this.isFull() && amount > 0) {
            if (this.contains(id))
                return this.getItemById(id).getAmount().value() < Integer.MAX_VALUE;
            else if (!this.contains(id))
                return this.freeSlots() >= 1;
        }
        return false;
    }

    @Override
    public boolean canRemove(int id, int amount) {
        if (!contents.isEmpty()) {
            if (this.contains(id)) {
                return this.getItemById(id).getAmount().value() > amount;
            }
        }
        return false;
    }


}
