package com.dms.data.consume.commons.exception;

import com.alibaba.fastjson.JSONObject;
import com.dms.data.consume.commons.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 异常处理器
 */
@RestControllerAdvice
public class BusinessExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {

    }

    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     * @param model
     */
    @ModelAttribute
    public void addAttributes(Model model) {
    }

    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e,HttpServletRequest req){
        logger.error("异常:",e);
        Result result = null;
        //业务异常
        if(e instanceof BusinessException){
            Integer code=((BusinessException) e).getCode();
            String  msg=((BusinessException) e).getMsg();
              result = Result.error(code,msg);
        }else{//系统异常
            result = Result.error();
        }
        logger.info("异常返回结果:{}",JSONObject.toJSONString(result));

        return result;
    }

}
