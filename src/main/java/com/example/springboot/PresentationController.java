package com.example.springboot;

import com.example.springboot.database.UsageRepository;
import com.example.springboot.database.permStorage.FieldRepository;
import com.example.springboot.database.permStorage.TaskRepository;
import com.example.springboot.database.permStorage.TaskTypeRepository;
import com.example.springboot.database.permStorage.UserRepository;
import javafx.util.Pair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class PresentationController {
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


    @RequestMapping("/task-durations")
    public String getTaskDurationsByType(@RequestParam List<String> users, @RequestParam List<String> tasktypes) throws JSONException {

        List<String[]> data = taskRepository.getTaskTimes("");
        JSONObject json = new JSONObject();

        for(int i = 0; i < data.size(); i++) {
            String[] actualValue = data.get(i);
            String type = actualValue[0];
            String val = actualValue[1];
            json.put(type, val);
        }

        return json.toString();
    }

    @RequestMapping("opened-closed")
    public String getOpenedClosedRatio(@RequestParam String users, @RequestParam String tasktypes) {

        int openedTask = taskRepository.getOpenTimes();
        int closedTask = taskRepository.getClosedTimes();
        JSONObject json = new JSONObject();

        json.put("opened", openedTask);
        json.put("closed", closedTask);

        return json.toString();
    }

    @RequestMapping("/idle-active")
    public String getIdleActive(@RequestParam String users, @RequestParam String tasktypes) {
        List<String[]> data = taskRepository.getIdleActive("");
        JSONObject json = new JSONObject();

            json.put("idle", data.get(0)[0]);
            json.put("active", data.get(0)[1]);


        return json.toString();
    }

    @RequestMapping("/task-fields")
    public String getTaskFields(@RequestParam String users, @RequestParam String tasktypes) {
        if(tasktypes.split(",").length == 1 && tasktypes != "") {
            List<String[]> data = fieldRepository.getFields(taskTypeRepository.findByName(tasktypes).getId());
            JSONObject json = new JSONObject();

            for (int i = 0; i < data.size(); i++) {
                String[] actualValue = data.get(i);
                String type = actualValue[0];
                String val = actualValue[1];
                json.put(type, val);
            }

            return json.toString();
        }
        else return "";
    }
}
