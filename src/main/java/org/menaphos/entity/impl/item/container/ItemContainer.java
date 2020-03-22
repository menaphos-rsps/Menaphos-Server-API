package org.menaphos.entity.impl.item.container;

import org.menaphos.entity.impl.item.Item;

import java.util.List;

public interface ItemContainer {

    boolean add(int id, int amount);

    boolean remove(int id, int amount);

    boolean contains(int id);

    boolean canAdd(int id, int amount);

    boolean canRemove(int id, int amount);

    boolean isFull();

    int capacity();

    int count(int id);

    int slot(int id);

    void empty();

    int freeSlots();

    List<ItemSlot> contents();

    List<ItemSlot> getAll(int id );

    ItemSlot getItem(Item item);

    ItemSlot getItemById(int id);

    ItemSlot getSlot(int slot);

    ItemSlot[] getReadOnlyContents();
}
