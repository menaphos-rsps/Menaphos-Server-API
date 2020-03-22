package org.menaphos.action.impl.item;

import org.menaphos.action.impl.AbstractAction;

public abstract class ItemOnItemAction extends AbstractAction {

    private final int sourceId;
    private final int targetId;
    private final int productId;

    public ItemOnItemAction(int sourceId, int targetId, int productId) {
        super(null);
        this.sourceId = sourceId;
        this.targetId = targetId;
        this.productId = productId;
    }

    public int getProductId() {
        return productId;
    }

    public int getTargetId() {
        return targetId;
    }

    public int getSourceId() {
        return sourceId;
    }

    @Override
    public String toString() {
        return String.valueOf(sourceId) + targetId;
    }
}
