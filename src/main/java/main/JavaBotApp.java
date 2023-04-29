package main;

import main.event.MessageEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class JavaBotApp {
    //bot token
    private static final String token = "MTEwMDA2ODA0NTIwMTg3NDk0NA.GkVbKE.YZnwYjMfZHLS7r6gwOuvmZWZ0Uy1N05t8YA8OM";

    public static void main(String[] args) throws Exception {
        //启动bot
        JDA jda = JDABuilder.createDefault(token).build().awaitReady();

        //添加对话事件
        jda.addEventListener(new MessageEvent());
    }
}
