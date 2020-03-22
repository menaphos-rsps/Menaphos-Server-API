package org.menaphos.commands.impl;

public abstract class ModeratorCommandListener extends AdministratorCommandListener {

    protected ModeratorCommandListener() {
        this.addRank(1);
    }
}
