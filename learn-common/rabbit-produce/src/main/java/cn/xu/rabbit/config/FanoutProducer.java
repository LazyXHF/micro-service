package cn.xu.rabbit.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author ~许小桀
 * @date 2019/11/18 16:25
 * 生产者投递消息
 */
@Component
public class FanoutProducer {
    @Autowired
    private AmqpTemplate amqpTemplate;

//    说明生产者将消息发送至转发器，转发器决定将消息发送至哪些队列，消费者绑定队列获取消息。
    public void send(String queueName) {
        String msg = "my_fanout_msg:" + new Date();
        System.out.println(msg + ":" + msg);
        amqpTemplate.convertAndSend(queueName, msg);
    }
}

