package com.example.demo.controller;

import com.example.demo.entity.RaspunsTest;
import com.example.demo.service.RaspunsTestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/raspunsuriTest")
@CrossOrigin
public class RaspunsTestController {

    private final RaspunsTestService raspunsTestService;

    public RaspunsTestController(RaspunsTestService raspunsTestService) {
        this.raspunsTestService = raspunsTestService;
    }

    @GetMapping
    public List<RaspunsTest> getAll() {
        return raspunsTestService.getAll();
    }

    @PostMapping
    public RaspunsTest save(@RequestBody RaspunsTest raspunsTest) {
        return raspunsTestService.save(raspunsTest);
    }
}
