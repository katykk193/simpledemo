package com.simpledemo.controller;

import com.simpledemo.domain.User;
import com.simpledemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by vincent on 21/10/16.
 */

@Controller
@RequestMapping({"/","home"})
@PreAuthorize("hasAnyRole('ROLE_STUDENT', 'ROLE_ADMINISTRATOR', 'ROLE_LECTURER')")
public class HomeController {
    @Autowired
    UserRepository userRepository;
    @RequestMapping(value="", method= RequestMethod.GET)
    public String homeGET(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepository.findByUsername(auth.getName());
        if(user.getType().equals("ROLE_STUDENT")) {
            return "redirect:/studentHome";
        } else if(user.getType().equals("ROLE_LECTURER")) {
            return "redirect:/lecturerHome";
        } else if(user.getType().equals("ROLE_ADMINISTRATOR")) {
            return "redirect:/administrator";
        } else {
            return "redirect:/logout";
        }
    }
    @RequestMapping(value="studentHome", method= RequestMethod.GET)
    public ModelAndView studentHomeGET() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        User user = this.userRepository.findByUsername(auth.getName());

        return new ModelAndView("login/studentHome", "user", user);
    }
    @RequestMapping(value="lecturerHome", method= RequestMethod.GET)
    public ModelAndView lecturerHomeGET() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepository.findByUsername(auth.getName());
        return new ModelAndView("login/lecturerHome", "user", user);
    }
    @RequestMapping(value="administratorHome", method= RequestMethod.GET)
    public ModelAndView administratorHomeGET() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepository.findByUsername(auth.getName());
        return new ModelAndView("login/administratorHome", "user", user);
    }

}


