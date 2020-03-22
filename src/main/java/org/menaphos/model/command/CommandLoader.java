package org.menaphos.model.command;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.menaphos.io.fs.repository.CommandRepositoryManager;
import org.phantasye.RepositoryManager;

import java.util.Collection;
import java.util.List;

public final class CommandLoader {

    public static Options getOptionsForCommand(String identifier) {
        final RepositoryManager<Command, CommandRepository> rm = new CommandRepositoryManager();
        final Collection<Command> commandMap = rm.getRepository().readAll();
        final Options options = new Options();

        commandMap
                .stream()
                .filter(command -> command.getIdentifier().equalsIgnoreCase(identifier))
                .forEach(cmd-> cmd.getOptions()
                        .forEach(commandOption ->
                                options.addOption(Option.builder(commandOption.getIdentifier())
                                        .argName(commandOption.getInput())
                                        .desc(commandOption.getDescription())
                                        .hasArg(commandOption.hasArgs())
                                        .optionalArg(commandOption.isOptional())
                                        .build())));
        return options;
    }

    public static List<Integer> getRolesForCommand(String identifier) {
        return null;
    }

}
