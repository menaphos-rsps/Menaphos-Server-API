package org.menaphos.commands;

import org.menaphos.entity.impl.impl.PlayableCharacter;

public final class CommandContext {

    private final String content;
    private final PlayableCharacter author;

    public CommandContext(String content, PlayableCharacter author) {
        this.content = content;
        this.author = author;
    }

    public PlayableCharacter getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }
}
