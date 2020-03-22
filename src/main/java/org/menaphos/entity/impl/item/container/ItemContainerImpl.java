package org.menaphos.entity.impl.item.container;

import org.menaphos.entity.impl.item.CappedArrayList;
import org.menaphos.entity.impl.item.Item;
import org.menaphos.entity.impl.item.ItemDefinitionFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class ItemContainerImpl implements ItemContainer {

    private final int capacity;
    protected final ArrayList<ItemSlot> contents;

    public ItemContainerImpl(int capacity) {
        this.capacity = capacity;
        this.contents = new CappedArrayList<>(capacity);
    }

    @Override
    public boolean remove(int id, int amount) {
        if (canRemove(id,amount)) {
            if (this.contains(id) && this.count(id) - amount > 0)
                this.getItemById(id).getAmount().subtract(amount);
            return contents.remove(this.slot(id)) != null;
        }
        return false;
    }

    @Override
    public boolean contains(int id) {
        return contents.stream().anyMatch(slot-> Objects.equals(slot.getId(), id));
    }

    @Override
    public boolean canAdd(int id, int amount) {
        if (!this.isFull() && amount > 0) {
            final boolean stackable = ItemDefinitionFactory.getDefinition(id).isStackable();
            if (this.contains(id) && stackable )
                return this.getItemById(id).getAmount().value() < Integer.MAX_VALUE;
            else if (!this.contains(id) && stackable)
                return this.freeSlots() >= 1;
            else if (!stackable)
                return this.freeSlots() >= amount;
        }
        return false;
    }

    @Override
    public boolean canRemove(int id, int amount) {
        if (!contents.isEmpty()) {
            final boolean stackable = ItemDefinitionFactory.getDefinition(id).isStackable();
            if (this.contains(id) && stackable) {
                return this.getItemById(id).getAmount().value() >= amount;
            } else if (!stackable) {
                return this.getAll(id).size() >= amount;
            }
        }
        return false;
    }

    @Override
    public int count(int id) {
        final boolean stackable = ItemDefinitionFactory.getDefinition(id).isStackable();
        if (this.contains(id))
            if (stackable)
                return this.getItemById(id).getAmount().value();
            else
                return contents.stream().filter(slot -> slot.getId() == id).collect(Collectors.toList()).size();
        return 0;
    }

    @Override
    public boolean isFull() {
        return contents.size() == capacity;
    }

    @Override
    public int capacity() {
        return capacity;
    }


    @Override
    public int slot(int id) {
        for (int i = 0; i < contents.size(); i++) {
            if (contents.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void empty() {
        contents.clear();
    }

    @Override
    public int freeSlots() {
        return capacity - contents.size();
    }

    @Override
    public List<ItemSlot> contents() {
        return contents;
    }

    @Override
    public List<ItemSlot> getAll(int id) {
        return contents.stream().filter(slot -> slot.getId() == id).collect(Collectors.toList());
    }

    @Override
    public ItemSlot getItem(Item item) {
        return this.contains(item.getId()) ? contents.stream().filter(i-> Objects.equals(i.getId(), item.getId())).findAny().get() : null;
    }

    @Override
    public ItemSlot getItemById(int id) {
        return getItem(new Item(id));
    }

    @Override
    public ItemSlot getSlot(int slot) {
        return contents.size() >= slot ? contents.get(slot) : null;
    }

    @Override
    public ItemSlot[] getReadOnlyContents() {
        ItemSlot[] items = new ItemSlot[capacity];
        for (int i = 0; i < items.length; i++) {
            if (i < contents.size())
                items[i] = contents.get(i);
            else
                items[i] = new ItemSlot(-1,0);
        }
        return items;
    }
}
