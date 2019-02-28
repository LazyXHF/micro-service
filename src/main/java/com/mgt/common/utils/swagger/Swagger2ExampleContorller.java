package com.mgt.common.utils.swagger;

import com.mgt.common.aop.LogInfo;
import com.mgt.common.bean.BaseEntity;
import com.mgt.common.utils.Code;
import com.mgt.common.utils.ResponseMessage;
import com.mgt.project.BaseController;
import io.swagger.annotations.*;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: mgt-contrl-platform
 * @description: swagger2用例
 * @author: Mr.Gu
 * @create: 2019-02-28 10:23
 **/
@Api(value="案例Swagger2ExampleContorller",tags={"Swagger2用例"})
@Controller
@RequestMapping("/swagger2")
public class Swagger2ExampleContorller extends BaseController {


    @LogInfo(methodName = "Swagger2用例")
    @ApiOperation(value="获取用例信息",tags={"获取用例信息copy"},notes="注意问题点")
    @GetMapping("/example")
    @ResponseBody
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access_token", value = "请求token", required = true, paramType = "header", dataType = "String"),
    })
    public ResponseMessage getUserInfo(String request) {
        try{
            Example  e = new Example();
            e.setId(123123);
            e.setName("example");
            return new ResponseMessage(Code.CODE_OK ,"success",e.toString());
        }catch(Exception e){
            return new ResponseMessage(Code.CODE_ERROR ,"error","未知异常");
        }
    }
}





@Data
@ApiModel(value="example对象",description="用例")
class Example extends BaseEntity{
    @ApiModelProperty(value="id",name="id",example="123123",required=true)
    private Integer id;

    @ApiModelProperty(value="姓名",name="name",example="example",required=true)
    private String name;
}
