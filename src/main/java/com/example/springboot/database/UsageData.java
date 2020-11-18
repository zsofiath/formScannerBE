package com.example.springboot.database;


import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class UsageData {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String element;
    private String event;
    private String element_x;
    private String element_y;
    private String screen_x;
    private String screen_y;
    private String document_x;
    private String document_y;
    private String document_width;
    private String documents_height;
    private String timestamp;
    private String username;
    private String task_type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getElement_x() {
        return element_x;
    }

    public void setElement_x(String element_x) {
        this.element_x = element_x;
    }

    public String getElement_y() {
        return element_y;
    }

    public void setElement_y(String element_y) {
        this.element_y = element_y;
    }

    public String getScreen_x() {
        return screen_x;
    }

    public void setScreen_x(String screen_x) {
        this.screen_x = screen_x;
    }

    public String getScreen_y() {
        return screen_y;
    }

    public void setScreen_y(String screen_y) {
        this.screen_y = screen_y;
    }

    public String getDocument_x() {
        return document_x;
    }

    public void setDocument_x(String document_x) {
        this.document_x = document_x;
    }

    public String getDocument_y() {
        return document_y;
    }

    public void setDocument_y(String document_y) {
        this.document_y = document_y;
    }

    public String getDocument_width() {
        return document_width;
    }

    public void setDocument_width(String document_width) {
        this.document_width = document_width;
    }

    public String getDocuments_height() {
        return documents_height;
    }

    public void setDocuments_height(String documents_height) {
        this.documents_height = documents_height;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTask_type() {
        return task_type;
    }

    public void setTask_type(String task_type) {
        this.task_type = task_type;
    }
}
