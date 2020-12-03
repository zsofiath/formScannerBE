package com.example.springboot.transformation;

import com.example.springboot.database.tempStorage.UsageData;
import org.junit.BeforeClass;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javax.xml.crypto.dsig.Transform;
import java.util.List;

class TransformationTest {
    List<UsageData> usageData;
    Transformation transform;

    @BeforeClass
    void preloadTest(){
        UsageData d1 = new UsageData();
        d1.setTimestamp("");
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
    void saveTasks() {
    }

    @Test
    void saveTaskTypes() {
    }

    @Test
    void saveUser() {
    }
}