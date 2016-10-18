package com.simpledemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class FileUploadController {

    @RequestMapping("/file")
    public String file(){
        return "/file";
    }

    @RequestMapping("/upload")
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile file){
        try {
            String content = new String(file.getBytes());
            return "file name:" + file.getOriginalFilename() + "<br> content:" + content;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "file name:" + file.getOriginalFilename() +"<br> read file content error.";
    }
}

