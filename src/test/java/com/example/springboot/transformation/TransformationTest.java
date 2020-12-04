package com.example.springboot.transformation;

import com.example.springboot.database.permStorage.Task;
import com.example.springboot.database.tempStorage.UsageData;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javax.xml.crypto.dsig.Transform;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class TransformationTest {
  /*  List<UsageData> usageData;
    Transformation transform;

    @BeforeClass
    void preloadTest(){
        UsageData d1 = new UsageData();
        d1.setTimestamp("2020-12-03T13:57:07.755Z");

        UsageData d2 = new UsageData();
        d1.setTimestamp("2020-12-03T14:57:07.755Z");

        usageData = new ArrayList<>();

        usageData.add(d1);
        usageData.add(d2);

        transform = new Transformation(usageData);
    }

    @Test
    void saveFields() {
    }

    @Test
    void saveFieldEvents() {
    }

    @Test
    void saveMouseStroke() {
    }

    @Test
    void createTasks_createTaskByTaskID() {
        usageData = new ArrayList<>();
        UsageData d1 = new UsageData();
        d1.setId("d");
        d1.setTimestamp("2020-12-03T13:57:07.755Z");

        UsageData d2 = new UsageData();
        d2.setId("e");
        d2.setTimestamp("2020-12-03T14:57:07.755Z");

        usageData.add(d1);
        usageData.add(d2);

        transform = new Transformation(usageData);
        List<Task> tasks = transform.createTasks();

        Assert.assertEquals(2, tasks.size());
    }

    @Test
    void createTasks_oneTaskWithProperties() throws ParseException {
        usageData = new ArrayList<>();
        UsageData d1 = new UsageData();
        d1.setId("d");
        d1.setTimestamp("2020-12-03T13:57:07.755Z");

        UsageData d2 = new UsageData();
        d2.setId("d");
        d1.setTimestamp("2020-12-03T14:57:07.755Z");

        usageData.add(d1);
        usageData.add(d2);

        transform = new Transformation(usageData);
        List<Task> tasks = transform.createTasks();


        String string = "2020-12-03 14:57:07.755Z";
        DateFormat format = new SimpleDateFormat("YYYY-MM-dd kk:mm:ss.S");
        Date date = format.parse(string);
        System.out.println(date);

        Assert.assertEquals(date, tasks.get(0).getStartTime());
    }

    @Test
    void saveTaskTypes() {
    }

    @Test
    void saveUser() {
    }*/
}