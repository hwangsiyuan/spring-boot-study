package com.hussein.service.impl;

import com.hussein.domain.User;
import com.hussein.dto.req.LoginReq;
import com.hussein.exception.LoginException;
import com.hussein.repository.UserRepository;
import com.hussein.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * <p>Title: LoginServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/10 10:18 AM
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 3:账户或密码错误;4:验证码错误;5:账号未激活
     *
     * @param loginReq
     * @param httpSession
     */
    @Override
    public void login(LoginReq loginReq, HttpSession httpSession) {
        if (!loginReq.getVcode().equalsIgnoreCase((String) httpSession.getAttribute("verify_session"))) {
            throw new LoginException(4, "验证码错误");
        }
        User user = getUser(loginReq);
        if (user == null || !user.getPassword().equals(loginReq.getPassword())) {
            throw new LoginException(3, "账户或密码错误");
        }
        if (user.getStatus() != 1) {
            throw new LoginException(5, "账号未激活");
        }
        httpSession.setAttribute("user_session", user);
    }

    private User getUser(LoginReq loginReq) {
        User user = userRepository.findById(loginReq.getUserId()).get();
        if (user != null) {
            if (user.getDept() != null) {
                user.getDept().getName();
            }
            if (user.getJob() != null) {
                user.getJob().getName();
            }
            if (user.getCreator() != null) {
                user.getCreator().getName();
            }
            if (user.getModifier() != null) {
                user.getModifier().getName();
            }
            if (user.getCheckUser() != null) {
                user.getCheckUser().getName();
            }
        }
        return user;
    }
}
