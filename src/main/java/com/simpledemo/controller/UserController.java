package com.simpledemo.controller;

import com.simpledemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.simpledemo.domain.User;

import java.util.ArrayList;

/**
 * Created by vincent on 19/10/16.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = {"","/home"}, method = RequestMethod.GET)
    public ModelAndView userHome() {
        User user = new User();
        user.setId(100);
        user.setUsername("pei");
        ArrayList<User> users = new ArrayList<User>();
        users.add(user);
        return new ModelAndView("user/home", "users", users);
    }


}
