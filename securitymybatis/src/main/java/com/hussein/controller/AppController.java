package com.hussein.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.stream.Collectors;

/**
 * <p>Title: AppController</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/6 2:53 PM
 */
@Controller
public class AppController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("user", getUserName());
        model.addAttribute("role", getAuthority());
        return "home";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("user", getUserName());
        model.addAttribute("role", getAuthority());
        return "admin";
    }

    @GetMapping("/dba")
    public String dba(Model model) {
        model.addAttribute("user", getUserName());
        model.addAttribute("role", getAuthority());
        return "dba";
    }

    @GetMapping("/accessDenied")
    public String accessDenied(Model model) {
        model.addAttribute("user", getUserName());
        model.addAttribute("role", getAuthority());
        return "accessDenied";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/login?logout";
    }

    private Object getAuthority() {
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()).toString();
    }

    private String getUserName() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }


}
