package com.example.springboot;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Member;

@RestController
public class CollectorController {

    @CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
    @PostMapping(path = "/save-usage", consumes = "application/json", produces = "application/json")
    public String addMember(@RequestBody String member) {
        return "";
    }
}
