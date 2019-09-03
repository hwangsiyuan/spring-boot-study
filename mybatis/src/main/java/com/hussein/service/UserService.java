package com.hussein.service;

import com.hussein.bean.User;
import com.hussein.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>Title: UserService</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/3 2:43 PM
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public int insertUser(User user) {
        return userRepository.insert(user);
    }

    public void insertUserGetKey(User user) {
        userRepository.insertGetKey(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findByUserName(String userName) {
        return userRepository.findUserByUserName(userName);
    }

    public User findById(Long id) {
        return userRepository.findUserById(id);
    }

    public void updateUser(User user) {
        userRepository.update(user);
    }

    public int deleteUser(Long id) {
        return userRepository.delete(id);
    }
}
