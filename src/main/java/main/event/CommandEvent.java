package main.event;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.middleman.AudioChannel;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.managers.AudioManager;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CommandEvent extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        String command = event.getName();
        if(command.equals("hello")){
            String userTag = event.getUser().getAsTag();
            event.reply("Welcome to server **" + userTag + "**").queue();
        }else if(command.equals("join")){
            Guild guild = event.getGuild();
            Member member = event.getMember();
            AudioChannel audioChannel = member.getVoiceState().getChannel();
            AudioManager audioManager = guild.getAudioManager();
            audioManager.openAudioConnection(audioChannel);
            event.reply("Join in the channel " + audioChannel.getName()).queue();
        }
    }

    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event) {
        List<CommandData> commandData = new ArrayList<>();
        commandData.add(Commands.slash("hello", "Get welcomed by the bot"));
        commandData.add(Commands.slash("join", "Join the bot into channel"));
        event.getGuild().updateCommands().addCommands(commandData).queue();
    }
}
