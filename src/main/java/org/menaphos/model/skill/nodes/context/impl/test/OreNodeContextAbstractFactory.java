package org.menaphos.model.skill.nodes.context.impl.test;

import org.menaphos.model.skill.nodes.context.impl.RenewableNodeContextAbstractFactory;

public interface OreNodeContextAbstractFactory extends RenewableNodeContextAbstractFactory {

    @Override
    DummyOreContext getContext();
}
