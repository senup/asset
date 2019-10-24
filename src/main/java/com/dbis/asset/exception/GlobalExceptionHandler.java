package com.dbis.asset.exception;

import com.dbis.asset.result.ResultBody;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


/**
 * 
* @Title: GlobalExceptionHandler
* @Description: 全局异常处理
如果使用@RestControllerAdvice 注解
则会将返回的数据类型转换成JSON格式
 * @Author tom
 * @Date 2019/10/23 14:26
 * @Version 1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	/**
	 * 处理自定义的业务异常
	 * @param req
	 * @param e
	 * @return
	 */
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
	public ResultBody bizExceptionHandler(HttpServletRequest req, BizException e){
    	logger.error("发生业务异常！原因是：{}",e.getErrorMsg());
    	return ResultBody.error(e.getErrorCode(),e.getErrorMsg());
    }


    /**
	 * 处理其他异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =Exception.class)
	@ResponseBody
	public ResultBody exceptionHandler(HttpServletRequest req, Exception e){
    	logger.error("未知异常！原因是:",e);
       	return ResultBody.error("未知异常！原因是:"+e.getMessage());
    }



}
