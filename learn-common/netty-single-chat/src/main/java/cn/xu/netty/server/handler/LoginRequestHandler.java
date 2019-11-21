package cn.xu.netty.server.handler;

import cn.xu.netty.session.Session;
import cn.xu.netty.util.SessionUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import cn.xu.netty.protocol.request.LoginRequestPacket;
import cn.xu.netty.protocol.response.LoginResponsePacket;

import java.util.Date;
import java.util.UUID;

public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket loginRequestPacket) {
        System.out.println(new Date() + ": 收到客户端登录请求……");

        LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
        loginResponsePacket.setVersion(loginRequestPacket.getVersion());
        loginResponsePacket.setUserName(loginRequestPacket.getUsername());

        if (valid(loginRequestPacket)) {
            loginResponsePacket.setSuccess(true);
            String userId = randomUserId();
            loginResponsePacket.setUserId(userId);
            System.out.println("[" + loginRequestPacket.getUsername() + "]登录成功");
            //保存session和channel的关系
            SessionUtil.bindSession(new Session(userId, loginRequestPacket.getUsername()), ctx.channel());
//            LoginUtil.hasLogin(ctx.channel());
            System.out.println(new Date() + ": 登录成功!");
        } else {
            loginResponsePacket.setReason("账号密码校验失败");
            loginResponsePacket.setSuccess(false);
            System.out.println(new Date() + ": 登录失败!");
        }

        // 登录响应
        ctx.channel().writeAndFlush(loginResponsePacket);
    }

    //登录校验
    private boolean valid(LoginRequestPacket loginRequestPacket) {
        return true;
    }


    private static String randomUserId() {
        return UUID.randomUUID().toString().split("-")[0];
    }


    //用户断开连接后取消channel
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
//        super.channelInactive(ctx);
        SessionUtil.unBindSession(ctx.channel());
        System.out.println(SessionUtil.getSession(ctx.channel()).getUserName()+"已下线");
    }
}

