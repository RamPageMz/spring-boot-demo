package com.example.demo.service;

import com.example.demo.criteria.UserCriteria;
import com.example.demo.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    // 根据username来搜索user
    User getUserByUsername(String useranme);

    List<User> getUserByAge(Integer age);

    // 根据username来更改user
    String updateUserByUseranme(String username);

    // 根据username获取所有的user 列表
    Page<User> getAllUser(UserCriteria userCriteria, Pageable pageable);

}
