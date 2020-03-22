package org.menaphos.event.impl.entity.character.impl.command;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.menaphos.event.impl.entity.character.CharacterEvent;
import org.menaphos.model.command.CommandContext;
import org.menaphos.model.entity.impl.character.Character;

public class CommandEvent extends CharacterEvent {

    private final CommandContext context;

    public CommandEvent(Character entity, String content) {
        super(entity);
        this.context = new CommandContext(content,entity);
    }

    @Override
    public boolean execute() {
        return false;
    }

    public CommandContext getContext() {
        return context;
    }
}
