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
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String showUserByUsername(HttpServletRequest request){
        System.out.println("in controller");
        User user=userService.getUserByUsername(request.getParameter("username"));//request.getParameter("username")
        if (user==null){
            return "null";
        }else{
            return user.getUsername()+" "+user.getAge();
        }
    }

}
