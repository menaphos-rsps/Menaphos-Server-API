package org.menaphos.commands;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.ParseException;
import org.menaphos.commands.impl.admin.ItemCommandListener;
import org.menaphos.entity.impl.CharacterEntity;

import java.util.*;

public final class CommandDispatcher {

    private static CommandDispatcher instance = null;

    private final Map<List<String>, CommandListener> commandListenerMap;

    private final String[] CLIENT_COMMANDS = {"oldgameframe","oldgamefog","filteroff","musicauto","musicloopoff","nomusicselected"};

    public static CommandDispatcher getInstance() {
        if (instance == null)
            instance = new CommandDispatcher();
        return instance;
    }

    private CommandDispatcher() {
        this.commandListenerMap = new HashMap<>();
    }

    public void dispatch(CommandContext ctx) {
        CommandListener listener = null;
        if(!Arrays.asList(CLIENT_COMMANDS).contains(ctx.getContent())) {
            try {
                final List<String> keySet = commandListenerMap.keySet().stream()
                        .filter(set -> set.stream().anyMatch(key -> key.equalsIgnoreCase(ctx.getContent().split(" ")[0])))
                        .findFirst().get();
                if (commandListenerMap.containsKey(keySet)) {
                    listener = commandListenerMap.get(keySet);
                    CommandLineParser parser = new DefaultParser();
                    CommandLine cmd = parser.parse(listener.getOptions(), ctx.getContent().split(" "));
                    if (listener.canExecute(ctx))
                        listener.execute(cmd, ctx);
                }
            } catch (ParseException e) {
                this.sendMessage(ctx.getAuthor(), "Missing Arguments! " + listener.getOptions().getRequiredOptions());
            } catch (IndexOutOfBoundsException e) {
                this.sendMessage(ctx.getAuthor(), "Usage: " + listener.getOptions().getRequiredOptions());
            } catch (NumberFormatException e) {
                this.sendMessage(ctx.getAuthor(), "Please use only valid whole numbers.");
            } catch (NoSuchElementException e) {
                this.sendMessage(ctx.getAuthor(), "Command not found.");
            } catch (IllegalAccessException | NullPointerException e) {
                this.sendMessage(ctx.getAuthor(), e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
                this.sendMessage(ctx.getAuthor(), "Something went wrong.");
            }
        }
    }

    public void addCommand(CommandListener listener, String...alias) {
        commandListenerMap.put(Arrays.asList(alias), listener);
    }

    private void sendMessage(CharacterEntity player, String content) {
        player.receiveMessage(content);
    }

    public static void init() {
        getInstance().addCommand(new ItemCommandListener(),"spawn");
    }

}
