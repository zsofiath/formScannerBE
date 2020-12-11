package com.example.springboot.computeOptimum;

import com.example.springboot.database.UsageRepository;
import com.example.springboot.database.permStorage.*;

public class OptimumComputer {

    private UsageRepository usageRepository;
    private TaskRepository taskRepository;
    private UserRepository userRepository;
    private TaskTypeRepository taskTypeRepository;
    private FieldRepository fieldRepository;
    private FieldEventRepository fieldEventRepository;

    public OptimumComputer(UsageRepository usageRepository,
                          TaskRepository taskRepository,
                          UserRepository userRepository,
                          TaskTypeRepository taskTypeRepository,
                          FieldRepository fieldRepository,
                          FieldEventRepository fieldEventRepository) {
        this.usageRepository = usageRepository;
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.taskTypeRepository = taskTypeRepository;
        this.fieldRepository = fieldRepository;
        this.fieldEventRepository = fieldEventRepository;
    }
}
