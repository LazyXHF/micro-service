package cn.xu.rabbit.controller;

import cn.xu.rabbit.config.FanoutProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ~许小桀
 * @date 2019/11/18 16:26
 */
@RestController
public class ProduceController {


    @Autowired
    private FanoutProducer fanoutProducer;

    @RequestMapping("/sendFanout")
    public String sendFanout(String queueName) {
        fanoutProducer.send(queueName);
        return "success";
    }

}
