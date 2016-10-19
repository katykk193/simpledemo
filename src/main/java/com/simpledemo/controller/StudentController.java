//package com.simpledemo.controller;
//
//import com.simpledemo.repository.LecturerRepository;
//import com.simpledemo.repository.StudentRepository;
//import com.simpledemo.repository.UnitRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//@Controller
//@RequestMapping("/students")
//public class StudentController {
//
//    @Autowired
//    private StudentRepository studentRepo;
//    @Autowired
//    private UnitRepository unitRepo;
//
//    @RequestMapping(value="", method= RequestMethod.GET)
//    public String listStudentUnits(Model model){
//        model.addAttribute("studentUnits", unitRepo.findAll());
//        return "students/list";
//    }
//}