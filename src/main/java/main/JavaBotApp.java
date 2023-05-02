package main;

import io.github.cdimascio.dotenv.Dotenv;
import main.event.MessageEvent;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;

public class JavaBotApp {
    //config文件读取.env
    private final Dotenv config;
    //多线程的bot
    private final ShardManager shardManager;
    public JavaBotApp() throws LoginException {
        //加载.env 读取令牌
        config = Dotenv.configure().load();
        String token = config.get("TOKEN");

        //连接机器人，设置状态活动等信息
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.playing("FINAL FANTASY XIV"));
        builder.enableIntents(GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_PRESENCES, GatewayIntent.MESSAGE_CONTENT);
        shardManager = builder.build();

        //监听事件
        shardManager.addEventListener(new MessageEvent());
    }

    public ShardManager getShardManager() {
        return shardManager;
    }

    public Dotenv getConfig() {
        return config;
    }

    public static void main(String[] args) {
        try {
            JavaBotApp bot = new JavaBotApp();
        }catch (LoginException e){
            System.out.println("ERROR: Provide bot token is invalid!");
        }
    }
}
