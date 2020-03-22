package org.menaphos.model.loot;

import org.menaphos.entity.impl.item.Item;
import org.menaphos.model.math.Range;

public class RangeLoot extends Loot {

    public RangeLoot(int itemId, float percentDrop, Range range) {
        super(new Item(itemId,0), percentDrop,range);
    }
}
