package com.hussein.service;

import com.hussein.bean.MyRole;
import com.hussein.bean.MyUser;
import com.hussein.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>Title: MyUserServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/6 10:48 AM
 */
@Service
public class MyUserServiceImpl implements UserDetailsService {

    @Autowired
    MyUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
        MyUser myUser = userRepository.findByLoginName(loginName);
        if (myUser == null) {
            throw new UsernameNotFoundException("user not found.");
        }
        List<MyRole> roleList = myUser.getRoles();
        return new User(loginName, myUser.getPassword(), roleList.stream().map(r -> new SimpleGrantedAuthority(r.getAuthority())).collect(Collectors.toList()));
    }
}
