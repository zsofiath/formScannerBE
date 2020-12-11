package com.example.springboot.computeOptimum;

import com.example.springboot.database.UsageRepository;
import com.example.springboot.database.permStorage.*;

import java.util.ArrayList;
import java.util.List;

public class OptimumComputer {

    private UsageRepository usageRepository;
    private TaskRepository taskRepository;
    private UserRepository userRepository;
    private TaskTypeRepository taskTypeRepository;
    private FieldRepository fieldRepository;
    private FieldEventRepository fieldEventRepository;

    List<String> users = new ArrayList<String>();
    List<Double> times = new ArrayList<Double>();


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

    public void getTypeAverageForEachUser(int taskType) {
        List<Object[]> times = taskRepository.getTaskTimesForUsers(taskType);
        for (Object[] o :
                times) {
            String username = (String)o[0];
            double time = (double)o[1];

            this.users.add(username);
            this.times.add(time);
        }
    }
}
