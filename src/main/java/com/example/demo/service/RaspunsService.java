package com.example.demo.service;

import com.example.demo.entity.Raspuns;
import com.example.demo.entity.RaspunsKey;
import com.example.demo.repository.RaspunsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaspunsService {

    private final RaspunsRepository raspunsRepository;

    public RaspunsService(RaspunsRepository raspunsRepository) {
        this.raspunsRepository = raspunsRepository;
    }

    public List<Raspuns> getAll() {
        return raspunsRepository.findAll();
    }

    public Raspuns save(Raspuns raspuns) {
        return raspunsRepository.save(raspuns);
    }
}
