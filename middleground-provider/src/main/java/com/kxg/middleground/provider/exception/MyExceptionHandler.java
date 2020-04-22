package com.kxg.middleground.provider.exception;

import com.kxg.middleground.provider.common.SzpJsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: szp
 * @Date: 2020/4/22 17:59
 * @Description: 全局异常处理
 */
@ControllerAdvice
public class MyExceptionHandler {
    /**
     * 处理自定义的业务异常
     * @param
     * @param e
     * @return
     */
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public  SzpJsonResult<?> bizExceptionHandler(BizException e){
        return SzpJsonResult.errorMsg(e.getErrorMsg());
    }

    /**
     * 处理空指针的异常
     * @param
     * @param e
     * @return
     */
    @ExceptionHandler(value =NullPointerException.class)
    @ResponseBody
    public SzpJsonResult<?> exceptionHandler( NullPointerException e){
        return SzpJsonResult.errorMsg(e.getMessage());
    }


    /**
     * 处理其他异常
     * @param
     * @param e
     * @return
     */
    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public SzpJsonResult<?> exceptionHandler( Exception e){
        return SzpJsonResult.errorMsg(e.getMessage());
    }
}
