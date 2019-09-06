package com.hussein.repository;

import com.hussein.bean.MyRole;
import com.hussein.bean.MyUser;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>Title: MyUserRepository</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/6 10:39 AM
 */
public interface MyUserRepository {

    @Select("select * from `tb_user` where `login_name`=#{loginName}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "login_name", property = "loginName"),
            @Result(column = "password", property = "password"),
            @Result(column = "user_name", property = "userName")
    })
    MyUser findByLoginName(String loginName);

    @Select("select id,authority from tb_role r,tb_user_role tur where r.id=tur.role_id and tur.user_id=#{userId}")
    List<MyRole> getUserRoles(long userId);
}
