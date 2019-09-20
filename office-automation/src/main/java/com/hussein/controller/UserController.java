package com.hussein.controller;

import com.hussein.domain.User;
import com.hussein.dto.req.UserListReq;
import com.hussein.dto.res.PageData;
import com.hussein.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <p>Title: UserController</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/20 11:23 AM
 */
@Controller
@RequestMapping("/identity/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/selectUser")
    public String selectUser(UserListReq req, Model model) {
        PageData<List<User>> pageData = userService.listUser(req);
        model.addAttribute("pageData", pageData);
        return "users/user";
    }
}
