package com.example.springboot;

import com.example.springboot.computeOptimum.OptimumComputer;
import com.example.springboot.database.UsageRepository;
import com.example.springboot.database.permStorage.*;
import com.example.springboot.transformation.Transformation;
import org.springframework.beans.factory.ObjectProvider;
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
        OptimumComputer O = new OptimumComputer(usageRepository, taskRepository, userRepository, taskTypeRepository, fieldRepository, fieldEventRepository);
        O.getTypeAverageForEachUser(1);
        return "username";
    }
}
