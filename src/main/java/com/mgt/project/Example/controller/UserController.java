package com.mgt.project.Example.controller;

import com.mgt.common.aop.LogInfo;
import com.mgt.project.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: mgt-contrl-platform
 * @description: 测试
 * @author: Mr.Gu
 * @create: 2019-02-27 17:26
 **/
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @LogInfo(methodName = "页面使用用例")
    @GetMapping("/example")
    public String  getUsers() {
        return "user";
    }
}

