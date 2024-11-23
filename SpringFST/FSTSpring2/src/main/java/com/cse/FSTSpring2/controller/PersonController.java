package com.cse.FSTSpring2.controller;

import com.cse.FSTSpring2.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class PersonController {
    @GetMapping()
    String getPeople(Model model)
    {
        model.addAttribute("something","this is coming from the controller");
        model.addAttribute("people", Arrays.asList(
                new Person("krishna",1),
                new Person("xyz",29),
                new Person("mno",23)));
        return "people";
    }
}
