package com.simpledemo.controller;

import com.simpledemo.domain.LecturerRepository;
import com.simpledemo.domain.ProgramRepository;
import com.simpledemo.domain.Unit;
import com.simpledemo.domain.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/units")
public class UnitController {

    @Autowired
    private UnitRepository repository;
    @Autowired
    private LecturerRepository lecturerRepo;
    @Autowired
    private ProgramRepository programRepo;

    @RequestMapping(value="", method=RequestMethod.GET)
    public String listUnits(Model model){
        model.addAttribute("units", repository.findAll());
        return "units/list";
    }

    @RequestMapping(value="/{id}/delete", method=RequestMethod.GET)
    public ModelAndView delete(@PathVariable long id){
        repository.delete(id);
        return new ModelAndView("redirect:/units");
    }

    @RequestMapping(value="/new", method=RequestMethod.GET)
    public String newUnit(Model model){
        model.addAttribute("lecturers", lecturerRepo.findAll());
        model.addAttribute("programs", programRepo.findAll());
        return "units/new";
    }

    @RequestMapping(value="/create", method=RequestMethod.POST)
    public ModelAndView create(@RequestParam("unit_id") long id,
                               @RequestParam("unit_name") String name,
                               @RequestParam("lecturer") String lecturer,
                               @RequestParam("program") String program,
                               @RequestParam("credit") int credit,
                               @RequestParam("description") String description){
        repository.save(new Unit(id, name, lecturer, program, credit, description));
        return new ModelAndView("redirect:/units");
    }

    @RequestMapping(value="/update", method=RequestMethod.POST)
    public ModelAndView update(@RequestParam("unit_id") long id,
                               @RequestParam("unit_name") String name,
                               @RequestParam("lecturer") String lecturer,
                               @RequestParam("program") String program,
                               @RequestParam("credit") int credit,
                               @RequestParam("description") String description){
        Unit unit = repository.findOne(id);
        unit.setName(name);
        unit.setLecturer(lecturer);
        unit.setProgram(program);
        unit.setCredit(credit);
        unit.setDescription(description);
        repository.save(unit);
        return new ModelAndView("redirect:/units");
    }

    @RequestMapping(value="/{id}/edit", method=RequestMethod.GET)
    public String edit(@PathVariable long id,
                       Model model){
        Unit unit = repository.findOne(id);
        model.addAttribute("unit", unit);
        model.addAttribute("lecturers", lecturerRepo.findAll());
        model.addAttribute("programs", programRepo.findAll());
        return "units/edit";
    }

}
