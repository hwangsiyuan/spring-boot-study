package com.hussein.controller;

import com.hussein.bean.User;
import com.hussein.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>Title: UserController</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/3 2:48 PM
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/add")
    public String addUser(User user) {
        return "插入数据:[" + userService.insertUser(user) + "]条。";
    }

    @GetMapping("/addGetKey")
    public User addUserGetKey(User user) {
        userService.insertUser(user);
        return user;
    }

    @GetMapping("/list")
    public List<User> listUsers() {
        return userService.findAll();
    }

    @GetMapping("/findByUserName")
    public User findByUserName(String userName) {
        return userService.findByUserName(userName);
    }

    @GetMapping("/findById")
    public User findById(Long id) {
        return userService.findById(id);
    }

    @GetMapping("/update")
    public User update(User user) {
        userService.updateUser(user);
        return user;
    }

    @GetMapping("/delete")
    public String delete(Long id) {
        return "删除数据:[" + userService.deleteUser(id) + "]条。";
    }
}
