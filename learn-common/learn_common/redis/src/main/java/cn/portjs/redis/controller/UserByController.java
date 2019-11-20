package cn.portjs.redis.controller;

import cn.portjs.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author ~许小桀
 * @date 2019/10/17 15:46
 */
@RestController
public class UserByController {
    @Autowired
    private UserService userService;

    @RequestMapping("/add")
    public void addByRedis(String key,String value,Long timeout){
       userService.setMsgToRedis(key);
//
    }


    @RequestMapping("/get")
    public void getByRedis(String key){

         userService.getRedisMsgToRedis(key,key);
//        return userService.getUserById(key);
//
    }


    @RequestMapping("/delete")
    public void deleteByRedis(String key){
        userService.deleteMsgToRedis(key);
//
    }





}
