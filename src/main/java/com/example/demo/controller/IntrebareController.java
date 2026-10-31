package com.example.demo.controller;

import com.example.demo.entity.Intrebare;
import com.example.demo.service.IntrebareService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/intrebari")
@CrossOrigin
public class IntrebareController {

    private final IntrebareService intrebareService;

    public IntrebareController(IntrebareService intrebareService) {
        this.intrebareService = intrebareService;
    }

    @GetMapping
    public List<Intrebare> getAll() {
        return intrebareService.getAll();
    }

    @PostMapping
    public Intrebare save(@RequestBody Intrebare intrebare) {
        return intrebareService.save(intrebare);
    }
}
