package org.lessons.java.spring_crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PizzeController {
    
    @GetMapping("/")
    public String Homepage(){
        return "index";
    }
}
