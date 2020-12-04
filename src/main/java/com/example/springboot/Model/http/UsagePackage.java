package com.example.springboot.Model.http;

import java.util.List;

public class UsagePackage {
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskIi(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public List<EventPackage> getEventList() {
        return eventList;
    }

    public void setEventList(List<EventPackage> eventList) {
        this.eventList = eventList;
    }

    private String userName;
    private String taskId;
    private String taskType;

    private List<EventPackage> eventList;
}
