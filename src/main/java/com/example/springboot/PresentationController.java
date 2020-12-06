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
        return "{\n" +
                "    \"opened\":100,\n" +
                "    \"closed\":10\n" +
                "}\n";
    }

    @RequestMapping("/idle-active")
    public String getIdleActive(@RequestParam String users, @RequestParam String tasktypes) {
        return "{\n" +
                "    \"idle\":100,\n" +
                "    \"active\":10\n" +
                "}\n";
    }

    @RequestMapping("/task-fields")
    public String getTaskFields(@RequestParam String users, @RequestParam String tasktypes) {
        return "{\n" +
                "    \"field1\":100,\n" +
                "    \"field2\":10,\n" +
                "    \"fieldN\":200\n" +
                "}\n";
    }
}
