package cn.xu.rabbit.config;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author ~许小桀
 * @date 2019/11/18 16:29
 * 短信消费者
 */
@Component
@RabbitListener(queues = "fanout_sms_queue")
public class FanoutSmsConsumer {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("短信消费者获取生产者消息msg:" + msg);
    }

}
