package org.menaphos.commands.impl.admin;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.menaphos.commands.CommandContext;
import org.menaphos.commands.impl.AdministratorCommandListener;
import org.menaphos.entity.impl.impl.PlayableCharacter;

public class AdjustPlayerRights extends AdministratorCommandListener {

    PlayableCharacter player;
    public AdjustPlayerRights() {
        this.addOption(Option.builder("player")
                .argName("player")
                .optionalArg(false)
                .longOpt("player")
                .hasArg()
                .required()
                .desc("The username of the player who's rights you want to adjust.")
                .build());
        this.addOption(Option.builder("amount")
                .argName("amount")
                .optionalArg(false)
                .longOpt("Amount you want to increase the players rights by.")
                .hasArg()
                .build());
    }

    @Override
    public void execute(CommandLine cmd, CommandContext ctx) {
        final int amount = Integer.parseInt(cmd.getOptionValue("amount"));
        int rights = player.getRights();
        if (player != null) {
            increaseRights(player, amount, rights);
        }

    }

    private void increaseRights(PlayableCharacter player, int amount, int rights) {
        rights = rights + amount;
    }
}
