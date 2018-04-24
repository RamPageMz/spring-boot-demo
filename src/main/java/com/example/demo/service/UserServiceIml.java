package com.example.demo.service;

import com.example.demo.criteria.UserCriteria;
import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Component("userService")
@Transactional
public class UserServiceIml implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByUsername(String useranme) {
        System.out.println("in service impl:" + useranme);
        Assert.notNull(useranme, "username must be not null");
        Assert.hasLength(useranme, "username must be not empty");

        return userRepository.findByUsername(useranme);
    }

    @Override
    public List<User> getUserByAge(Integer age) {
        Assert.notNull(age, "Age must not be null");
        return userRepository.findByAge(age);
    }

    @Override
    public String updateUserByUseranme(String username) {
        return null;
    }

    @Override
    public Page<User> getAllUser(UserCriteria userCriteria, Pageable pageable) {
        return null;
    }

    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public int updateUser(String username, String password) {
        Assert.notNull(username, "updateUser:username null");
        Assert.notNull(password, "updateUser:password null");
        return userRepository.updateUserByUsername(username, password);
    }

    @Override
    public int insertUser(String username, String password) {
        Assert.notNull(username, "insertUser:username null");
        Assert.notNull(password, "insertUser:password null");
        User user = new User(username, password);
        userRepository.save(user);
        return 1;
    }
}
