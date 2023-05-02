package main.event;

import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.EnumSet;
import java.util.List;

public class MessageEvent extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event){
        //如果是机器人发送消息则忽略事件
        if(event.getAuthor().isBot()){
            return;
        }

        Message message = event.getMessage();
        System.out.println(message.getContentDisplay());

        //获取服务器信息
        Guild guild = message.getGuild();
        String guildId = guild.getId();
        String guildName = guild.getName();
        System.out.println("Guild ID = " + guildId); //输出服务器id
        System.out.println("Guild Name = " + guildName); //输出服务器名字

        //获取频道信息
        MessageChannel messageChannel = message.getChannel();
        String channelId = messageChannel.getId(); //获取频道id
        String channelName = messageChannel.getName(); //获取频道名字
        System.out.println("Channel ID = " + channelId);
        System.out.println("Channel Name = " + channelName);

        //获取发消息人+一系列属性
        Member member = message.getMember();
        assert member != null;
        String memberNickname = member.getNickname();//获取昵称
        String memberId = member.getId(); //获取id
        String memberEffectiveName = member.getEffectiveName(); //获取有效名称
        List<Role> memberRoles = member.getRoles(); //获取角色列表
        EnumSet<Permission> memberPermissions = member.getPermissions(); //获取权限
        OnlineStatus memberOnlineStatus = member.getOnlineStatus(); //获取在线状态
        System.out.println("Member Id = " + memberId);
        System.out.println("Member Nickname = " + memberNickname);
        System.out.println("Member Effective Name = " + memberEffectiveName);
        System.out.println("Member Permissions = " + memberPermissions);
        System.out.println("Member Oneline Status = " + memberOnlineStatus);
        System.out.println("Member Role = " + memberRoles);

        //获取消息信息
        String messageId = message.getId();
        String messageContentRaw = message.getContentRaw();
        MessageType messageType = message.getType();
        System.out.println("Message Id = " + messageId);
        System.out.println("messageContentRaw = " + messageContentRaw);
        System.out.println("messageType = " + messageType);

        //回复消息
        messageChannel.sendMessage(memberNickname + " said " + messageContentRaw).queue();

    }
}
