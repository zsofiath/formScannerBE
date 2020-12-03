package com.example.springboot.transformation;

import com.example.springboot.database.tempStorage.UsageData;

import java.util.List;

public class Transformation {
    List<UsageData> usageData;
    Transformation(List<UsageData> usageData) {
        this.usageData = usageData;
    }
    public void saveFields(){}
    public void saveFieldEvents(){}
    public void saveMouseStroke(){}
    public void saveTasks(){}
    public void saveTaskTypes(){}
    public void saveUser(){}
}
