package com.hussein.repository;

import com.hussein.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>Title: UserRepository</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/3 1:57 PM
 */
public interface UserRepository {

    @Insert("insert into `tb_user`(`login_name`,`password`,`user_name`) values(#{loginName},#{password},#{userName})")
    int insert(User user);

    @Insert("insert into `tb_user`(`login_name`,`password`,`user_name`) values(#{loginName},#{password},#{userName})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insertGetKey(User user);

    @Select("select * from `tb_user`")
    @Results(id = "userResult", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "login_name", property = "loginName"),
            @Result(column = "password", property = "password"),
            @Result(column = "user_name", property = "userName")
    })
    List<User> findAll();

    @Select("select * from `tb_user` where `user_name`=#{user_name}")
    @ResultMap("userResult")
    User findUserByUserName(@Param("user_name") String userName);

    @Select("select * from `tb_user` where `id`=#{id}")
    @ResultMap("userResult")
    User findUserById(long id);

    @Update("update `tb_user` set `login_name`=#{loginName},`user_name`=#{userName} where `id`=#{id}")
    void update(User user);

    @Delete("delete from `tb_user` where `id`=#{id}")
    int delete(long id);
}
