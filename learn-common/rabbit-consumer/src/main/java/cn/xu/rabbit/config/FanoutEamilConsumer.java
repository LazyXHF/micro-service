package cn.xu.rabbit.config;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author ~许小桀
 * @date 2019/11/18 16:29
 * 邮件消费者
 */
@Component
@RabbitListener(queues = "fanout_eamil_queue")
public class FanoutEamilConsumer {

    @RabbitHandler
    public void process(String msg) throws Exception {
        System.out.println("邮件消费者获取生产者消息msg:" + msg);
    }

}
