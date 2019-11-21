package cn.xu.netty.protocol.response;

import lombok.Data;
import cn.xu.netty.protocol.Packet;

import static cn.xu.netty.protocol.command.Command.MESSAGE_RESPONSE;

@Data
public class MessageResponsePacket extends Packet {

    private String message;
    private String formUserId;
    private String FromUserName;

    @Override
    public Byte getCommand() {

        return MESSAGE_RESPONSE;
    }
}
