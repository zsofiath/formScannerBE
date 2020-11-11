package com.example.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PresentationController {
    @RequestMapping("/task-durations")
    public String getTaskDurationsByType() {
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
}
