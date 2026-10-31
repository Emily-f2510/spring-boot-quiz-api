package com.example.demo.controller;

import com.example.demo.entity.Raspuns;
import com.example.demo.service.RaspunsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/raspunsuri")
@CrossOrigin
public class RaspunsController {

    private final RaspunsService raspunsService;

    public RaspunsController(RaspunsService raspunsService) {
        this.raspunsService = raspunsService;
    }

    @GetMapping
    public List<Raspuns> getAll() {
        return raspunsService.getAll();
    }

    @PostMapping
    public Raspuns save(@RequestBody Raspuns raspuns) {
        return raspunsService.save(raspuns);
    }
}
