package com.example.springboot;

import com.example.springboot.database.UsageRepository;
import com.example.springboot.database.permStorage.*;
import com.example.springboot.transformation.Transformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
public class DistributionController {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskTypeRepository taskTypeRepository;
    @Autowired
    private FieldRepository fieldRepository;
    @Autowired
    private FieldEventRepository fieldEventRepository;
    @Autowired
    private UsageRepository usageRepository;

    @RequestMapping(path = "/get-user")
    public String transform() throws ParseException {
        Transformation T = new Transformation(usageRepository, taskRepository, userRepository, taskTypeRepository, fieldRepository, fieldEventRepository);
        T.createTasks();
        T.setClosedTasks();
        return "username";
    }
}
