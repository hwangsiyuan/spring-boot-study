package com.hussein.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>Title: UserController</p>
 * <p>Description: </p>
 * <p>Company: www.fenbeitong.com</p>
 *
 * @author hwangsy
 * @date 2019/8/29 10:04 AM
 */
@Controller
public class UserController extends BaseController {

    @GetMapping("/login")
    public String login(@RequestParam("userName") String userName) {
        if (userName == null) {
            throw new RuntimeException("用户名错误");
        }
        return "success";
    }
}
