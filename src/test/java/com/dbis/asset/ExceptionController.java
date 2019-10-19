package com.dbis.asset;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @ClassName ExceptionController
 * @Description TODO测试异常的controller
 * @Author tom
 * @Date 2019/10/19 18:26
 * @Version 1.0
 **/


@RestController
public class ExceptionController {

    @RequestMapping("/exce")
    public String showInfo(){
        System.err.println("dddddddddddddd");
        String info ="你好";
        int a = 1/0;
        return info;
    }
}
