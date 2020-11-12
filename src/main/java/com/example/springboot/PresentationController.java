package com.example.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PresentationController {
    @RequestMapping("/task-durations")
    public String getTaskDurationsByType(@RequestParam String users, @RequestParam String tasktypes) {
        return "{\n" +
                "    \"type1\":100,\n" +
                "    \"type2\":10,\n" +
                "    \"type3\":200,\n" +
                "    \"type4\":1,\n" +
                "    \"type5\":10,\n" +
                "    \"type6\":10,\n" +
                "    \"type7\":10\n" +
                "}\n";
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
