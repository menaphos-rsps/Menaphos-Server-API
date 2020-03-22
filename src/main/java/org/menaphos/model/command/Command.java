package org.menaphos.model.command;

import java.util.ArrayList;
import java.util.List;

public final class Command {

    private final List<CommandOption> options;
    private final List<String> aliases;
    private final List<Integer> permittedRanks;
    private final String identifier;

    public Command(String identifier) {
        this.identifier = identifier;
        this.permittedRanks = new ArrayList<>();
        this.options = new ArrayList<>();
        this.aliases = new ArrayList<>();
    }

    public List<Integer> getPermittedRanks() {
        return permittedRanks;
    }

    public String getIdentifier() {
        return identifier;
    }

    public List<CommandOption> getOptions() {
        return options;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public static final class CommandOption {

        private final String identifier;
        private final String input;
        private final boolean optional;
        private final boolean hasArgs;
        private final String description;

        public CommandOption(String identifier, String input, boolean optional, boolean hasArgs, String description) {
            this.identifier= identifier;
            this.input = input;
            this.optional = optional;
            this.hasArgs = hasArgs;
            this.description = description;
        }

        public String getIdentifier() {
            return identifier;
        }

        public String getDescription() {
            return description;
        }

        public boolean hasArgs() {
            return hasArgs;
        }

        public boolean isOptional() {
            return optional;
        }

        public String getInput() {
            return input;
        }
    }
}
