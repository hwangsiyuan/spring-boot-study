package com.hussein.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>Title: RequestController</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/7 7:39 PM
 */
@Controller
public class RequestController {

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/main")
    public String main() {
        return "/main";
    }

    @GetMapping("/home")
    public String home() {
        return "/home";
    }
}
