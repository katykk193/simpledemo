package com.simpledemo.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by vincent on 21/10/16.
 */
@Controller
public class LoginController {
    @RequestMapping(value="/login", method= RequestMethod.GET)
    public ModelAndView loginGET(@RequestParam(value="error", required=false) String error,
                           @RequestParam(value="logout", required=false) String logout){
        ModelAndView model = new ModelAndView();
        if(error != null) {
            model.addObject("msg","Invalid username or password");
        }
        if(logout != null) {
            model.addObject("msg","You've logged out successfully");
        }
        model.setViewName("login/login");
        return model;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutGET(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        System.out.println("you logged out");
        return "redirect:login/login?logout";
    }

/*
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutGET() {
        return "redirect:j_spring_security_logout";
    }*/

}
