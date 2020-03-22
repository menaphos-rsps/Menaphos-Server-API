package org.menaphos.commands.impl;

import org.menaphos.commands.CommandListener;

public abstract class PlayerCommandListener extends CommandListener {

    protected PlayerCommandListener() {
        this.addRank(0);
        this.addRank(1);
        this.addRank(2);
        this.addRank(3);
    }
}
