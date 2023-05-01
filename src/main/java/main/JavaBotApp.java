package main;

import main.event.MessageEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;

public class JavaBotApp {
    private final ShardManager shardManager;
    public JavaBotApp() throws LoginException {
        String token = "MTEwMDA2ODA0NTIwMTg3NDk0NA.GBWzDz.K4zQHhltSAl3UfPHc3DmmQxfXPnCBTvB91Ys9c";
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.playing("FINAL FANTASY XIV"));
        shardManager = builder.build();
    }

    public ShardManager getShardManager() {
        return shardManager;
    }

    public static void main(String[] args) {
        try {
            JavaBotApp bot = new JavaBotApp();
        }catch (LoginException e){
            System.out.println("ERROR: Provide bot token is invalid!");
        }
    }

//    private static final String token = "MTEwMDA2ODA0NTIwMTg3NDk0NA.GBWzDz.K4zQHhltSAl3UfPHc3DmmQxfXPnCBTvB91Ys9c";
//
//    public static void main(String[] args) throws Exception {
//        //启动bot
//        JDA jda = JDABuilder.createDefault(token).build().awaitReady();
//
//
//        //添加对话事件
//        jda.addEventListener(new MessageEvent());
//    }
}
