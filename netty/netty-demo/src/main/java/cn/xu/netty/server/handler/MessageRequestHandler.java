package cn.xu.netty.server.handler;

import cn.xu.netty.session.Session;
import cn.xu.netty.util.SessionUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import cn.xu.netty.protocol.request.MessageRequestPacket;
import cn.xu.netty.protocol.response.MessageResponsePacket;


public class MessageRequestHandler extends SimpleChannelInboundHandler<MessageRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageRequestPacket messageRequestPacket) {
        //1.拿到消息发送发的消息
        Session session = SessionUtil.getSession(ctx.channel());
        //2.通过消息发送发的会话信息构造呀发送的信息
        MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
        messageResponsePacket.setFormUserId(session.getUserId());
        messageResponsePacket.setFromUserName(session.getUserName());
        messageResponsePacket.setMessage(messageRequestPacket.getMessage());

        //3.拿到消息接收方的channel
        Channel toUserChannel = SessionUtil.getChannel(messageRequestPacket.getToUserId());

        //4.将信息发送给消息接收方
        if (toUserChannel !=null && SessionUtil.hasLogin(toUserChannel)){
            toUserChannel.writeAndFlush(messageResponsePacket);
        }else {
            System.out.println(messageRequestPacket.getToUserId()+"不在线,发送失败!!!!!");
        }
//        System.out.println(new Date() + ": 收到客户端消息: " + messageRequestPacket.getMessage());
//        messageResponsePacket.setMessage("服务端回复【" + messageRequestPacket.getMessage() + "】");

        ctx.channel().writeAndFlush(messageResponsePacket);
    }
}
