package org.menaphos.commands.impl.admin;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.menaphos.action.impl.item.container.impl.AddItemToInventoryAction;
import org.menaphos.commands.CommandContext;
import org.menaphos.commands.impl.AdministratorCommandListener;
import org.menaphos.entity.impl.impl.PlayableCharacter;

public class ItemCommandListener extends AdministratorCommandListener {

    public ItemCommandListener() {
        this.addOption(Option.builder("id")
                .argName("id")
                .optionalArg(false)
                .longOpt("id")
                .hasArg()
                .required()
                .desc("The Item's ID #")
                .build());
        this.addOption(Option.builder("amt")
                .argName("amt")
                .optionalArg(true)
                .longOpt("amount")
                .hasArg()
                .build());
    }

    @Override
    public void execute(CommandLine cmd, CommandContext ctx) {
        final int itemId = Integer.parseInt(cmd.getOptionValue("id"));

        if (cmd.hasOption("amount")) {
            final int amount = Integer.parseInt(cmd.getOptionValue("amount"));
            this.addItem(itemId, amount, ctx.getAuthor());
        } else {
            this.addItem(itemId, 1, ctx.getAuthor());
        }
    }

    private void addItem(int id, int amount, PlayableCharacter player) {
        player.getActionInvoker().perform(new AddItemToInventoryAction(player,id,amount));
    }
}
