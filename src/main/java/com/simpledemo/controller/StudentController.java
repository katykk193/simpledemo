package com.simpledemo.controller;

import com.simpledemo.repository.StudentRepository;
import com.simpledemo.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin/enrol")
public class StudentController {

    @Autowired
    private StudentRepository studentRepo;
    @Autowired
    private UnitRepository unitRepo;

    @RequestMapping(value="", method= RequestMethod.GET)
    public String listStudents(Model model){
        model.addAttribute("students", studentRepo.findAll());
        return "admin/enrol/list";
    }
}
