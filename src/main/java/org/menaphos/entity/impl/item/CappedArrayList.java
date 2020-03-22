package org.menaphos.entity.impl.item;

import java.util.ArrayList;

public final class CappedArrayList<E> extends ArrayList<E> {

    private final int capacity;

    public CappedArrayList(final int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean add(E e) {
        if(this.size() < capacity)
            return super.add(e);
        return false;
    }

}
