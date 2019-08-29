package com.hussein.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>Title: GlobalExceptionHandler</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/8/29 10:08 AM
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object globalExceptionHandler(HttpServletRequest request, Exception e) {
        Map<String, Object> res = new LinkedHashMap<>();
        res.put("code", 1);
        res.put("msg", e.getMessage());
        res.put("url", request.getRequestURL());
        res.put("data", "请求失败");
        return res;
    }
}
