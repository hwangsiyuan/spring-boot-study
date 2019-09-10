package com.hussein.controller;

import com.hussein.domain.User;
import com.hussein.service.UserModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

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

    @Autowired
    private UserModuleService userModuleService;

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/main")
    public String main(HttpSession httpSession, Model model) {
        User user = (User) httpSession.getAttribute("user_session");
        model.addAttribute("userPopedomModules", userModuleService.getUserPopedomModules(user.getUserId()));
        return "/main";
    }

    @GetMapping("/home")
    public String home() {
        return "/home";
    }
}
