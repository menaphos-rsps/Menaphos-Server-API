package org.menaphos.commands.impl.player;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.menaphos.commands.CommandContext;
import org.menaphos.commands.impl.PlayerCommandListener;

import java.time.LocalDate;

public class DummyCommandListener extends PlayerCommandListener {

    public DummyCommandListener() {
        this.addOption(Option.builder("day")
                .argName("d")
                .optionalArg(false)
                .longOpt("day")
                .hasArg()
                .required()
                .desc("The Day")
                .build());
        this.addOption(Option.builder("month")
                .argName("m")
                .optionalArg(false)
                .longOpt("month")
                .hasArg()
                .required()
                .desc("The Month")
                .build());
        this.addOption(Option.builder("year")
                .argName("y")
                .optionalArg(true)
                .longOpt("year")
                .hasArg()
                .build());
    }


    @Override
    public void execute(CommandLine cmd, CommandContext ctx) {
        final String day = cmd.getOptionValue("day");
        final String month = cmd.getOptionValue("month");

        if (cmd.hasOption("year")) {
            System.out.println(month + "/" + day + "/" + cmd.getOptionValue("year"));
        } else {
            System.out.println(month + "/" + day + "/" + LocalDate.now().getYear());
        }
    }
}
