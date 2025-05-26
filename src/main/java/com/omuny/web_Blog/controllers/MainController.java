package com.omuny.web_Blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/") // Переход на главную страницу
    public String home(Model model) {
        model.addAttribute("title", "Главная страница");
        return "home";
    }

    @GetMapping("/about") // Переход на главную страницу
    public String about(Model model) {
        model.addAttribute("title", "Страница про нас");
        return "about";
    }

}