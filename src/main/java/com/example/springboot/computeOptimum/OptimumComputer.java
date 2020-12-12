package com.example.springboot.computeOptimum;

import com.example.springboot.database.UsageRepository;
import com.example.springboot.database.permStorage.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class OptimumComputer {

    private UsageRepository usageRepository;
    private TaskRepository taskRepository;
    private UserRepository userRepository;
    private TaskTypeRepository taskTypeRepository;
    private FieldRepository fieldRepository;
    private FieldEventRepository fieldEventRepository;

    List<Integer> userids = new ArrayList<Integer>();
    ArrayList<Double> times = new ArrayList<Double>();


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

    public void getTypeAveragesForEachUser(int taskType) {
        List<Object[]> times = taskRepository.getTaskTimesForUsers(taskType);

        int i = 0;
        for (Object[] o :
                times) {
            int userId = (int)o[2];
            double time = (double)o[1];

            this.userids.add(userId);
            this.times.add(time);
        }
    }

    public int getUsersCurrentTaskType(int userId){
        List<Object[]>  type = taskRepository.getUsersCurrentTask(userId);
        return (int)type.get(0)[0];
    }

    public void getCurrentTaskTypeAverages(int taskType) throws ParseException {
        int i = 0;
        for (int userId: this.userids) {
            int typeId = getUsersCurrentTaskType(userId);

            double currentTaskTime = taskRepository.getOpenTaskTimesForUser(typeId, userId);
            this.times.set(i, this.times.get(i)+currentTaskTime);
            int modifications = getFieldModificationsOfTaskType(taskType, userId);

            this.times.set(i, times.get(i)+modifications);

            i++;
        }
    }

    public String getPrediction(int taskType) throws ParseException {
        getTypeAveragesForEachUser(taskType);
        getCurrentTaskTypeAverages(taskType);

        int minIndex = this.times.indexOf(Collections.min(this.times));

        Optional<User> u = userRepository.findById(this.userids.get(minIndex));

        return u.get().getUsername();
    }

    private int getFieldModificationsOfTaskType(int taskType, int userId) throws ParseException {
        ArrayList<Object[]> taskIds = getTaskIDsWhere(taskType, userId);

        int modifications = 0;
        for (Object[] task :taskIds) {
            modifications += getModifications((String)task[0], (Date)task[1]);
        }

        return modifications;
    }


    private int getModifications(String s, Date date) {
        return taskRepository.getModifications(s, date);
    }

    private ArrayList<Object[]> getTaskIDsWhere(int taskType, int userId) {
        return taskRepository.getTaskIDsWhere(taskType, userId);
    }
}
