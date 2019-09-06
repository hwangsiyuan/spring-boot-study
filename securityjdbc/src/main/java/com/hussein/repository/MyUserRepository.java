package com.hussein.repository;

import com.hussein.bean.MyRole;
import com.hussein.bean.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>Title: MyUserRepository</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/6 12:37 PM
 */
@Repository
public class MyUserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public MyUser findByLoginName(String loginName) {
        return jdbcTemplate.queryForObject("select * from `tb_user` where `login_name`=?", new Object[]{loginName}, (rs, rowNum) -> {
            MyUser myUser = new MyUser();
            myUser.setId(rs.getLong("id"));
            myUser.setLoginName(rs.getString("login_name"));
            myUser.setPassword(rs.getString("password"));
            myUser.setUserName(rs.getString("user_name"));
            List<Map<String, Object>> mapList = jdbcTemplate.queryForList("select id,authority from tb_role r,tb_user_role tur where r.id=tur.role_id and tur.user_id=?", new Object[]{myUser.getId()});
            List<MyRole> roleList = new ArrayList<>();
            mapList.forEach(rowMap -> {
                MyRole role = new MyRole();
                role.setId((long) rowMap.get("id"));
                role.setAuthority((String) rowMap.get("authority"));
                roleList.add(role);
            });
            myUser.setRoles(roleList);
            return myUser;
        });
    }
}
