package org.menaphos.action.impl.item;

import org.menaphos.entity.impl.impl.PlayableCharacter;

public class BaseItemOnItemAction extends ItemOnItemAction {

    private final PlayableCharacter player;

    public BaseItemOnItemAction(PlayableCharacter player, int sourceId, int targetId, int productId) {
        super(sourceId, targetId, productId);
        this.player = player;
    }

    @Override
    public boolean invoke() {
        return player.removeItemFromInventory(this.getSourceId(), 1)
                && player.removeItemFromInventory(this.getTargetId(), 1)
                && player.addItemToInventory(this.getProductId(), 1);
    }
}
