package org.menaphos.commands.impl;

public abstract class AdministratorCommandListener extends OwnerCommandListener {

    protected AdministratorCommandListener() {
        this.addRank(2);
        this.addRank(33);
    }
}
