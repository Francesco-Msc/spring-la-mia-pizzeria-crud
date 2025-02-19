package org.lessons.java.spring_crud.controller;

import java.util.List;

import org.lessons.java.spring_crud.model.Pizza;
import org.lessons.java.spring_crud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/homepage")
public class PizzeController {

    @Autowired
    private PizzaRepository repo;
    
    @GetMapping
    public String homepage(Model model){
        List<Pizza> pizze = repo.findAll();
        model.addAttribute("pizze", pizze);
        return "homepage/index";
    }

    @GetMapping("/{id}")
    public String detailpage(@PathVariable("id") Integer id, Model model){
        model.addAttribute("pizze", repo.findById(id).get());
        return "homepage/show";
    }

    @GetMapping("/search")
    public String findByKeyword(@RequestParam(name = "query") String query, Model model){
        List<Pizza> pizze = repo.findByNameContainingOrDescriptionContaining(query, query);
        model.addAttribute("pizze", pizze);
        return "homepage/index";
    }

    @GetMapping("/cart")
    public String cart(Model model){
        return "homepage/cart";
    }
    
    @GetMapping("/add")
    public String create(Model model){
        model.addAttribute("pizza", new Pizza());
        return "homepage/add";
    }

    @PostMapping("/add")
    public String store(@Valid @ModelAttribute("pizza") Pizza addPizza, BindingResult bindingResult ,Model model){

        if (bindingResult.hasErrors()) {
            return "homepage/add";
        }

        repo.save(addPizza);
        return "redirect:/homepage";
    }
}
