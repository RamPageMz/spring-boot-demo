package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /*
    *   根据用户名显示年龄
    *   params： username
    * */
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showUserByUsername(HttpServletRequest request) {
        System.out.println("in controller");
        User user = userService.getUserByUsername(request.getParameter("username"));//request.getParameter("username")
        if (user == null) {
            return "null";
        } else {
            return user.getUsername() + " " + user.getAge();
        }
    }


    /*
    *   更改密码
    *   params： username newPassword
    * */
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public int updateBypassword(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("newPassword");
        System.out.println(username + " " + password);

        return userService.updateUser(username, password);
    }


    /*
    *   插入新的用户记录
    *   params： username password
    * */
    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public int insertUser(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + " " + password);

        return userService.insertUser(username, password);
    }


    /*
    *   显示所有的用户信息 不分页 json格式
    *   params：
    * */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> getAllUser() {
        List<User> userList = userService.getUserList();

        for (User user : userList) {
            System.out.println(user.getUsername() + ":" + user.getPassword());
        }

        return userList;
    }

}
