package com.example.demo.service;

import com.example.demo.entity.RaspunsTest;
import com.example.demo.entity.RaspunsTestKey;
import com.example.demo.repository.RaspunsTestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaspunsTestService {

    private final RaspunsTestRepository raspunsTestRepository;

    public RaspunsTestService(RaspunsTestRepository raspunsTestRepository) {
        this.raspunsTestRepository = raspunsTestRepository;
    }

    public List<RaspunsTest> getAll() {
        return raspunsTestRepository.findAll();
    }

    public RaspunsTest save(RaspunsTest raspunsTest) {
        return raspunsTestRepository.save(raspunsTest);
    }
}
