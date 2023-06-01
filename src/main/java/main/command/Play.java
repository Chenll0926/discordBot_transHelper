package main.command;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;

import java.io.IOException;

public class Play extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();
        String[] commands = message.split("", 2);

        if (commands[0].startsWith("!")){
            String commandName = commands[0].substring(1);
            if (commandName.equalsIgnoreCase("play")){

            }
        }
    }

    public void play() throws Exception {

    }
}
