package com.example.springboot.database.tempStorage;


import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class UsageData {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String taskId;
    private String element;
    private String event;
    private int element_x;
    private int element_y;
    private int screen_x;
    private int screen_y;
    private int document_x;
    private int document_y;
    private int document_width;
    private int documents_height;
    private Date timestamp;
    private String username;
    private String task_type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
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

    public int getElement_x() {
        return element_x;
    }

    public void setElement_x(int element_x) {
        this.element_x = element_x;
    }

    public int getElement_y() {
        return element_y;
    }

    public void setElement_y(int element_y) {
        this.element_y = element_y;
    }

    public int getScreen_x() {
        return screen_x;
    }

    public void setScreen_x(int screen_x) {
        this.screen_x = screen_x;
    }

    public int getScreen_y() {
        return screen_y;
    }

    public void setScreen_y(int screen_y) {
        this.screen_y = screen_y;
    }

    public int getDocument_x() {
        return document_x;
    }

    public void setDocument_x(int document_x) {
        this.document_x = document_x;
    }

    public int getDocument_y() {
        return document_y;
    }

    public void setDocument_y(int document_y) {
        this.document_y = document_y;
    }

    public int getDocument_width() {
        return document_width;
    }

    public void setDocument_width(int document_width) {
        this.document_width = document_width;
    }

    public int getDocuments_height() {
        return documents_height;
    }

    public void setDocuments_height(int documents_height) {
        this.documents_height = documents_height;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) throws ParseException {
        this.timestamp = createDate(timestamp);
    }
    private Date createDate(String str) throws ParseException {
        String[] strArray = str.split("T", 2);
        DateFormat format = new SimpleDateFormat("YYYY-MM-dd kk:mm:ss.S");
        Date date = format.parse(strArray[0]+" "+strArray[1]);
        System.out.println(date);

        return date;
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
