package org.lessons.java.spring_crud.controller;

import java.util.List;

import org.lessons.java.spring_crud.model.Pizza;
import org.lessons.java.spring_crud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/homepage")
public class PizzeController {

    @Autowired
    private PizzaRepository repo;
    
    @GetMapping("")
    public String Homepage(Model model){
        List<Pizza> pizze = repo.findAll();
        model.addAttribute("pizze", pizze);
        return "homepage/index";
    }
}
