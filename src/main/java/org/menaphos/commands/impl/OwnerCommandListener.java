package org.menaphos.commands.impl;

public abstract class OwnerCommandListener extends DeveloperCommandListener {

    protected OwnerCommandListener() {
        this.addRank(3);
    }

}
