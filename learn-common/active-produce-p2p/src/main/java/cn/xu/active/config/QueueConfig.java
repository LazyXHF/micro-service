package cn.xu.active.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author ~许小桀
 * @date 2019/11/8 18:35
 */
@Component

public class QueueConfig {
    @Value("${queue}")
    private String queue;

    @Bean
    public ActiveMQQueue logQueue() {
        return new ActiveMQQueue(queue);
    }

}
