package com.example.springboot.transformation;

import com.example.springboot.database.UsageRepository;
import com.example.springboot.database.permStorage.*;
import com.example.springboot.database.returnData;
import com.example.springboot.database.tempStorage.UsageData;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Transformation {

    private UsageRepository usageRepository;
    private TaskRepository taskRepository;
    private UserRepository userRepository;
    private TaskTypeRepository taskTypeRepository;
    private FieldRepository fieldRepository;
    private FieldEventRepository fieldEventRepository;

    public Transformation(UsageRepository usageRepository,
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
    public void createFieldEvents(){

    }
    public void createFields(String taskID) {
        List<Object[]> usages = usageRepository.getTaskActions_inputEvents(taskID);
        for (Object[] row : usages) {
            String name = (String)row[1];
            int taskTypeId = taskTypeRepository.findByName((String)row[0]).getId();
           Field f = fieldRepository.findBy(name, taskTypeId);
           if(f == null) {
               Field ff = new Field();
               ff.setFieldName((String)row[1]);
               ff.setTaskType(taskTypeRepository.findByName((String)row[0]));

               fieldRepository.save(ff);
               f = fieldRepository.findBy(name, taskTypeId);
           }
           FieldEvent fe = new FieldEvent();
            fe.setEvent((String)row[2]);
            fe.setField(f);
            List<Task> task = taskRepository.getTaskById(taskID);
            fe.setTask(task.get(0));

            fieldEventRepository.save(fe);
        }
    }
    //public List<MouseStroke> createMouseStroke(){}
    public void createTasks() throws ParseException {
        List<Object[]> dates = usageRepository.getStartEndAndTime();
        for (Object[] dataRow :
                dates) {
            List<Task> currentTask = taskRepository.getTaskById((String)dataRow[0]);
            if(currentTask.size() > 0){
                updateTask(dataRow, currentTask.get(0));
            }
            else {
                createTask(dataRow);
            }
        }
    }

    public void setClosedTasks(){
        Iterable<Task> tasks = taskRepository.findAll();

        for (Task task :
                tasks) {
            Instant instant = Instant.now();
            long now = instant.toEpochMilli();
            Date taskTime = task.getEndTime();
            long differenceInMinutes = ((now - taskTime.getTime())/1000)/60;
            if((((differenceInMinutes))/60)/60 > 24) {
                task.setClosed(true);
                taskRepository.save(task);
            }
        }

    }

    private void createTask(Object[] dataRow){
        Task T = new Task();
        T.setId((String)dataRow[0]);
        T.setStartTime((Date)dataRow[1]);
        T.setEndTime((Date)dataRow[2]);
        T.setTaskType(taskTypeRepository.findByName((String)dataRow[3]));
        T.setUser(userRepository.findByName((String)dataRow[4]));
        T.setClosed(false);
        taskRepository.save(T);
        createFields((String)dataRow[0]);
        computeIdleAndActiveTimes(dataRow, T);
    }

    private void computeIdleAndActiveTimes(Object[] dataRow, Task T){
        double idleTime = 0;
        List<UsageData> usages = usageRepository.getTaskActions((String)dataRow[0]);
        for (int i = 0; i < usages.size()-4; i++) {
            if(isIdle(usages, i)) {
                idleTime += computeIdleMinutes((UsageData)usages.get(i+1), (UsageData)usages.get(i+2));
            }
        }
        T.setIdleMinutes(idleTime);
        T.setActiveMinutes((int)(computeActiveMinutes((Date)dataRow[1], (Date)dataRow[2]) - idleTime));
    }

    private void updateTask(Object[] dataRow, Task T){
        T.setEndTime((Date)dataRow[2]);
        computeIdleAndActiveTimes(dataRow, T);
        taskRepository.save(T);
        createFields((String)dataRow[0]);
    }

    private double computeIdleMinutes(UsageData idleStartEvent, UsageData idleEndEvent) {
        return s_to_min(ms_to_s(idleEndEvent.getTimestamp().getTime() - idleStartEvent.getTimestamp().getTime()));
    }

    private double computeActiveMinutes(Date date1, Date date2) {
        return Math.round(s_to_min(ms_to_s(date2.getTime() - date1.getTime())));
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
