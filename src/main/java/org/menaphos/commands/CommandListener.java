package org.menaphos.commands;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.menaphos.entity.impl.impl.PlayableCharacter;

import java.util.ArrayList;
import java.util.List;

public abstract class CommandListener {

    private final Options options;
    private final List<Integer> permittedRanks;

    protected CommandListener() {
        this.options = new Options();
        this.permittedRanks = new ArrayList<>();
    }

    public boolean canExecute(CommandContext ctx) throws IllegalAccessException {
        final PlayableCharacter player = ctx.getAuthor();

        if (!permittedRanks.isEmpty() && !permittedRanks.contains(player.getRights())) {
            throw new IllegalAccessException("You do not have a sufficient rank to perform this command.");
        }
        return true;
    }

    public abstract void execute(CommandLine cmd, CommandContext ctx);

    protected void addOption(Option option) {
        options.addOption(option);
    }

    protected void addRank(int rights) {
        permittedRanks.add(rights);
    }

    public Options getOptions() {
        return options;
    }

    public List<Integer> getPermittedRanks() {
        return permittedRanks;
    }
}
