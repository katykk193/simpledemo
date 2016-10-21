package com.simpledemo.controller;
import com.simpledemo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by Simon on 10/21/2016.
 */
@Controller
@RequestMapping("/elearning")
public class ElearningController {
    @Autowired
    private UnitRepository unitRepository;
    @Autowired
    private EnrollmentRepository enrollRepository;

    //show all units
    @RequestMapping(value="", method= RequestMethod.GET)
    public String MyUnits(Model model){
        model.addAttribute("myEnrollment", enrollRepository.findAll());
       // System.out.println(enrollRepository.findAll().size());
        return "elearning/list";
    }

//    @RequestMapping(value="/uploadMaterial", method=RequestMethod.GET)
//    public @ResponseBody String provideUploadInfo() {
//        return "You can upload a file by posting to this same URL.";
//    }

    @RequestMapping(value="/uploadMaterial", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("name") String name,
                                                 @RequestParam("file") MultipartFile file){
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(name + "-uploaded")));
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded " + name + " into " + name + "-uploaded !";
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }
    }




}
