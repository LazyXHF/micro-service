package cn.portjs.redis.service;


import cn.portjs.redis.utils.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author ~许小桀
 * @date 2019/10/17 15:40
 */
@Service
public class UserService  {

    @Autowired
    private RedisUtil redisUtil;

    HashMap hashMap  = new HashMap();
    //添加
    public void setMsgToRedis(String s) {
        //普通写入
       redisUtil.set("test1",s);
       //带有过期时间写入
       redisUtil.set("test2",s,1000);
        //普通hash写入
//       hashMap.put("key",123);
       redisUtil.hset("test3","item",s);
        //带有过期时间hash写入
        redisUtil.hset("test4","item",s,1000);
        //普通shet写入
        Set set = new HashSet();
        set.add(s);
        redisUtil.sSet("test10","item",set);
        //带有过期时间shet写入
        redisUtil.sSet("test11","item",set,1000);
        //带有sList写入
        ArrayList arrayList = new ArrayList();
        arrayList.add(s);
        redisUtil.lSet("test7",arrayList);
        //带有过期时间sList写入
        redisUtil.lSet("test8",arrayList,1000);

        //................... 具体使用请查看RedisUtil  工具类  亲测有效


    }



    //获取
    public void getRedisMsgToRedis(String key,Object ...key2){
        Object o = redisUtil.get("test1");

        System.out.println(o);
        //hash获取
        Object hget = redisUtil.hget("test3", "item");
        System.out.println(hget);
        //Set获取
        Set<Object> test5 = redisUtil.sGet("test10");
        System.out.println("test10"+test5);

//        start 开始
//        end 结束 0 到 -1代表所有值
        List<Object> objectList = redisUtil.lGet("test7", 0, -1);
        System.out.println(objectList);

        //................... 具体使用请查看RedisUtil  工具类  亲测有效

    }

    //删除
    public void deleteMsgToRedis(String key,Object... key2){
        //普通删除
        redisUtil.del(key);
        //hash删除
        redisUtil.hdel(key,key2);

        //................... 具体使用请查看RedisUtil  工具类  亲测有效

    }
}


