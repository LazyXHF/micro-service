package cn.xu.netty.util;

import cn.xu.netty.attribute.Attributes;
import cn.xu.netty.session.Session;
import io.netty.channel.Channel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SessionUtil {
    private static final Map<String, Channel> userIdChannelMap = new ConcurrentHashMap<>();

    //建立session与channel的映射关系
    public static void bindSession(Session session, Channel channel) {
        userIdChannelMap.put(session.getUserId(), channel);
        channel.attr(Attributes.SESSION).set(session);
    }

    //删除session和channel的映射关系
    public static void unBindSession(Channel channel) {
        if (hasLogin(channel)) {
            userIdChannelMap.remove(getSession(channel).getUserId());
            channel.attr(Attributes.SESSION).set(null);
        }
    }

    //通过会话判断是否登录
    public static boolean hasLogin(Channel channel) {

        return channel.hasAttr(Attributes.SESSION);
    }

    //通过channel得到对应的Session
    public static Session getSession(Channel channel) {

        return channel.attr(Attributes.SESSION).get();
    }

    //通过session得到对应的Channel
    public static Channel getChannel(String userId) {

        return userIdChannelMap.get(userId);
    }
}
