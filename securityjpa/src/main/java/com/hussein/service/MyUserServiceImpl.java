package com.hussein.service;

import com.hussein.bean.MyUser;
import com.hussein.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * <p>Title: MyUserServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/5 5:54 PM
 */
@Service
public class MyUserServiceImpl implements UserDetailsService {

    @Autowired
    MyUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
        MyUser user = userRepository.findByLoginName(loginName);
        if (user == null) {
            throw new UsernameNotFoundException("user not found");
        }
        return new User(loginName, user.getPassword(), user.getRoles().stream().map(r -> new SimpleGrantedAuthority(r.getAuthority())).collect(Collectors.toList()));
    }
}
