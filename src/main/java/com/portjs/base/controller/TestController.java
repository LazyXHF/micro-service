package com.portjs.base.controller;

import com.portjs.base.aop.LogInfo;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TestController {


    ResponseMessage responseMessage = null;
    @RequestMapping("/login_p")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @LogInfo(methodName = "登录日志")
    public ResponseMessage login() {
        responseMessage = new ResponseMessage(Code.CODE_ERROR,"尚未登录，请登录!");
        return responseMessage;
    }




//    @Autowired
//    private TXietongUserMapper userMapper;

//    @RequestMapping("test")
//    public String getUserById(String id){
//        TXietongUser user = userMapper.selectByPrimaryKey("1");
//        return "test";
//    }




    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        System.out.println( bCryptPasswordEncoder.encode("123"));
    }
}
