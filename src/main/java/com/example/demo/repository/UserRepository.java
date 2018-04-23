package com.example.demo.repository;

import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends Repository<User,Long> {

    // 方法名相当于封装的sql语句
    //@Query("select user from User user where username=:username")
    User findByUsername(String username);

    @Query("select user from User user where age >= :age")
    List<User> findByAge(@Param("age") Integer age);


}
