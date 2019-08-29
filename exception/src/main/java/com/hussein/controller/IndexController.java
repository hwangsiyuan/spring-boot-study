package com.hussein.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>Title: IndexController</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/8/29 9:49 AM
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/hello")
    public String hello() throws Exception {
        throw new Exception();
    }

    @GetMapping("/test")
    public String test() {
        int i = 5 / 0;
        return "success";
    }

    @ExceptionHandler(Exception.class)
    public String testExceptionHandler(Exception e) {
        e.printStackTrace();
        return "服务器异常，请稍后重试";
    }
}
