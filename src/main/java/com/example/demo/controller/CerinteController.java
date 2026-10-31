package com.example.demo.controller;

import com.example.demo.service.CerinteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cerinte")
@CrossOrigin(origins = "*")
public class CerinteController {

    private final CerinteService service;

    public CerinteController(CerinteService service) {
        this.service = service;
    }


    @GetMapping("/3a")
    public List<Object[]> cerinta3a() { return service.c3a(); }

    @GetMapping("/3b")
    public List<Object[]> cerinta3b() { return service.c3b(); }



    @GetMapping("/4a")
    public List<Object[]> cerinta4a() { return service.c4a(); }

    @GetMapping("/4b")
    public List<Object[]> cerinta4b() { return service.c4b(); }



    @GetMapping("/5a")
    public List<Object[]> cerinta5a() { return service.c5a(); }

    @GetMapping("/5b")
    public List<Object[]> cerinta5b() { return service.c5b(); }



    @GetMapping("/6a")
    public List<Object[]> cerinta6a() { return service.c6a(); }

    @GetMapping("/6b")
    public List<Object[]> cerinta6b() { return service.c6b(); }
}
