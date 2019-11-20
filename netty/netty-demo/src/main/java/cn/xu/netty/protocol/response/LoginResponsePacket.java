package cn.xu.netty.protocol.response;

import lombok.Data;
import cn.xu.netty.protocol.Packet;

import static cn.xu.netty.protocol.command.Command.LOGIN_RESPONSE;

@Data
public class LoginResponsePacket extends Packet {
    private String userId;

    private String userName;

    private boolean success;

    private String reason;



    @Override
    public Byte getCommand() {
        return LOGIN_RESPONSE;
    }
}
