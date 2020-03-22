package org.menaphos.model.skill.item.tool.impl;

import org.menaphos.model.skill.item.tool.GatheringTool;
import org.menaphos.model.skill.item.tool.GatheringToolAbstractFactory;

public class GatheringToolFactory implements GatheringToolAbstractFactory {

    private final int itemId;

    public GatheringToolFactory(int itemId) {
        this.itemId = itemId;
    }

    @Override
    public GatheringTool getItem() {
        return new Pickaxe(itemId,1,1,1);
    }
}
