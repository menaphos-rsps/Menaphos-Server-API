package org.menaphos.model.command;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.ParseException;

import java.util.*;

public final class CommandDispatcher {

    private static CommandDispatcher instance = null;

    private final Map<List<String>, CommandListener> commandListenerMap;

    public static CommandDispatcher getInstance() {
        if (instance == null)
            instance = new CommandDispatcher();
        return instance;
    }

    private CommandDispatcher() {
        this.commandListenerMap = new HashMap<>();
    }

    public boolean dispatch(CommandContext ctx) {
        CommandListener listener = null;
        try {
            final List<String> keySet = commandListenerMap.keySet().stream()
                    .filter(set -> set.stream().anyMatch(key -> key.equalsIgnoreCase(ctx.getContent().split(" ")[0])))
                    .findFirst().get();
            if (commandListenerMap.containsKey(keySet)) {
                listener = commandListenerMap.get(keySet);
                CommandLineParser parser = new DefaultParser();
                CommandLine cmd = parser.parse(listener.getOptions(), ctx.getContent().split(" "));
                if (listener.canExecute(ctx)) {
                    listener.execute(cmd, ctx);
                    return true;
                }
            }
        } catch (ParseException e) {
            ctx.getAuthor().send("Missing Arguments! " + Objects.requireNonNull(listener).getOptions().getRequiredOptions());
        } catch (IndexOutOfBoundsException e) {
            ctx.getAuthor().send("Usage: " + Objects.requireNonNull(listener).getOptions().getRequiredOptions());
        } catch (NumberFormatException e) {
            ctx.getAuthor().send("Please use only valid whole numbers.");
        } catch (NoSuchElementException e) {
            ctx.getAuthor().send("Command not found.");
        } catch (IllegalAccessException | NullPointerException e) {
            ctx.getAuthor().send(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            ctx.getAuthor().send("Something went wrong.");
        }
        return false;
    }

    public void addCommand(CommandListener listener, String...alias) {
        commandListenerMap.put(Arrays.asList(alias), listener);
    }

    public static void init() {

    }

}
