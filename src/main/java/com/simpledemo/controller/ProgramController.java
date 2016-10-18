package com.simpledemo.controller;

import com.simpledemo.domain.Program;
import com.simpledemo.domain.ProgramRepository;
import com.simpledemo.domain.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/programs")
public class ProgramController {

    @Autowired
    private ProgramRepository programRepo;

    @RequestMapping(value="", method= RequestMethod.GET)
    public String listPrograms(Model model){
        model.addAttribute("programs", programRepo.findAll());
        return "programs/list";
    }

    @RequestMapping(value="/{id}/edit", method=RequestMethod.GET)
    public String edit(@PathVariable long id,
                       Model model){
        Program program = programRepo.findOne(id);
        model.addAttribute("program", program);
        return "programs/edit";
    }

    @RequestMapping(value="/update", method=RequestMethod.POST)
    public ModelAndView update(@RequestParam("program_id") long id,
                               @RequestParam("program_name") String name,
                               @RequestParam("total_credit") int totalCredit,
                               @RequestParam("enrol_each_sem") int enrolEachSem){
        Program program = programRepo.findOne(id);
        program.setName(name);
        program.setTotalCredit(totalCredit);
        program.setEnrolEachSem(enrolEachSem);
        programRepo.save(program);
        return new ModelAndView("redirect:/programs");
    }
}
