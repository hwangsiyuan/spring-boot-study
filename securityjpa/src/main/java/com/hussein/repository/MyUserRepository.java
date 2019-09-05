package com.hussein.repository;

import com.hussein.bean.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>Title: MyUserRepository</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/5 2:55 PM
 */
public interface MyUserRepository extends JpaRepository<MyUser, Long> {

    /**
     * 根据登录名获取用户
     *
     * @param loginName 登录名
     * @return 用户
     */
    MyUser findByLoginName(String loginName);
}
