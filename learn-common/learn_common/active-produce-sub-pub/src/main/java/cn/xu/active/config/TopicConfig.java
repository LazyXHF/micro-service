package cn.xu.active.config;

import org.apache.activemq.broker.region.Topic;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author ~许小桀
 * @date 2019/11/8 18:57
 */
@Component
public class TopicConfig {
    @Value("${topic}")
    private String topicName;
    @Bean
    public ActiveMQTopic topic() {
        return new ActiveMQTopic(topicName);
    }
}
