package com.example.demo.service;

import com.example.demo.entity.Test;
import com.example.demo.entity.TestKey;
import com.example.demo.repository.TestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    private final TestRepository testRepository;

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public List<Test> getAll() {
        return testRepository.findAll();
    }

    public Test save(Test test) {
        return testRepository.save(test);
    }
}
