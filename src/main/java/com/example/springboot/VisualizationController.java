package com.example.springboot;

import com.example.springboot.database.permStorage.TaskTypeRepository;
import com.example.springboot.database.permStorage.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VisualizationController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskTypeRepository taskTypeRepository;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {

        model.addAttribute("types", taskTypeRepository.findAll());
        model.addAttribute("users", userRepository.findAll());
        return "greeting";
    }
}
