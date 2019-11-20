package cn.xu.active.config;

import org.apache.activemq.broker.region.Topic;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author ~许小桀
 * @date 2019/11/8 18:56
 */
@Component
public class TopicProducer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private ActiveMQTopic topic;

    @Scheduled(fixedDelay = 5000)
    public void send() {
        String msg = System.currentTimeMillis() + "";
        System.out.println("采用发布订阅方式,生产者向消费者发送内容:" + msg);
        jmsMessagingTemplate.convertAndSend(topic, msg);
    }
}

