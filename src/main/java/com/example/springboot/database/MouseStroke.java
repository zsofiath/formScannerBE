package com.example.springboot.database;

import javax.persistence.*;

@Entity
public class MouseStroke {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @ManyToOne
    private Task task;
    private String listOfPositions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getListOfPositions() {
        return listOfPositions;
    }

    public void setListOfPositions(String listOfPositions) {
        this.listOfPositions = listOfPositions;
    }
}
