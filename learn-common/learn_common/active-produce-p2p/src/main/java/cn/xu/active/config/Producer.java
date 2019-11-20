package cn.xu.active.config;

import org.apache.activemq.broker.region.Queue;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author ~许小桀
 * @date 2019/11/8 18:37
 */
@Component
@EnableScheduling
public class Producer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private ActiveMQQueue queue;

    @Scheduled(fixedDelay = 5000)
    public void send() {
        Long msg = System.currentTimeMillis();
        System.out.println("采用P2P方式,生产者向消费者发送内容:" + msg);

        jmsMessagingTemplate.convertAndSend(queue, "测试消息队列" + msg);
    }


}
