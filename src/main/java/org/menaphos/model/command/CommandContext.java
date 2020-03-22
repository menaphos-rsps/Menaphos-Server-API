package org.menaphos.model.command;

import org.menaphos.model.entity.impl.character.Character;

public final class CommandContext {

    private final String content;
    private final Character author;

    public CommandContext(String content, Character author) {
        this.content = content;
        this.author = author;
    }

    public Character getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }
}
