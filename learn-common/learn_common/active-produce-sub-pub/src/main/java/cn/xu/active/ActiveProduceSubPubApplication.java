package cn.xu.active;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ActiveProduceSubPubApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActiveProduceSubPubApplication.class, args);
    }

}
