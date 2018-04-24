package com.example.demo.repository;

import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    // 方法名相当于封装的sql语句
    //@Query("select user from User user where username=:username")
    User findByUsername(String username);

    @Query("select user from User user where age >= :age")
    List<User> findByAge(@Param("age") Integer age);

    @Query("select user from User user")
    List<User> findAll();

    @Modifying
    @Query("update User user set password=:newPassword where username=:username")
    int updateUserByUsername(@Param("username") String username, @Param("newPassword") String pwd);

//    @Modifying
//    @Query(value = "insert into USER(username,password) VALUES (:username,:password)", nativeQuery = true)
//    int insertUser(@Param("username") String username, @Param("password") String password);

}
