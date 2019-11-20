package cn.xu.active.config;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author ~许小桀
 * @date 2019/11/18 11:15
 */
@Component
public class Consumer {
    @JmsListener(destination = "${queue}")
    public void receive(String msg) {
        System.out.println("监听器收到msg:" + msg);
    }
}
