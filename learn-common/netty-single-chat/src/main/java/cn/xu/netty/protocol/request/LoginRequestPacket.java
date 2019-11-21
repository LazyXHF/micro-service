package cn.xu.netty.protocol.request;

import lombok.Data;
import cn.xu.netty.protocol.Packet;

import static cn.xu.netty.protocol.command.Command.LOGIN_REQUEST;

@Data
public class LoginRequestPacket extends Packet {
    private String userId;

    private String username;

    private String password;

    @Override
    public Byte getCommand() {

        return LOGIN_REQUEST;
    }
}
