package com.simpledemo.controller;

import com.simpledemo.repository.UserRepository;
import org.hibernate.JDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.simpledemo.domain.User;
import com.simpledemo.domain.Student;
import com.simpledemo.domain.Lecturer;
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

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView registerGet() {
        return new ModelAndView("user/register");
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView registerPost(User user) {

        if(user.getType().equals("student")) {
            System.out.println("is student");
            try {
                userRepository.save(new Student(user));
            } catch (Exception e) {
                return new ModelAndView("user/register", "message", "name has been used");
            }

        } else if(user.getType().equals("teacher")){
            System.out.println("is teacher");
            try {
                userRepository.save(new Lecturer(user));
            } catch (Exception e) {
                return new ModelAndView("user/register", "message", "name has been used");
            }
        }
        return new ModelAndView("user/profile", "user", user);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ModelAndView testGet() {
        User user = new User();
        user.setId(100);
        user.setUsername("pei");
        return new ModelAndView("user/test", "user", user);
    }


}
