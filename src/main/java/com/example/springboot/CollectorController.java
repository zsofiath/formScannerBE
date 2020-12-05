package com.example.springboot;

import com.example.springboot.Model.http.EventPackage;
import com.example.springboot.Model.http.UsagePackage;
import com.example.springboot.database.permStorage.*;
import com.example.springboot.database.tempStorage.UsageData;
import com.example.springboot.database.UsageRepository;
import com.example.springboot.transformation.Transformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
public class CollectorController {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskTypeRepository taskTypeRepository;
    @Autowired
    private FieldRepository fieldRepository;
    @Autowired
    private UsageRepository usageRepository;
    @CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
    @PostMapping(path = "/save-usage", consumes = "application/json", produces = "application/json")
    public String addMember(@RequestBody UsagePackage upackage) throws ParseException {

        for (EventPackage event :
                upackage.getEventList()) {
            UsageData usageData = new UsageData();
            usageData.setTaskId(upackage.getTaskId());
            usageData.setUsername(upackage.getUserName());
            usageData.setTask_type(upackage.getTaskType());
            usageData.setDocument_width(event.getDocumentSize().getWidth());
            usageData.setDocuments_height(event.getDocumentSize().getHeight());
            usageData.setDocument_x(event.getDocumentPosition().getX());
            usageData.setDocument_y(event.getDocumentPosition().getY());
            usageData.setElement(event.getElementName());
            usageData.setEvent(event.getEventName());
            usageData.setScreen_x(event.getScreenPosition().getX());
            usageData.setScreen_y(event.getScreenPosition().getY());
            usageData.setElement_x(event.getElementPosition().getX());
            usageData.setElement_y(event.getElementPosition().getY());
            usageData.setTimestamp(event.getDateTime());
            usageRepository.save(usageData);
        }
        return "";
    }

    @RequestMapping(path = "/t")
    public String transform() throws ParseException {
        Transformation T = new Transformation(usageRepository, taskRepository, userRepository, taskTypeRepository, fieldRepository);
        T.createTasks();
        return "";
    }
}
