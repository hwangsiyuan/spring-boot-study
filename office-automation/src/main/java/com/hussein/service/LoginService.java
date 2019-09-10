package com.hussein.service;

import com.hussein.dto.req.LoginReq;

import javax.servlet.http.HttpSession;

/**
 * <p>Title: LoginService</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/10 10:17 AM
 */
public interface LoginService {

    /**
     * 登录
     *
     * @param loginReq
     * @param httpSession
     */
    void login(LoginReq loginReq, HttpSession httpSession);
}
