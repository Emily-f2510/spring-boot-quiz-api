package com.example.demo.controller;

import com.example.demo.entity.Test;
import com.example.demo.service.TestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teste")
@CrossOrigin
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping
    public List<Test> getAll() {
        return testService.getAll();
    }

    @PostMapping
    public Test save(@RequestBody Test test) {
        return testService.save(test);
    }
}
