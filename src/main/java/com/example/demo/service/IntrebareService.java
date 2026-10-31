package com.example.demo.service;

import com.example.demo.entity.Intrebare;
import com.example.demo.repository.IntrebareRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntrebareService {

    private final IntrebareRepository intrebareRepository;

    public IntrebareService(IntrebareRepository intrebareRepository) {
        this.intrebareRepository = intrebareRepository;
    }

    public List<Intrebare> getAll() {
        return intrebareRepository.findAll();
    }

    public Intrebare save(Intrebare intrebare) {
        return intrebareRepository.save(intrebare);
    }
}
