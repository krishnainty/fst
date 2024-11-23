package com.cse.FSTSpring3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.LocalTime;

@Controller
public class GreetingController {

    @GetMapping("/")
    public String showForm() {
        return "greeting";  // Returns the form (greeting.html)
    }

    @GetMapping("/greet")
    public String greet(@RequestParam(value = "name", defaultValue = "User") String name, Model model) {
        LocalTime currentTime = LocalTime.now();
        model.addAttribute("name", name);
        model.addAttribute("currentTime", currentTime);
        return "result";  // Returns the result page (result.html)
    }
}