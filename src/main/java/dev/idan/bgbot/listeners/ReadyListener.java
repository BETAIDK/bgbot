package dev.idan.bgbot.listeners;

import dev.idan.bgbot.repository.TokenRepository;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.DefaultMemberPermissions;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReadyListener extends ListenerAdapter {

    private boolean run = false;

    @Autowired
    TokenRepository tokenRepository;

    public void onReady(ReadyEvent event) {
        if (run) return;
        run = true;

        CommandData init = (Commands.slash(
                "init", "configure the Gitlab monitor as you wish")
                .addOption(OptionType.CHANNEL, "channel", "The channel that you want to get updates on", true)
                .setDefaultPermissions(DefaultMemberPermissions.enabledFor(Permission.ADMINISTRATOR))
        );
        CommandData remove = (Commands.slash(
                "remove", "disconnects channel from the Gitlab monitor")
                .addOption(OptionType.CHANNEL, "channel", "The channel that you want to disconnect from the Gitlab monitor", true)
                .setDefaultPermissions(DefaultMemberPermissions.enabledFor(Permission.ADMINISTRATOR))
        );
        CommandData tokens = (Commands.slash(
                "tokens", "get all the tokens that are connected to the Gitlab monitor")
                .setDefaultPermissions(DefaultMemberPermissions.enabledFor(Permission.ADMINISTRATOR))
        );
        CommandData help = (Commands.slash(
                "help", "Gitlab monitor documentation")
                .setDefaultPermissions(DefaultMemberPermissions.enabledFor(Permission.ADMINISTRATOR))
        );

        event.getJDA().upsertCommand(remove).queue();
        event.getJDA().upsertCommand(init).queue();
        event.getJDA().upsertCommand(tokens).queue();
        event.getJDA().upsertCommand(help).queue();
    }
}
