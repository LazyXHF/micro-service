package cn.xu.netty.protocol.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import cn.xu.netty.protocol.Packet;

import static cn.xu.netty.protocol.command.Command.MESSAGE_REQUEST;

@Data
@NoArgsConstructor
public class MessageRequestPacket extends Packet {

    private String toUserId;
    private String message;

    public MessageRequestPacket(String toUserId,String message) {
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return MESSAGE_REQUEST;
    }
}
