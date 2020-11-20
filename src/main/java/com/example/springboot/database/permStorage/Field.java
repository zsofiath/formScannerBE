package com.example.springboot.database.permStorage;

import javax.persistence.*;

@Entity
public class Field {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String fieldName;
    @ManyToOne
    private TaskType taskType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }
}
