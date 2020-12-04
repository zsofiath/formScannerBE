package com.example.springboot.database.permStorage;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Task {
    @Id
    private String id;
    @ManyToOne
    private User user;
    @ManyToOne
    private TaskType taskType;
    private Date startTime;
    private Date endTime;
    private int activeMinutes;
    private double idleMinutes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getActiveMinutes() {
        return activeMinutes;
    }

    public void setActiveMinutes(int activeMinutes) {
        this.activeMinutes = activeMinutes;
    }

    public double getIdleMinutes() {
        return idleMinutes;
    }

    public void setIdleMinutes(double idleMinutes) {
        this.idleMinutes = idleMinutes;
    }
}
