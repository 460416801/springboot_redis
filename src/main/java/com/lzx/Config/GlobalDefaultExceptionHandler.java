package com.lzx.Config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Ronin on 2018/2/5.
 *
 *设置全局异常
 *使用自定义APIResult来返回json数据到页面。
 *
 */
@RestController
@ControllerAdvice
public class GlobalDefaultExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public APIResult defaultExceptionHandler(HttpServletRequest req, Exception e) {
        APIResult r = new APIResult();
        r.setMessage(e.getMessage());
        r.setCode(ResultCode.ERROR);
        r.setData("活捉错误一枚！");
        return r;
    }


}
