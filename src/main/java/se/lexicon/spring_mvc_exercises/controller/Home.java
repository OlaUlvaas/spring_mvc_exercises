package se.lexicon.spring_mvc_exercises.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Home {

    private List<String> stringList = new ArrayList<>();

    @GetMapping("/ ")
    public String index(){
        return "index";
    }
    @GetMapping("/contactform")
    public String contactForm(Model model) {
        String input = "";
        model.addAttribute("input", input);
        return "contact";
    }

    @PostMapping("/contact")
    public String contactInfo(@ModelAttribute("input") String input){
        stringList.add(input);
        return "contact";
    }
    @GetMapping("/contact")
    public String contactList(Model model) {
        model.addAttribute("stringList", stringList);
        return "redirect: /home/";
    }
}

