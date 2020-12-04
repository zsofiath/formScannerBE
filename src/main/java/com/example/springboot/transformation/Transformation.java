package com.example.springboot.transformation;

import com.example.springboot.database.UsageRepository;
import com.example.springboot.database.permStorage.*;
import com.example.springboot.database.returnData;
import com.example.springboot.database.tempStorage.UsageData;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Transformation {

    private UsageRepository usageRepository;
    private TaskRepository taskRepository;

    public Transformation(UsageRepository usageRepository, TaskRepository taskRepository) {
        this.usageRepository = usageRepository;
        this.taskRepository = taskRepository;
    }
    //public List<FieldEvent> createFieldEvents(){}
    //public List<Field> createFields(){}
    //public List<MouseStroke> createMouseStroke(){}
    public List<Task> createTasks() throws ParseException {
        List<Task> taskList = new ArrayList<>();

        List<Object[]> dates = usageRepository.getStartEndAndTime();
        for (Object[] dateRow :
                dates) {
            Task T = new Task();
            T.setId((String)dateRow[0]);
            T.setStartTime((Date)dateRow[1]);
            T.setEndTime((Date)dateRow[2]);

            
            double idleTime = 0;
            List<UsageData> usages = usageRepository.getTaskActions((String)dateRow[0]);
            for (int i = 0; i < usages.size()-4; i++) {
                if(isIdle(usages, i)){
                    idleTime += computeIdleMinutes((UsageData)usages.get(i+1), (UsageData)usages.get(i+2));
                }
            }
            T.setIdleMinutes(idleTime);
            taskRepository.save(T);
        }

        return taskList;
    }

    private double computeIdleMinutes(UsageData idleStartEvent, UsageData idleEndEvent){
        return s_to_min(ms_to_s(idleEndEvent.getTimestamp().getTime() - idleStartEvent.getTimestamp().getTime()));
    }

    private double ms_to_s(double ms){
        return ms/1000;
    }

    private double s_to_min(double s){
        return s/60;
    }

    private boolean isIdle(List<UsageData> usages, int i) {
        return (usages.get(i).getEvent().equals("onblur") &&
                usages.get(i+1).getEvent().equals("idle") &&
                usages.get(i+2).getEvent().equals("visible") &&
                usages.get(i+3).getEvent().equals("onfocus"))
                ||
                (usages.get(i).getEvent().equals("onblur") &&
                usages.get(i+1).getEvent().equals("idle") &&
                usages.get(i+2).getEvent().equals("onfocus") &&
                usages.get(i+3).getEvent().equals("visible"));
    }



    //public List<TaskType> createTaskTypes(){}
    //public List<User> createUser(){}
}
