package com.simpledemo.controller;

import com.simpledemo.domain.StuUni;
import com.simpledemo.domain.Student;
import com.simpledemo.domain.Unit;
import com.simpledemo.repository.StudentRepository;
import com.simpledemo.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

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

    @RequestMapping(value="/update", method=RequestMethod.POST)
    public ModelAndView update(@RequestParam("student_id") long studentId,
                               @RequestParam("unit") String unitStr){
        Student student = studentRepo.findOne(studentId);
        String[] unitStrs = unitStr.split(":");
        long unitId = Long.parseLong(unitStrs[0]);

        Unit unit = unitRepo.findOne(unitId);
        StuUni stuuni = new StuUni(student, unit);

//        student.getStuunis().add(stuuni);
        studentRepo.save(student);

        return new ModelAndView("redirect:/admin/enrol");
    }

    @RequestMapping(value="/{id}/edit", method=RequestMethod.GET)
    public String edit(@PathVariable long id,
                       Model model){
        Student student = studentRepo.findOne(id);
        ArrayList<Unit> units = unitRepo.findByProgram(student.getProgram());
        model.addAttribute("student", student);
        model.addAttribute("units", units);
        return "admin/enrol/edit";
    }
}
