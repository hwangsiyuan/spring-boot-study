package com.hussein.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>Title: LoginController</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/8/27 4:15 PM
 */
@Controller
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestParam("loginName") String loginName, @RequestParam("password") String password) {
        System.out.printf("[%s]:[%s]\n", loginName, password);
        return "redirect:/main";
    }
}
