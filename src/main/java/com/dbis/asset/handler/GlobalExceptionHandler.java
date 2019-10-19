package com.dbis.asset.handler;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName GlobalExceptionHandler
 * @Description 全局异常拦截器
 * @Author tom
 * @Date 2019/10/19 18:24
 * @Version 1.0
 **/

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Map<String, Object> exceptionHandler(Exception e) throws Exception {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("status" , 0);
        modelMap.put("errMsg", e.getMessage());
        return modelMap;
    }

}
