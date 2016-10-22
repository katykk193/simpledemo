package com.simpledemo.controller;

import com.simpledemo.domain.Enrollment;
import com.simpledemo.domain.Unit;
import com.simpledemo.domain.User;
import com.simpledemo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Simon on 10/20/2016.
 */
@Controller
@RequestMapping("/enrollment")
public class EnrollmentController {
    @Autowired
    private UnitRepository unitRepository;
    @Autowired
   private EnrollmentRepository enrollRepository;
    @Autowired
    private UserRepository userRepository;
    private LecturerRepository lecturerRepository;
    private ProgramRepository programRepository;
    private StudentRepository studentRepository;
//show all units
    @RequestMapping(value="", method= RequestMethod.GET)
    public String listPrograms(Model model){

        model.addAttribute("units", unitRepository.findAll());
        model.addAttribute("enrollment", enrollRepository.findAll());

        return "enrollment/list";
    }
//add enroll units
    @RequestMapping(value="/{id}/myenroll", method=RequestMethod.GET)
    public String edit(@PathVariable long id,
                       Model model){
        Unit unit = unitRepository.findOne(id);
        model.addAttribute("unit", unit);
        return "enrollment/myenroll";
    }

    @RequestMapping(value="/enroll", method=RequestMethod.GET)
    public ModelAndView enroll(@RequestParam("unit_id") long id,@RequestParam("unit_name")String unitName){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepository.findByUsername(auth.getName());
        enrollRepository.save(new Enrollment(id,user.getUsername(),id,unitName));
        return new ModelAndView("redirect:/enrollment");
    }


    //drop enrollment
    @RequestMapping(value="/{id}/drop", method=RequestMethod.GET)
    public ModelAndView drop(@PathVariable long id){
        System.out.println("ddddddddd");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
         User user = this.userRepository.findByUsername(auth.getName());
        System.out.println("ddddddddd"+user.getUsername());

        enrollRepository.delete(id);
       // enrollRepository.save(new Enrollment(5555,user.getUsername(),id,user.getUsername()));
        return new ModelAndView("redirect:/enrollment");

    }


}
