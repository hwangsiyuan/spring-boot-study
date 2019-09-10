package com.hussein.controller;

import com.hussein.dto.req.LoginReq;
import com.hussein.dto.res.LoginRes;
import com.hussein.exception.LoginException;
import com.hussein.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * <p>Title: LoginController</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/9 11:32 AM
 */
@RestController
@RequestMapping("/oa")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/loginAjax")
    public Object loginAjax(@Valid @RequestBody LoginReq loginReq, BindingResult br, HttpSession httpSession) {
        if (br.hasErrors()) {
            throw new LoginException(0, "参数有为空的");
        }
        loginService.login(loginReq, httpSession);
        return LoginRes.builder().status(1).tip("登录成功").build();
    }
}
