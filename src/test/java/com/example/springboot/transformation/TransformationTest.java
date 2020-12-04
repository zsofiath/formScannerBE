package com.example.springboot.transformation;

import com.example.springboot.database.UsageRepository;
import com.example.springboot.database.permStorage.Task;
import com.example.springboot.database.permStorage.TaskRepository;
import com.example.springboot.database.tempStorage.UsageData;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.crypto.dsig.Transform;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class TransformationTest {
    /*@Mock
    @InjectMocks
    private TestUsageRepo usageRepository;
    @Mock
    private TaskRepository taskRepository;*/


/*
    @Test
    public void createTasks() throws ParseException {
        List<Object[]> res1 = new ArrayList<>();
        DateFormat format = new SimpleDateFormat("YYYY-MM-dd kk:mm:ss.S");
        Date date = format.parse("2020-12-04 10:00:00.0");
        Date date2 = format.parse("2020-12-04 10:10:00.0");
        res1.add(new Object[]{ "a", date, date2 });

        Task T = new Task();


        Mockito.when(usageRepository.getStartEndAndTime()).thenReturn(res1);

        Transformation TRANSFORM = new Transformation(usageRepository, taskRepository);
        Mockito.when(taskRepository.save(any(Task.class))).thenAnswer(new Answer<Task>() {
            @Override
            public Task answer(InvocationOnMock invocation) throws Throwable {
                return null;
            }
        });

        Task t = Mockito.when(taskRepository.save(Mockito.any(Task.class)))
                .thenAnswer(task ->  task).getMock();

        TRANSFORM.createTasks();

        Assert.assertEquals(null, t);

    }*/
}