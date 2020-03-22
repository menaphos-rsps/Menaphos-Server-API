package org.menaphos.commands.impl;

import org.menaphos.commands.CommandListener;

public abstract class DeveloperCommandListener extends CommandListener {

    protected DeveloperCommandListener() {
        this.addRank(3);
    }
}
